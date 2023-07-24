package com.teampotato.redirectionor.fabric;

import net.fabricmc.api.ModInitializer;

public class RedirectionorFabric implements ModInitializer {
    public void onInitialize() {
        System.out.println("Redirectionor loaded. It's possible that you have seen some Mixin Apply Failed warning log, but you just don't need care much about them because it's simply override by other optimization mods which hopefully did the same thing.");
    }
}