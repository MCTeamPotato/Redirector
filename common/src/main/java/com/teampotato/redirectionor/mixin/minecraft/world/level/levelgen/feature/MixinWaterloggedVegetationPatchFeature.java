package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.feature;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.WaterloggedVegetationPatchFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WaterloggedVegetationPatchFeature.class)
public abstract class MixinWaterloggedVegetationPatchFeature {

    @Redirect(method = "isExposed", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
    private static Direction implEast() {
        return Redirectionor.EAST;
    }

    @Redirect(method = "isExposed", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
    private static Direction implNorth() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "isExposed", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private static Direction implSouth() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "isExposed", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;WEST:Lnet/minecraft/core/Direction;"))
    private static Direction implWest() {
        return Redirectionor.WEST;
    }

    @Redirect(method = "isExposed", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private static Direction implDown() {
        return Redirectionor.DOWN;
    }
}
