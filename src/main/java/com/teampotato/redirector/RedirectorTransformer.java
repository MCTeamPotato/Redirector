package com.teampotato.redirector;

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

    public static boolean isEnum(byte[] clazz){
        int constantsCount = readUnsignedShort(clazz,8);
        int passcount = 10;
        for(int i = 1; i < constantsCount; i++){
            int size = 0;
            switch (clazz[passcount]){
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
                case 1:
                    size = 3 + readUnsignedShort(clazz, passcount + 1);
                    break;
                case 15:
                    size = 4;
                    break;
                default:
                    size = 3;
                    break;
            }
            passcount += size;
        }
        passcount = readUnsignedShort(clazz, passcount);
        return (passcount & 16384) !=0;
    }

    @Contract(pure = true)
    public static int readUnsignedShort(byte @NotNull [] b, int index) {
        return ((b[index] & 0xFF) << 8) | (b[index + 1] & 0xFF);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull String readUTF8(byte[] src, int index, int length) {
        byte[] str = new byte[length];
        System.arraycopy(src, index, str, 0, length);
        return new String(str);
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] basicClass) {
        if(baiscClass == null) return null;
        try {
            if (!isEnum(basicClass))) return basicClass;
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
                        break;
                    }
                }
                ClassWriter classWriter = new ClassWriter(classReader, 0); // No frame actually
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
