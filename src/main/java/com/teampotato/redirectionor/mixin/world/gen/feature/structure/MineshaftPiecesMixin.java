package com.teampotato.redirectionor.mixin.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.structure.MineshaftPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public abstract class MineshaftPiecesMixin {
    @Mixin(MineshaftPieces.Corridor.class)
    public static abstract class CorridorMixin {
        @Redirect(method = "addChildren", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
        private Direction implNorth1() {
            return Redirectionor.NORTH;
        }

        @Redirect(method = "placeSupport", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
        private Direction implNorth2() {
            return Redirectionor.NORTH;
        }
    }

    @Mixin(MineshaftPieces.Cross.class)
    public static abstract class CrossMixin {
        @Redirect(method = "addChildren", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
        private Direction implNorth1() {
            return Redirectionor.NORTH;
        }
    }

    @Mixin(MineshaftPieces.Room.class)
    public static abstract class RoomMixin {
        @Redirect(method = "addChildren", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
        private Direction implNorth1() {
            return Redirectionor.NORTH;
        }
    }
    @Mixin(MineshaftPieces.Stairs.class)
    public static abstract class StairsMixin {
        @Redirect(method = "addChildren", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
        private Direction implNorth1() {
            return Redirectionor.NORTH;
        }
    }
}
