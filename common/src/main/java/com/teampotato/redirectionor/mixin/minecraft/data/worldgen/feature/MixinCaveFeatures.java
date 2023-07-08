package com.teampotato.redirectionor.mixin.minecraft.data.worldgen.feature;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.features.CaveFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CaveFeatures.class)
public abstract class MixinCaveFeatures {
    @Redirect(method = "makeDripleaf", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private static Direction implUp() {
        return Redirectionor.UP;
    }

    @Redirect(method = "makeSmallDripleaf", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
    private static Direction implEast() {
        return Redirectionor.EAST;
    }

    @Redirect(method = "makeSmallDripleaf", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
    private static Direction implNorth() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "makeSmallDripleaf", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private static Direction implSouth() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "makeSmallDripleaf", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;WEST:Lnet/minecraft/core/Direction;"))
    private static Direction implWest() {
        return Redirectionor.WEST;
    }
}
