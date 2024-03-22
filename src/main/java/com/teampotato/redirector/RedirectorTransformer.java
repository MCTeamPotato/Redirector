package com.teampotato.redirector;

import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodNode;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import java.util.ListIterator;
import java.util.Map;

public class RedirectorTransformer implements ClassFileTransformer {
    public static @NotNull String getSuperClass(byte[] clazz) {
        Map<Integer, Integer> utfMap = new Int2IntOpenHashMap();
        Map<Integer, Integer> classMap = new Int2IntOpenHashMap();
        int constantsCount = readUnsignedShort(clazz, 8);
        int passcount = 10;
        for (int i = 1; i < constantsCount; i++) {
            int size;
            switch (clazz[passcount]) {
                case 9:
                case 10:
                case 11:
                case 3:
                case 4:
                case 12:
                case 18:
                    size = 5;
                    break;
                case 5:
                case 6:
                    size = 9;
                    break;
                case 1://UTF8
                    int UTFSize = readUnsignedShort(clazz, passcount + 1);
                    size = 3 + UTFSize;
                    utfMap.put(i, passcount);
                    break;
                case 15:
                    size = 4;
                    break;
                case 7://class
                    size = 3;
                    int index = readUnsignedShort(clazz, passcount + 1);
                    classMap.put(i, index);
                    break;
                default:
                    size = 3;
                    break;
            }
            passcount += size;

        }
        passcount += 4;
        passcount = readUnsignedShort(clazz, passcount);
        passcount = classMap.get(passcount);
        passcount = utfMap.get(passcount);
        int UTFSize = readUnsignedShort(clazz, passcount + 1);
        return readUTF8(clazz, passcount + 3, UTFSize);
    }

    @Contract(pure = true)
    public static int readUnsignedShort(byte @NotNull [] b, int index) {
        return ((b[index] & 0xFF) << 8) | (b[index + 1] & 0xFF);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull String readUTF8(byte[] b, int index, int length) {
        char[] str = new char[length];
        for (int i = 0; i < length; i++) {
            str[i] = (char) b[i + index];
        }
        return new String(str);
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] basicClass) {
        try {
            String superClass = getSuperClass(basicClass);
            if (!"java/lang/Enum".equals(superClass)) return basicClass;
            ClassReader classReader = new ClassReader(basicClass);
            if ("java/lang/Enum".equals(classReader.getSuperName())) {
                ClassNode cn = new ClassNode();
                classReader.accept(cn, 0);
                for (MethodNode mn : cn.methods) {
                    if ("values".equals(mn.name) && mn.desc.contains("()")) {
                        InsnList il = mn.instructions;
                        ListIterator<AbstractInsnNode> iterator = il.iterator();
                        AbstractInsnNode n1 = null;
                        AbstractInsnNode n2 = null;
                        while (iterator.hasNext()) {
                            AbstractInsnNode note = iterator.next();
                            if (Opcodes.GETSTATIC == note.getOpcode()) {
                                n1 = note;
                            } else if (Opcodes.ARETURN == note.getOpcode()) {
                                n2 = note;
                            }
                        }
                        il.clear();
                        il.add(n1);
                        il.add(n2);
                    }
                }
                ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
                cn.accept(classWriter);
                Redirector.LOGGER.info("Redirecting ");
                return classWriter.toByteArray();
            }
        } catch (Exception e) {
            Redirector.LOGGER.error("Error occurs while transforming enum class. Skip.", e);
            return basicClass;
        }
        return basicClass;
    }
}
