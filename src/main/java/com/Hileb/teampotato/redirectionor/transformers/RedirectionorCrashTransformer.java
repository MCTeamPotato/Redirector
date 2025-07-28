package com.Hileb.teampotato.redirectionor.transformers;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

@SuppressWarnings("unused")
public class RedirectionorCrashTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if ("net.minecraftforge.fml.common.FMLCommonHandler".equals(transformedName)){
            ClassReader classReader = new ClassReader(basicClass);
            ClassNode cn = new ClassNode();
            classReader.accept(cn, 0);
            for(MethodNode methodNode : cn.methods){
                if ("enhanceCrashReport".equals(methodNode.name)){ // The FML hook never changed it's name
                    InsnList hook = new InsnList();
                    hook.add(new VarInsnNode(Opcodes.ALOAD, 1));
                    hook.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "com/Hileb/teampotato/redirectionor/RedirectionorConfig$CrashHandler", "handleCrash", "(Lnet/minecraft/crash/CrashReport;)V", false));
                    methodNode.instructions.insert(hook);
                    ClassWriter classWriter = new ClassWriter(classReader, 0);
                    cn.accept(classWriter);
                    return classWriter.toByteArray();
                }
            }
        }
        return basicClass;
    }
}
