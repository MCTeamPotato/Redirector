package com.Hileb.teampotato.redirectionor;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.tree.ClassNode;
import jdk.internal.org.objectweb.asm.tree.MethodNode;
import net.minecraft.launchwrapper.IClassTransformer;

import java.lang.reflect.Method;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2023/8/24 12:31
 **/
public class RedirectionorTansformer implements IClassTransformer {
    public static RedirectionorTansformer[] VALUESA;
    public static RedirectionorTansformer[] values(){
        return VALUESA;
    }
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        ClassReader classReader=new ClassReader(basicClass);
        if ("java/lang/Enum".equals(classReader.getSuperName())){
            ClassNode cn=new ClassNode();
            classReader.accept(cn,0);
            for(MethodNode mn:cn.methods){
                if ("values".equals(mn.name)){
                    if (mn.desc.contains("()")){
                        mn.getClass();



                    }
                }
            }
        }

        return basicClass;
    }
}
