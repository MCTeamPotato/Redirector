package com.Hileb.teampotato.redirectionor;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2023/8/28 11:52
 **/
public class RedirectionorTansformer implements IClassTransformer {
    boolean isDeBug=true;
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        try{
            ClassReader classReader=new ClassReader(basicClass);
            if ("java/lang/Enum".equals(classReader.getSuperName())){
                ClassNode cn=new ClassNode();
                classReader.accept(cn,0);

                String classPath= classReader.getClassName();
                String typeName="[L"+classPath+";";

                for(MethodNode mn:cn.methods){
                    if ("values".equals(mn.name)){
                        if (mn.desc.contains("()")){
                            InsnList il=mn.instructions;
                            il.clear();
                            il.add(new FieldInsnNode(Opcodes.GETSTATIC,classPath,"$VALUES",typeName));
                            il.add(new InsnNode(Opcodes.ARETURN));
                            if (isDeBug)System.out.println("Redirect "+classPath);
                            break;
                        }
                    }
                }
                ClassWriter classWriter=new ClassWriter(classReader,ClassWriter.COMPUTE_MAXS);
                cn.accept(classWriter);
                return classWriter.toByteArray();
            }
        }catch(Exception ignore){
            return basicClass;
        }
        return basicClass;
    }
}
