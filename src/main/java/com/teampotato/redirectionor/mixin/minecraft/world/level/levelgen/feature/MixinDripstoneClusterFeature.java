package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.feature;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.DripstoneClusterFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DripstoneClusterFeature.class)
public abstract class MixinDripstoneClusterFeature {
    @Redirect(method = "placeColumn", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
