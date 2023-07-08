package com.teampotato.redirectionor.mixin.minecraft.util;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Direction.class)
public abstract class DirectionMixin {
    @Redirect(method = "fromAxisAndDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "fromAxisAndDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
    private static Direction implEast() {
        return Redirectionor.EAST;
    }

    @Redirect(method = "fromAxisAndDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private static Direction implNorth() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "fromAxisAndDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
    private static Direction implSouth() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "fromAxisAndDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private static Direction implUp() {
        return Redirectionor.UP;
    }

    @Redirect(method = "fromAxisAndDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
    private static Direction implWest() {
        return Redirectionor.WEST;
    }

    @Redirect(method = "fromAxisAndDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$AxisDirection;POSITIVE:Lnet/minecraft/util/Direction$AxisDirection;"))
    private static Direction.AxisDirection implPositive() {
        return Redirectionor.POSITIVE;
    }
}
