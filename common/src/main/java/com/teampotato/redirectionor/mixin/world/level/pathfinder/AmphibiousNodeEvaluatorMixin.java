package com.teampotato.redirectionor.mixin.world.level.pathfinder;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.core.Direction;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AmphibiousNodeEvaluator.class)
public abstract class AmphibiousNodeEvaluatorMixin {
    @Redirect(method = "getBlockPathType", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirection() {
        return Values.DIRECTIONS;
    }
}
