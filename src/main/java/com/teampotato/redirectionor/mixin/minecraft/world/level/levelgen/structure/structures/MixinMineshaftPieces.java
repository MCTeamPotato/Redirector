package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.structure.structures;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.structures.MineshaftPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public abstract class MixinMineshaftPieces {

    @Mixin(MineshaftPieces.MineShaftCorridor.class)
    public static abstract class MixinMineShaftCorridor {
        @Redirect(method = "hasSturdyNeighbours", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
        private Direction[] implValues1 () {
            return Redirectionor.DIRECTIONS;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
        private Direction implNorth () {
            return Redirectionor.NORTH;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
        private Direction implSouth () {
            return Redirectionor.SOUTH;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;WEST:Lnet/minecraft/core/Direction;"))
        private Direction implWest () {
            return Redirectionor.WEST;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
        private Direction implEast () {
            return Redirectionor.EAST;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
        private Direction implDown () {
            return Redirectionor.DOWN;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
        private Direction implUp () {
            return Redirectionor.UP;
        }
    }

    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.MineshaftPieces$MineShaftPiece")
    public abstract static class MixinMineShaftPiece {
        @Redirect(method = "setPlanksBlock", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
        private Direction implUp () {
            return Redirectionor.UP;
        }
    }
}
