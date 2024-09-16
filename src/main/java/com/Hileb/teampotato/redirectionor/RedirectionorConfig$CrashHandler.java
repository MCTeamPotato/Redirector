/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.Hileb.teampotato.redirectionor.RedirectionorConfig
 *  com.Hileb.teampotato.redirectionor.RedirectionorConfig$Config
 *  cpw.mods.fml.common.ICrashCallable
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  net.minecraft.crash.CrashReport
 *  net.minecraft.launchwrapper.Launch
 */
package com.Hileb.teampotato.redirectionor;

import com.Hileb.teampotato.redirectionor.RedirectionorConfig;
import cpw.mods.fml.common.ICrashCallable;
import net.minecraft.crash.CrashReport;
import net.minecraft.launchwrapper.Launch;

/*
 * Exception performing whole class analysis ignored.
 */
public static class RedirectionorConfig.CrashHandler
implements ICrashCallable {
    public String call() {
        return "An automatic prefix block config generated";
    }

    public String getLabel() {
        return "Redirectionor is enabled. Check your enums!";
    }

    public static void handleCrash(CrashReport crashReport) {
        if (RedirectionorConfig.Config.generateConfigWhenCrash) {
            if ("ThisIsFake".equals((Object)crashReport.func_71501_a())) {
                return;
            }
            if (RedirectionorConfig.Config.isBlock) {
                for (StackTraceElement element : crashReport.func_71505_b().getStackTrace()) {
                    try {
                        Class cls = Class.forName((String)element.getClassName(), (boolean)false, (ClassLoader)Launch.classLoader);
                        if (!cls.isEnum()) continue;
                        RedirectionorConfig.Config.prefix.add((Object)cls.getName());
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        // empty catch block
                    }
                }
                RedirectionorConfig.save();
            }
        }
    }
}
