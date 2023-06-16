package com.teampotato.directionoptimizer.mixin.world.gen.feature.structure;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.structure.BuriedTreasure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BuriedTreasure.Piece.class)
public abstract class BuriedTreasureMixin {
    @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
