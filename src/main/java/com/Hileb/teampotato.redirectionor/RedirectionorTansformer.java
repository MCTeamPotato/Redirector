package com.Hileb.teampotato.redirectionor;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2023/8/24 12:31
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
                String type="[L"+classPath+";";
                String funcName="()"+type;
                for(MethodNode mn:cn.methods){
                    if ("values".equals(mn.name) || funcName.equals(mn.desc)){
                        InsnList il=new InsnList();
                        il.add(new FieldInsnNode(Opcodes.GETSTATIC,classPath,"$VALUES",type));
                        il.add(new InsnNode(Opcodes.ARETURN));
                        mn.instructions=il;
                        if (isDeBug)System.out.println("Redirect "+transformedName);
                    }
                }
                ClassWriter classWriter=new ClassWriter(classReader,ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
                cn.accept(classWriter);
                return classWriter.toByteArray();
            }
        }catch (Exception ignore){
            return basicClass;
        }
        return basicClass;
    }
}
