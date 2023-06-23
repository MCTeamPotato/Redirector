package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class FortressPiecesMixin {
    @Mixin(targets = "net.minecraft.world.gen.feature.structure.FortressPieces$Piece")
    public abstract static class PieceMixin {
        @Redirect(method = "generateChildRight", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
        private Direction implSouth() {
            return Redirectionor.SOUTH;
        }

        @Redirect(method = "generateChildLeft", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
        }

        @Redirect(method = "generateChildRight", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }
    }
}
