package com.teampotato.redirectionor.mixin.global.west;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.MineShaftPieces;
import net.minecraft.world.level.levelgen.structure.StrongholdPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({MineShaftPieces.MineShaftCorridor.class, MineShaftPieces.MineShaftCrossing.class, MineShaftPieces.MineShaftRoom.class, MineShaftPieces.MineShaftStairs.class, StrongholdPieces.FiveCrossing.class})
public abstract class InAddChildren {
    @Redirect(method = "addChildren", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;WEST:Lnet/minecraft/core/Direction;"))
    private Direction implWest() {
        return Redirectionor.WEST;
    }
}
