package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.FourWayBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FourWayBlock.class)
public abstract class FourWayBlockMixin {
    @Redirect(method = "lambda$getAABBIndex$1", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private static Direction implNorth() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "lambda$getAABBIndex$1", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
    private static Direction implEast() {
        return Redirectionor.EAST;
    }

    @Redirect(method = "lambda$getAABBIndex$1", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
    private static Direction implWest() {
        return Redirectionor.WEST;
    }

    @Redirect(method = "lambda$getAABBIndex$1", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
    private static Direction implSouth() {
        return Redirectionor.SOUTH;
    }
}
