package com.teampotato.redirector.forge.mixin.net.minecraft.world.level.newbiome.layer;

import com.teampotato.redirector.forge.utils.CommonValues;
import net.minecraft.world.level.newbiome.layer.BiomeInitLayer;
import net.minecraftforge.common.BiomeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BiomeInitLayer.class)
public abstract class BiomeInitLayerMixin {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/common/BiomeManager$BiomeType;values()[Lnet/minecraftforge/common/BiomeManager$BiomeType;", remap = false))
    private BiomeManager.BiomeType[] redirectBiomeManagerBiomeTypes() {
        return CommonValues.BIOME_TYPES;
    }
}
