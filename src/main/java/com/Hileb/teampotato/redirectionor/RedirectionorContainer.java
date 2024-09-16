/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.Hileb.teampotato.redirectionor.RedirectionorConfig$CrashHandler
 *  com.google.common.eventbus.EventBus
 *  cpw.mods.fml.common.DummyModContainer
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.common.LoadController
 *  cpw.mods.fml.common.ModMetadata
 *  cpw.mods.fml.common.ObfuscationReflectionHelper
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.Hileb.teampotato.redirectionor;

import com.Hileb.teampotato.redirectionor.RedirectionorConfig;
import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import java.util.List;

public class RedirectionorContainer
extends DummyModContainer {
    public RedirectionorContainer() {
        super(new ModMetadata());
        ModMetadata metadata = this.getMetadata();
        metadata.modId = "redirectionor";
        metadata.name = "Redirectionor";
        metadata.description = "Redirectionor is the implementation of this concept, specifically for the Direction enum class stuff, to reduce the required memory of the game.";
        metadata.version = "1.7 for 1.7.10";
        metadata.url = "https://www.curseforge.com/minecraft/mc-mods/redirectionor";
        metadata.logoFile = "/icon_redirectionor.png";
        metadata.authorList.add((Object)"MCTeamPotato");
        metadata.authorList.add((Object)"Kasualix");
        metadata.authorList.add((Object)"Hileb");
    }

    public boolean registerBus(EventBus bus, LoadController controller) {
        RedirectionorContainer.onConstruct();
        return true;
    }

    public static void onConstruct() {
        List crashCallables = (List)ObfuscationReflectionHelper.getPrivateValue(FMLCommonHandler.class, (Object)FMLCommonHandler.instance(), (String[])new String[]{"crashCallables"});
        crashCallables.add((Object)new RedirectionorConfig.CrashHandler());
    }
}
