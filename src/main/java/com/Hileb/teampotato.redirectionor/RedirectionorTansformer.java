package com.Hileb.teampotato.redirectionor;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;
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
                        String typeName="[L"+classPath+";";
                        /*
                        value function:

                        public static values()[Lcom/Hileb/teampotato/redirectionor/TestEnum;
                        GETSTATIC com/Hileb/teampotato/redirectionor/TestEnum.$VALUES : [Lcom/Hileb/teampotato/redirectionor/TestEnum;

                         //delete this:
                         INVOKEVIRTUAL [Lcom/Hileb/teampotato/redirectionor/TestEnum;.clone ()Ljava/lang/Object;
                        CHECKCAST [Lcom/Hileb/teampotato/redirectionor/TestEnum;

                        ARETURN
                        MAXSTACK = 1
                        MAXLOCALS = 0
                        * */
                        InsnList il=mn.instructions;
                        il.clear();
                        il.add(new FieldInsnNode(Opcodes.GETSTATIC,classPath,"$VALUES",typeName));
                        il.add(new InsnNode(Opcodes.ARETURN));

                        System.out.println("Redirect "+classPath);
                    }
                }
            }
            ClassWriter classWriter=new ClassWriter(classReader,ClassWriter.COMPUTE_MAXS);
            cn.accept(classWriter);
            return classWriter.toByteArray();
        }

        return basicClass;
    }
}
