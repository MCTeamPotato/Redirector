/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.Hileb.teampotato.redirectionor.RedirectionorConfig
 *  cpw.mods.fml.relauncher.CoreModManager
 *  cpw.mods.fml.relauncher.IFMLLoadingPlugin
 *  cpw.mods.fml.relauncher.IFMLLoadingPlugin$MCVersion
 *  cpw.mods.fml.relauncher.IFMLLoadingPlugin$Name
 *  java.io.File
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Map
 *  javax.annotation.Nullable
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package com.Hileb.teampotato.redirectionor;

import com.Hileb.teampotato.redirectionor.RedirectionorConfig;
import cpw.mods.fml.relauncher.CoreModManager;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.io.File;
import java.util.Map;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@IFMLLoadingPlugin.Name(value="redirectionor")
@IFMLLoadingPlugin.MCVersion(value="1.7.10")
public class Redirectionor
implements IFMLLoadingPlugin {
    public static final String MODID = "redirectionor";
    public static final Logger LOGGER = LogManager.getLogger((String)"redirectionor");

    public Redirectionor() {
        try {
            RedirectionorConfig.initConfig();
        }
        catch (Exception e) {
            throw new RuntimeException("unable to set up config for redirectionor", (Throwable)e);
        }
    }

    public static void makeFMLCorePluginContainsFMLMod(File file) {
        String name = file.getName();
        CoreModManager.getIgnoredMods().remove((Object)name);
        CoreModManager.getReparseableCoremods().add((Object)name);
    }

    public String[] getASMTransformerClass() {
        return new String[]{"com.Hileb.teampotato.redirectionor.RedirectionorTransformer", "com.Hileb.teampotato.redirectionor.RedirectionorCrashTransformer"};
    }

    public String getModContainerClass() {
        return "com.Hileb.teampotato.redirectionor.RedirectionorContainer";
    }

    @Nullable
    public String getSetupClass() {
        return null;
    }

    public void injectData(Map<String, Object> data) {
    }

    public String getAccessTransformerClass() {
        return null;
    }
}
