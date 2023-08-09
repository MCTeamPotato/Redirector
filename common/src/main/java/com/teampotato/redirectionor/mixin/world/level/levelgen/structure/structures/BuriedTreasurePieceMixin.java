package com.teampotato.redirectionor.mixin.world.level.levelgen.structure.structures;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.structures.BuriedTreasurePieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BuriedTreasurePieces.BuriedTreasurePiece.class)
public abstract class BuriedTreasurePieceMixin {
    @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirection() {
        return Values.DIRECTIONS;
    }
}
