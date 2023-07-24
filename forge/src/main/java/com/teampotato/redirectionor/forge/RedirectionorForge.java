package com.teampotato.redirectionor.forge;

import net.minecraftforge.fml.common.Mod;

@Mod(RedirectionorForge.ID)
public class RedirectionorForge {
    public static final String ID = "redirectionor";

    public RedirectionorForge() {
        System.out.println("Redirectionor loaded. It's possible that you have seen some Mixin Apply Failed warning log, but you just don't need care much about them because it's simply override by other optimization mods which hopefully did the same thing.");
    }
}