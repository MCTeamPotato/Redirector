package com.Hileb.teampotato.redirectionor;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.ListIterator;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2023/8/24 12:31
 **/
public class RedirectionorTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        try{
            if (!RedirectionorFastUtil.isEnum(basicClass) || !RedirectionorFastUtil.isAvailable(transformedName)){
                return basicClass;
            }
            ClassReader classReader = new ClassReader(basicClass);
            ClassNode cn = new ClassNode();
            classReader.accept(cn, 0);
            for(MethodNode mn:cn.methods){
                if ("values".equals(mn.name) && mn.desc.startsWith("()")){
                    ListIterator<AbstractInsnNode> iterator = mn.instructions.iterator();
                    AbstractInsnNode node;
                    while (iterator.hasNext()){
                        node = iterator.next();
                        int code = node.getOpcode();
                        if (code != Opcodes.GETSTATIC && code != Opcodes.ARETURN){
                            iterator.remove();
                        }
                    }
                    if (RedirectionorConfig.Config.printTransformedClasses) Redirectionor.LOGGER.info(transformedName);
                    ClassWriter classWriter = new ClassWriter(classReader, 0);
                    cn.accept(classWriter);
                    return classWriter.toByteArray();
                }
            }
            return basicClass;
        }catch (Exception ignore){
            return basicClass;
        }
    }
}
