package com.teampotato.redirector;

import cpw.mods.modlauncher.serviceapi.ILaunchPluginService;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
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
            String name = classNode.name;
            if ("java/lang/Enum".equals(classNode.superName)) {
                for(MethodNode methodNode : classNode.methods){
                    if ("values".equals(methodNode.name) && methodNode.desc.contains("()")){
                        InsnList insnNodes = methodNode.instructions;
                        ListIterator<AbstractInsnNode> iterator = insnNodes.iterator();
                        AbstractInsnNode n1 = null;
                        AbstractInsnNode n2 = null;
                        while (iterator.hasNext()) {
                            AbstractInsnNode node = iterator.next();
                            if (Opcodes.GETSTATIC == node.getOpcode()) {
                                n1 = node;
                            } else if (Opcodes.ARETURN == node.getOpcode()) {
                                n2 = node;
                            }
                        }
                        insnNodes.clear();
                        insnNodes.add(n1);
                        insnNodes.add(n2);
                        Redirector.LOGGER.info("Redirecting " + name);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
