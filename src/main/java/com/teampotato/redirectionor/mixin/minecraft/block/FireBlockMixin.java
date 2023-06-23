package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.FireBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FireBlock.class)
public abstract class FireBlockMixin {
    @Redirect(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }

    @Redirect(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "getStateForPlacement(Lnet/minecraft/world/IBlockReader;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "isValidFireLocation", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt2() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "getFireOdds", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt3() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
    private Direction implWest() {
        return Redirectionor.WEST;
    }

    @Redirect(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
    private Direction implEast() {
        return Redirectionor.EAST;
    }
}
