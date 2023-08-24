package com.teampotato.redirectionor.mixin.net.minecraftforge.common;

import net.minecraftforge.common.BiomeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = BiomeManager.class, remap = false)
public abstract class BiomeManagerMixin {
    @Unique
  private static final BiomeManager.BiomeType[] BIOME_TYPES = BiomeManager.BiomeType.values();

    @Redirect(method = "setupBiomes", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/common/BiomeManager$BiomeType;values()[Lnet/minecraftforge/common/BiomeManager$BiomeType;"))
    private static BiomeManager.BiomeType[] redirectBiomeManagerBiomeTypeValues() {
        return BIOME_TYPES;
    }
}
