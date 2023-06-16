package com.teampotato.directionoptimizer.mixin.block;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FlowingFluidBlock.class)
public abstract class FlowingFluidBlockMixin {
    @Redirect(method = "shouldSpreadLiquid", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
