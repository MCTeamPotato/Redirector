package com.teampotato.redirectionor.mixin.world.level.levelgen.structure;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.BuriedTreasurePieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class BuriedTreasurePiecesMixin {
    @Mixin(BuriedTreasurePieces.BuriedTreasurePiece.class)
    public abstract static class BuriedTreasurePieceMixin {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
        private Direction[] redirectDirectionValues() {
            return DirectionReferences.DIRECTIONS;
        }
    }
}
