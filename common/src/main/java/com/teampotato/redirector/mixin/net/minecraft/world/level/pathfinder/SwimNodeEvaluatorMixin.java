package com.teampotato.redirector.mixin.net.minecraft.world.level.pathfinder;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.core.Direction;
import net.minecraft.world.level.pathfinder.SwimNodeEvaluator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SwimNodeEvaluator.class)
public abstract class SwimNodeEvaluatorMixin {
    @Redirect(method = "getNeighbors", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirections() {
        return CommonValues.DIRECTIONS;
    }
}
