package com.teampotato.directionoptimizer.mixin.block;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.block.AbstractCoralPlantBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractCoralPlantBlock.class)
public abstract class AbstractCoralPlantBlockMixin {
    @Redirect(method = "scanForWater", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private static Direction[] implOpt() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
