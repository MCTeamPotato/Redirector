package com.Hileb.teampotato.redirectionor;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.tree.*;
import net.minecraft.launchwrapper.IClassTransformer;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2023/8/24 12:31
 **/
public class RedirectionorTansformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        ClassReader classReader=new ClassReader(basicClass);
        if ("java/lang/Enum".equals(classReader.getSuperName())){
            ClassNode cn=new ClassNode();
            classReader.accept(cn,0);
            for(MethodNode mn:cn.methods){
                if ("values".equals(mn.name)){
                    if (mn.desc.contains("()")){
                        String classPath= classReader.getClassName();
                        InsnList il=mn.instructions;
                        il.clear();
                        il.add(new FieldInsnNode(Opcodes.GETSTATIC,classPath,"$VALUES","[L"+classPath+";"));
                        il.add(new InsnNode(Opcodes.RETURN));

                    }
                }
            }
        }

        return basicClass;
    }
}
