package com.teampotato.directionoptimizer.mixin.world.gen.feature;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.NoExposedOreFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NoExposedOreFeature.class)
public abstract class NoExposedOreFeatureMixin {
    @Redirect(method = "isFacingAir", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
