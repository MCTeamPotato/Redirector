package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.structure.WoodlandMansionPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public abstract class WoodlandMansionPiecesMixin {
    @Mixin(targets = "net.minecraft.world.gen.feature.structure.WoodlandMansionPieces$Grid")
    public abstract static class GridMixin {
        @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
        }

        @Redirect(method = "recursiveCorridor", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }
    }

    @Mixin(WoodlandMansionPieces.MansionTemplate.class)
    public abstract static class MansionTemplateMixin {
        @Redirect(method = "handleDataMarker", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
        private Direction implNorth() {
            return Redirectionor.NORTH;
        }

        @Redirect(method = "handleDataMarker", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
        private Direction implSouth() {
            return Redirectionor.SOUTH;
        }

        @Redirect(method = "handleDataMarker", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
        }

        @Redirect(method = "handleDataMarker", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }
    }

    @Mixin(targets = "net.minecraft.world.gen.feature.structure.WoodlandMansionPieces$Placer")
    public abstract static class PlacerMixin {
        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
        private Direction implNorth() {
            return Redirectionor.NORTH;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
        private Direction implSouth() {
            return Redirectionor.SOUTH;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
        private Direction implUp() {
            return Redirectionor.UP;
        }
    }
}
