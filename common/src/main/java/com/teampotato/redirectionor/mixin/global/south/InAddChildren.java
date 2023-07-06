package com.teampotato.redirectionor.mixin.global.south;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.MineShaftPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({MineShaftPieces.MineShaftCorridor.class, MineShaftPieces.MineShaftCrossing.class, MineShaftPieces.MineShaftRoom.class, MineShaftPieces.MineShaftStairs.class})
public abstract class InAddChildren {
    @Redirect(method = "addChildren", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }
}
