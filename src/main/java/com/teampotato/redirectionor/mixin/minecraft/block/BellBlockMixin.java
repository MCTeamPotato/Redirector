package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.BellBlock;
import net.minecraft.state.properties.BellAttachment;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BellBlock.class)
public abstract class BellBlockMixin {
    @Redirect(method = "getConnectedDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDown3() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "getConnectedDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private static Direction implUp() {
        return Redirectionor.UP;
    }
    @Redirect(method = "canSurvive", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown2() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "getStateForPlacement", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;X:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implX() {
        return Redirectionor.X;
    }

    @Redirect(method = "getStateForPlacement", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;Y:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implY() {
        return Redirectionor.Y;
    }

    @Redirect(method = "getStateForPlacement", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;Z:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implZ() {
        return Redirectionor.Z;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;FLOOR:Lnet/minecraft/state/properties/BellAttachment;"))
    private BellAttachment implFloor() {
        return Redirectionor.FLOOR_TYPE;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;CEILING:Lnet/minecraft/state/properties/BellAttachment;"))
    private BellAttachment implCeiling() {
        return Redirectionor.CEILING_TYPE;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;DOUBLE_WALL:Lnet/minecraft/state/properties/BellAttachment;"))
    private BellAttachment implDoubleWall() {
        return Redirectionor.DOUBLE_WALL_TYPE;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
    private Direction implEast() {
        return Redirectionor.EAST;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }
}
