package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.structure.StrongholdPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public abstract class StrongholdPiecesMixin {
    @Mixin(StrongholdPieces.Corridor.class)
    public abstract static class CorridorMixin {
        @Redirect(method = "<init>(ILnet/minecraft/util/math/MutableBoundingBox;Lnet/minecraft/util/Direction;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
        private Direction implSouth() {
            return Redirectionor.SOUTH;
        }
    }

    @Mixin(StrongholdPieces.LeftTurn.class)
    public abstract static class LeftTurnMixin {
        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
        private Direction implNorth() {
            return Redirectionor.NORTH;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }
    }

    @Mixin(targets = "net.minecraft.world.gen.feature.structure.StrongholdPieces$Stronghold")
    public abstract static class StrongholdMixin {
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
    }
}
