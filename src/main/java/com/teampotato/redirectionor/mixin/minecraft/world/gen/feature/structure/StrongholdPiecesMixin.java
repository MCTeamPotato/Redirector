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

        @Redirect(method = "<init>(ILnet/minecraft/util/math/MutableBoundingBox;Lnet/minecraft/util/Direction;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
        private Direction implNorth() {
            return Redirectionor.SOUTH;
        }
    }

    @Mixin(StrongholdPieces.Crossing.class)
    public abstract static class CrossingMixin {
        @Redirect(method = "addChildren", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
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

    @Mixin(StrongholdPieces.Library.class)
    public abstract static class LibraryMixin {
        @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }

        @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
        }
    }

    @Mixin(StrongholdPieces.PortalRoom.class)
    public abstract static class PortalRoomMixin {
        @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }

        @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
        }
    }

    @Mixin(StrongholdPieces.Prison.class)
    public abstract static class PrisonMixin {
        @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
        }
    }

    @Mixin(StrongholdPieces.RightTurn.class)
    public abstract static class RightTurnMixin {
        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }
    }

    @Mixin(StrongholdPieces.RoomCrossing.class)
    public abstract static class RoomCrossingMixin {
        @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }

        @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
        }
    }

    @Mixin(StrongholdPieces.Straight.class)
    public abstract static class StraightMixin {
        @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }

        @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
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
