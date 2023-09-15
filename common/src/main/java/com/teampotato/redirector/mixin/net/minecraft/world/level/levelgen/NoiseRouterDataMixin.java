package com.teampotato.redirector.mixin.net.minecraft.world.level.levelgen;

import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.OreVeinifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.OptionalInt;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@Mixin(NoiseRouterData.class)
public abstract class NoiseRouterDataMixin {
    @Unique
    private static OreVeinifier.VeinType[] VEIN_TYPES;

    @Redirect(method = "overworld", at = @At(value = "INVOKE", target = "Ljava/util/OptionalInt;orElse(I)I", ordinal = 0))
    private static int setJ(OptionalInt instance, int i) {
        if (VEIN_TYPES == null) VEIN_TYPES = OreVeinifier.VeinType.values();
        int minY = i;
        for (OreVeinifier.VeinType veinType : VEIN_TYPES) {
            int veinMinY = veinType.minY;
            if (veinMinY < minY) minY = veinMinY;
        }
        return minY;
    }

    @Redirect(method = "overworld", at = @At(value = "INVOKE", target = "Ljava/util/OptionalInt;orElse(I)I", ordinal = 1))
    private static int setK(OptionalInt instance, int i) {
        if (VEIN_TYPES == null) VEIN_TYPES = OreVeinifier.VeinType.values();
        int maxY = i;
        for (OreVeinifier.VeinType veinType : VEIN_TYPES) {
            int veinMaxY = veinType.maxY;
            if (veinMaxY > maxY) maxY = veinMaxY;
        }
        return maxY;
    }
}
