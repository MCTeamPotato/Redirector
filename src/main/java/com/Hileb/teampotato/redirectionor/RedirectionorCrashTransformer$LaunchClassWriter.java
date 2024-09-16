/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.TypeNotPresentException
 *  net.minecraft.launchwrapper.Launch
 *  net.minecraft.launchwrapper.LaunchClassLoader
 *  org.objectweb.asm.ClassReader
 *  org.objectweb.asm.ClassWriter
 */
package com.Hileb.teampotato.redirectionor;

import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public static class RedirectionorCrashTransformer.LaunchClassWriter
extends ClassWriter {
    public RedirectionorCrashTransformer.LaunchClassWriter(ClassReader classReader, int flags) {
        super(classReader, flags);
    }

    protected String getCommonSuperClass(String type1, String type2) {
        return RedirectionorCrashTransformer.LaunchClassWriter.getCommonSuperClass0(type1, type2);
    }

    public static String getCommonSuperClass0(String type1, String type2) {
        Class class2;
        Class class1;
        ClassLoader classLoader = LaunchClassLoader.class.getClassLoader();
        try {
            class1 = Class.forName((String)type1.replace('/', '.'), (boolean)false, (ClassLoader)classLoader);
        }
        catch (ClassNotFoundException e) {
            try {
                class1 = Class.forName((String)type1.replace('/', '.'), (boolean)false, (ClassLoader)Launch.classLoader);
            }
            catch (ClassNotFoundException e1) {
                throw new TypeNotPresentException(type1, (Throwable)e1);
            }
        }
        try {
            class2 = Class.forName((String)type2.replace('/', '.'), (boolean)false, (ClassLoader)classLoader);
        }
        catch (ClassNotFoundException e) {
            try {
                class2 = Class.forName((String)type2.replace('/', '.'), (boolean)false, (ClassLoader)Launch.classLoader);
            }
            catch (ClassNotFoundException e2) {
                throw new TypeNotPresentException(type2, (Throwable)e2);
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
        }
        while (!(class1 = class1.getSuperclass()).isAssignableFrom(class2)) {
        }
        return class1.getName().replace('.', '/');
    }
}
