package com.teampotato.directionoptimizer.mixin.pathfinding;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.pathfinding.SwimNodeProcessor;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SwimNodeProcessor.class)
public abstract class SwimNodeProcessorMixin {
    @Redirect(method = "getNeighbors", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
