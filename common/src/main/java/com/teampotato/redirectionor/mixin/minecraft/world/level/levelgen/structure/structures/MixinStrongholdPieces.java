package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.structure.structures;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.structures.StrongholdPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public abstract class MixinStrongholdPieces {

    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.StrongholdPieces$StrongholdPiece")
    public abstract static class MixinStrongholdPiece {
        @Redirect(method = "generateSmallDoorChildRight", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }

        @Redirect(method = "generateSmallDoor", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
        private Direction implSouth1() {
            return Redirectionor.SOUTH;
        }

        @Redirect(method = "generateSmallDoorChildRight", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
        private Direction implSouth2() {
            return Redirectionor.SOUTH;
        }

        @Redirect(method = "generateSmallDoor", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
        private Direction implNorth1() {
            return Redirectionor.NORTH;
        }

        @Redirect(method = "generateSmallDoorChildLeft", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
        private Direction implNorth2() {
            return Redirectionor.NORTH;
        }
    }

    @Mixin(StrongholdPieces.FillerCorridor.class)
    public abstract static class MixinFillerCorridor {
        @Redirect(method = "<init>(ILnet/minecraft/world/level/levelgen/structure/BoundingBox;Lnet/minecraft/core/Direction;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
        private Direction implSouth() {
            return Redirectionor.SOUTH;
        }
        @Redirect(method = "<init>(ILnet/minecraft/world/level/levelgen/structure/BoundingBox;Lnet/minecraft/core/Direction;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
        private Direction implNorth() {
            return Redirectionor.NORTH;
        }
    }
}
