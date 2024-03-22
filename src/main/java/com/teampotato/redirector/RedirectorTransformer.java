package com.teampotato.redirector;

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

public class RedirectorTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] basicClass) {
        try {
            String superClass = RedirectorFastUtil.getSuperClass(basicClass);
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
                return classWriter.toByteArray();
            }
        } catch (Exception e) {
            Redirector.LOGGER.error("Error occurs while transforming enum class. Skip.", e);
            return basicClass;
        }
        return basicClass;
    }
}
