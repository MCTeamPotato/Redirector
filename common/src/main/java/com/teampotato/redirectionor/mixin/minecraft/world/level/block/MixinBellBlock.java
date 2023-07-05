package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BellBlock;
import net.minecraft.world.level.block.state.properties.BellAttachType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BellBlock.class)
public abstract class MixinBellBlock {

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BellAttachType;FLOOR:Lnet/minecraft/world/level/block/state/properties/BellAttachType;"))
    private BellAttachType implFloor() {
        return Redirectionor.FLOOR_TYPE;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BellAttachType;CEILING:Lnet/minecraft/world/level/block/state/properties/BellAttachType;"))
    private BellAttachType implCeiling() {
        return Redirectionor.CEILING_TYPE;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BellAttachType;DOUBLE_WALL:Lnet/minecraft/world/level/block/state/properties/BellAttachType;"))
    private BellAttachType implDoubleWall() {
        return Redirectionor.DOUBLE_WALL_TYPE;
    }


    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
    private Direction implEast() {
        return Redirectionor.EAST;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "getConnectedDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private static Direction implUp() {
        return Redirectionor.UP;
    }

    @Redirect(method = "getConnectedDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private static Direction implDown() {
        return Redirectionor.DOWN;
    }
}
