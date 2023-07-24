package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.structure.structures;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


public abstract class MixinNetherFortressPieces {
    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.NetherBridgePieces$NetherBridgePiece")
    public abstract static class MixinNetherBridgePiece {
        @Redirect(method = "generateChildLeft", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;WEST:Lnet/minecraft/core/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
        }

        @Redirect(method = "generateChildLeft", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
        private Direction implNorth() {
            return Redirectionor.NORTH;
        }

        @Redirect(method = "generateChildRight", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }

        @Redirect(method = "generateChildRight", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
        private Direction implSouth() {
            return Redirectionor.SOUTH;
        }
    }
}
