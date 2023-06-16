package com.teampotato.directionoptimizer.mixin.block;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.block.PistonHeadBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PistonHeadBlock.class)
public abstract class PistonHeadBlockMixin {
    @Redirect(method = "makeShapes", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private static Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
