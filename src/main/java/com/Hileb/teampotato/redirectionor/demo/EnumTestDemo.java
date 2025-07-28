package com.Hileb.teampotato.redirectionor.demo;

import com.Hileb.teampotato.redirectionor.Redirectionor;
import com.google.common.eventbus.Subscribe;
import net.minecraft.client.shader.ShaderLoader;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class EnumTestDemo {

    @Subscribe
    public void onLaunch(FMLPostInitializationEvent event) {
        enumFacing();
    }

    public static void enumFacing(){
        Redirectionor.LOGGER.info("test ShaderLoader.ShaderType");
        ShaderLoader.ShaderType.values()[0] = ShaderLoader.ShaderType.values()[1];
        for (ShaderLoader.ShaderType enumFacing : ShaderLoader.ShaderType.values()) {
            Redirectionor.LOGGER.info(enumFacing.name() + enumFacing.ordinal());
        }
    }
}
