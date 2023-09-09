package com.Hileb.teampotato.redirectionor;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.util.ListIterator;

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
            String superClass=RedirectionorFastUtil.getSuperClass(basicClass);
            if (!"java/lang/Enum".equals(superClass) || !RedirectionorFastUtil.isAvailable(transformedName)){
                return basicClass;
            }
            ClassReader classReader=new ClassReader(basicClass);
            if ("java/lang/Enum".equals(classReader.getSuperName())){
                ClassNode cn=new ClassNode();
                classReader.accept(cn,0);
                String classPath= classReader.getClassName();
                String type="[L"+classPath+";";
                for(MethodNode mn:cn.methods){
                    if ("values".equals(mn.name) && mn.desc.contains("()")){
                        InsnList il=mn.instructions;
                        ListIterator<AbstractInsnNode> iterator=il.iterator();
                        AbstractInsnNode n1 = null;
                        AbstractInsnNode n2 = null;
                        while (iterator.hasNext()){
                            AbstractInsnNode note=iterator.next();
                            if (Opcodes.GETSTATIC== note.getOpcode()){
                                n1=note;
                            }else if (Opcodes.ARETURN==note.getOpcode()){
                                n2=note;
                            }
                        }
                        //il.add(new FieldInsnNode(Opcodes.GETSTATIC,classPath,"$VALUES",type));//178
//                        AbstractInsnNode n1=il.get(2);
//                        //il.add(new InsnNode(Opcodes.ARETURN));//176
//                        AbstractInsnNode n2=il.get(5);
                        il.clear();
                        il.add(n1);
                        il.add(n2);
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
