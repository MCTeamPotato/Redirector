package com.teampotato.directionoptimizer.mixin.client.renderer.model;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.client.renderer.model.FaceBakery;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FaceBakery.class)
public abstract class FaceBakeryMixin {
    @Redirect(method = "setupShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }

    @Redirect(method = "calculateFacing", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private static Direction[] implOpt2() {
        return DirectionOptimizer.DIRECTIONS;
    }

    @Redirect(method = "recalculateWinding", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt3() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
