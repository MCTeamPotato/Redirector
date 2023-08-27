package com.teampotato.redirectionor.mixin.net.minecraft.world.level.levelgen.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.MineShaftPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MineShaftPieces.MineShaftCorridor.class)
public abstract class MineshaftPiecesMineShaftCorridorMixin {
    @Redirect(method = "hasSturdyNeighbours", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirection() {
        return Redirectionor.DIRECTIONS;
    }
}
