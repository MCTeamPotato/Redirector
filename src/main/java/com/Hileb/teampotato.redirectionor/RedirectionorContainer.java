package com.Hileb.teampotato.redirectionor;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

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
        metadata.version="1.3 for 1.7.10";
        metadata.url="https://www.curseforge.com/minecraft/mc-mods/redirectionor";
        metadata.logoFile="/icon_redirectionor.png";
        metadata.authorList.add("MCTeamPotato");
        metadata.authorList.add("Kasualix");
        metadata.authorList.add("Hileb");
    }

    @Override
    public boolean registerBus(com.google.common.eventbus.EventBus bus, LoadController controller) {
        return true;
    }
}
