package com.teampotato.redirector.forge.mixin.net.minecraftforge.common;

import com.teampotato.redirector.forge.utils.CommonValues;
import net.minecraftforge.common.BiomeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = BiomeManager.class, remap = false)
public abstract class BiomeManagerMixin {
    @Redirect(method = "setupBiomes", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/common/BiomeManager$BiomeType;values()[Lnet/minecraftforge/common/BiomeManager$BiomeType;"))
    private static BiomeManager.BiomeType[] redirectBiomeManagerBiomeTypes() {
        return CommonValues.BIOME_TYPES;
    }
}
