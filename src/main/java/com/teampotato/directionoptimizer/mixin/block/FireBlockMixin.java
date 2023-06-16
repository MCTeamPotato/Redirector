package com.teampotato.directionoptimizer.mixin.block;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.block.FireBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FireBlock.class)
public abstract class FireBlockMixin {
    @Redirect(method = "getStateForPlacement(Lnet/minecraft/world/IBlockReader;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }

    @Redirect(method = "isValidFireLocation", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt2() {
        return DirectionOptimizer.DIRECTIONS;
    }

    @Redirect(method = "getFireOdds", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt3() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
