package com.teampotato.redirectionor.mixin.world.level.pathfinder;

import com.teampotato.redirectionor.references.DirectionR;
import net.minecraft.core.Direction;
import net.minecraft.world.level.pathfinder.TurtleNodeEvaluator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TurtleNodeEvaluator.class)
public abstract class TurtleNodeEvaluatorMixin {
    @Redirect(method = "getBlockPathType", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirectionValues() {
        return DirectionR.DIRECTIONS;
    }
}
