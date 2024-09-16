/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.Hileb.teampotato.redirectionor.RedirectionorCrashTransformer$LaunchClassWriter
 *  java.lang.Object
 *  java.lang.String
 *  net.minecraft.launchwrapper.IClassTransformer
 *  org.objectweb.asm.ClassReader
 *  org.objectweb.asm.ClassVisitor
 *  org.objectweb.asm.tree.AbstractInsnNode
 *  org.objectweb.asm.tree.ClassNode
 *  org.objectweb.asm.tree.InsnList
 *  org.objectweb.asm.tree.MethodInsnNode
 *  org.objectweb.asm.tree.MethodNode
 *  org.objectweb.asm.tree.VarInsnNode
 */
package com.Hileb.teampotato.redirectionor;

import com.Hileb.teampotato.redirectionor.RedirectionorCrashTransformer;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class RedirectionorCrashTransformer
implements IClassTransformer {
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if ("net.minecraftforge.fml.common.FMLCommonHandler".equals((Object)transformedName)) {
            ClassReader classReader = new ClassReader(basicClass);
            ClassNode cn = new ClassNode();
            classReader.accept((ClassVisitor)cn, 0);
            for (MethodNode methodNode : cn.methods) {
                if (!"enhanceCrashReport".equals((Object)methodNode.name)) continue;
                InsnList hook = new InsnList();
                hook.add((AbstractInsnNode)new VarInsnNode(25, 1));
                hook.add((AbstractInsnNode)new MethodInsnNode(184, "com/Hileb/teampotato/redirectionor/RedirectionorConfig$CrashHandler", "handleCrash", "(Lnet/minecraft/crash/CrashReport;)V", false));
                methodNode.instructions.insert(hook);
                LaunchClassWriter classWriter = new LaunchClassWriter(classReader, 3);
                cn.accept((ClassVisitor)classWriter);
                return classWriter.toByteArray();
            }
        }
        return basicClass;
    }
}
