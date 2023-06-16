package com.teampotato.directionoptimizer.mixin.block;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.block.FrostedIceBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FrostedIceBlock.class)
public abstract class FrostedIceBlockMixin {
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }

    @Redirect(method = "fewerNeigboursThan", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt2() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
