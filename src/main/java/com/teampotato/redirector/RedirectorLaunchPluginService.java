package com.teampotato.redirector;

import cpw.mods.modlauncher.serviceapi.ILaunchPluginService;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.EnumSet;
import java.util.ListIterator;

public class RedirectorLaunchPluginService implements ILaunchPluginService {
    @Override
    public String name() {
        return Redirector.MOD_ID;
    }

    @Override
    public EnumSet<Phase> handlesClass(Type classType, boolean isEmpty) {
        return EnumSet.of(Phase.AFTER);
    }

    @Override
    public boolean processClass(Phase phase, ClassNode classNode, Type classType, String reason) {
        if (phase == Phase.BEFORE) {
            return false;
        } else if ("classloading".equals(reason)) {
            if ("java/lang/Enum".equals(classNode.superName)) {
                for (MethodNode methodNode : classNode.methods) {
                    if ("values".equals(methodNode.name) && methodNode.desc != null && methodNode.desc.contains("[L" + classNode.name + ";")) {
                        ListIterator<AbstractInsnNode> iterator = methodNode.instructions.iterator();
                        while (iterator.hasNext()) {
                            AbstractInsnNode node = iterator.next();
                            if (node instanceof MethodInsnNode && "clone".equals(((MethodInsnNode) node).name)) {
                                iterator.remove();
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
