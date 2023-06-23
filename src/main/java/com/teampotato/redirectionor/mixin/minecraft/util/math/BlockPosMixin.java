package com.teampotato.redirectionor.mixin.minecraft.util.math;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockPos.class)
public abstract class BlockPosMixin {
    @Redirect(method = "below()Lnet/minecraft/util/math/BlockPos;", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown1() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "below(I)Lnet/minecraft/util/math/BlockPos;", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown2() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "above()Lnet/minecraft/util/math/BlockPos;", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"), remap = false)
    private Direction implUp1() {
        return Redirectionor.UP;
    }

    @Redirect(method = "above(I)Lnet/minecraft/util/math/BlockPos;", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"), remap = false)
    private Direction implUp2() {
        return Redirectionor.UP;
    }

    @Redirect(method = "north()Lnet/minecraft/util/math/BlockPos;", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth1() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "north(I)Lnet/minecraft/util/math/BlockPos;", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth2() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "south()Lnet/minecraft/util/math/BlockPos;", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
    private Direction implSouth1() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "south(I)Lnet/minecraft/util/math/BlockPos;", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
    private Direction implSouth2() {
        return Redirectionor.SOUTH;
    }
}
