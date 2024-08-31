package com.Hileb.teampotato.redirectionor;

import com.google.common.eventbus.EventBus;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2023/8/28 10:05
 **/
public class RedirectionorContainer extends DummyModContainer {
    public RedirectionorContainer(){
        super(new ModMetadata());
        ModMetadata metadata=this.getMetadata();
        metadata.modId=Redirectionor.MODID;
        metadata.name="Redirectionor";
        metadata.description="Redirectionor is the implementation of this concept, specifically for the Direction enum class stuff, to reduce the required memory of the game.";
        metadata.version="1.5 for 1.12.2-1.8.8";
        metadata.url="https://www.curseforge.com/minecraft/mc-mods/redirectionor";
        metadata.logoFile="/icon_redirectionor.png";
        metadata.authorList.add("MCTeamPotato");
        metadata.authorList.add("Kasualix");
        metadata.authorList.add("Hileb");
    }
    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        onConstruct();
        return true;
    }

    public static void onConstruct(){
        ObfuscationReflectionHelper.setPrivateValue(FMLCommonHandler.class, FMLCommonHandler.instance(), new RedirectionorConfig.CrashHandler(), "crashCallables");
    }
}
