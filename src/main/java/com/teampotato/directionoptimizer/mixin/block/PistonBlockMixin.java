package com.teampotato.directionoptimizer.mixin.block;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.block.PistonBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PistonBlock.class)
public abstract class PistonBlockMixin {
    @Redirect(method = "getNeighborSignal", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
