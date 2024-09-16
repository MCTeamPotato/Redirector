/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.Hileb.teampotato.redirectionor.Redirectionor
 *  com.Hileb.teampotato.redirectionor.RedirectionorConfig$Config
 *  com.Hileb.teampotato.redirectionor.RedirectionorFastUtil
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ListIterator
 *  net.minecraft.launchwrapper.IClassTransformer
 *  org.objectweb.asm.ClassReader
 *  org.objectweb.asm.ClassVisitor
 *  org.objectweb.asm.ClassWriter
 *  org.objectweb.asm.tree.AbstractInsnNode
 *  org.objectweb.asm.tree.ClassNode
 *  org.objectweb.asm.tree.MethodNode
 */
package com.Hileb.teampotato.redirectionor;

import com.Hileb.teampotato.redirectionor.Redirectionor;
import com.Hileb.teampotato.redirectionor.RedirectionorConfig;
import com.Hileb.teampotato.redirectionor.RedirectionorFastUtil;
import java.util.ListIterator;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class RedirectionorTransformer
implements IClassTransformer {
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        try {
            if (!RedirectionorFastUtil.isEnum((byte[])basicClass) || !RedirectionorFastUtil.isAvailable((String)transformedName)) {
                return basicClass;
            }
            ClassReader classReader = new ClassReader(basicClass);
            ClassNode cn = new ClassNode();
            classReader.accept((ClassVisitor)cn, 0);
            for (MethodNode mn : cn.methods) {
                if (!"values".equals((Object)mn.name) || !mn.desc.startsWith("()")) continue;
                ListIterator iterator = mn.instructions.iterator();
                while (iterator.hasNext()) {
                    AbstractInsnNode node = (AbstractInsnNode)iterator.next();
                    int code = node.getOpcode();
                    if (code == 178 || code == 176) continue;
                    iterator.remove();
                }
                if (RedirectionorConfig.Config.printTransformedClasses) {
                    Redirectionor.LOGGER.info("Redirectionor : " + transformedName);
                }
                ClassWriter classWriter = new ClassWriter(classReader, 0);
                cn.accept((ClassVisitor)classWriter);
                return classWriter.toByteArray();
            }
            return basicClass;
        }
        catch (Exception ignore) {
            return basicClass;
        }
    }
}
