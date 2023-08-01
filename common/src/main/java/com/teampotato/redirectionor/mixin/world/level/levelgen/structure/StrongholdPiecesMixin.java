package com.teampotato.redirectionor.mixin.world.level.levelgen.structure;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.StrongholdPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class StrongholdPiecesMixin {
    @Mixin(StrongholdPieces.StairsDown.class)
    public abstract static class StairsDownMixin {
        @Redirect(method = "<init>(Lnet/minecraft/world/level/levelgen/feature/StructurePieceType;ILjava/util/Random;II)V", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Plane;HORIZONTAL:Lnet/minecraft/core/Direction$Plane;"))
        private Direction.Plane redirectPlaneHORIZONTAL() {
            return DirectionReferences.PlaneReferences.HORIZONTAL;
        }
    }
}
