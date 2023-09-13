package com.teampotato.redirector.forge.utils;

import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.ModLoadingStage;
import net.minecraftforge.fml.network.NetworkDirection;

public class CommonValues {
    public static final BiomeManager.BiomeType[] BIOME_TYPES = BiomeManager.BiomeType.values();
    public static final ModLoadingStage[] MOD_LOADING_STAGES = ModLoadingStage.values();
    public static final NetworkDirection[] NETWORK_DIRECTIONS = NetworkDirection.values();
}
