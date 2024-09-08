package com.Hileb.teampotato.redirectionor;

import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2024/9/8 22:32
 **/
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
                    return new LaunchClassWriter(classReader, ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES).toByteArray();
                }
            }
        }
        return basicClass;
    }

    //Fix the crash of calling getCommonSuperClass
    //Usually, the crash from the obfuscated environment
    public static class LaunchClassWriter extends ClassWriter{

        public LaunchClassWriter(ClassReader classReader, int flags) {
            super(classReader, flags);
        }

        @Override
        protected String getCommonSuperClass(String type1, String type2) {
            return getCommonSuperClass0(type1, type2);
        }

        public static String getCommonSuperClass0(final String type1, final String type2) {
            ClassLoader classLoader = LaunchClassLoader.class.getClassLoader();
            Class<?> class1;
            try {
                class1 = Class.forName(type1.replace('/', '.'), false, classLoader);
            } catch (ClassNotFoundException e) {
                try {
                    class1 = Class.forName(type1.replace('/', '.'), false, Launch.classLoader);
                } catch (ClassNotFoundException e1) {
                    throw new TypeNotPresentException(type1, e1);
                }
            }
            Class<?> class2;
            try {
                class2 = Class.forName(type2.replace('/', '.'), false, classLoader);
            } catch (ClassNotFoundException e) {
                try {
                    class2 = Class.forName(type2.replace('/', '.'), false, Launch.classLoader);
                } catch (ClassNotFoundException e2) {
                    throw new TypeNotPresentException(type2, e2);
                }
            }
            if (class1.isAssignableFrom(class2)) {
                return type1;
            }
            if (class2.isAssignableFrom(class1)) {
                return type2;
            }
            if (class1.isInterface() || class2.isInterface()) {
                return "java/lang/Object";
            } else {
                do {
                    class1 = class1.getSuperclass();
                } while (!class1.isAssignableFrom(class2));
                return class1.getName().replace('.', '/');
            }
        }
    }
}
