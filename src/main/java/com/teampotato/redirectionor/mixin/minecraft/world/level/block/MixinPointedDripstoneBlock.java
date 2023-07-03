package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PointedDripstoneBlock.class)
public abstract class MixinPointedDripstoneBlock {
    @Redirect(method = "fallOn", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp1() {
        return Redirectionor.UP;
    }

    @Redirect(method = "growStalagmiteBelow", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private static Direction implUp2() {
        return Redirectionor.UP;
    }

    @Redirect(method = "createMergedTips", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private static Direction implUp3() {
        return Redirectionor.UP;
    }

    @Redirect(method = "isStalagmite", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private static Direction implUp4() {
        return Redirectionor.UP;
    }

    @Redirect(method = "findStalactiteTipAboveCauldron", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;getAxisDirection()Lnet/minecraft/core/Direction$AxisDirection;"))
    private static Direction.AxisDirection implUp5(Direction instance) {
        return Redirectionor.UP_AXIS_DIRECTION;
    }
}
