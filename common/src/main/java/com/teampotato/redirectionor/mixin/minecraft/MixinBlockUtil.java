package com.teampotato.redirectionor.mixin.minecraft;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.BlockUtil;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockUtil.class)
public abstract class MixinBlockUtil {
    @Redirect(method = "getLargestRectangleAround", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get(Lnet/minecraft/core/Direction$AxisDirection;Lnet/minecraft/core/Direction$Axis;)Lnet/minecraft/core/Direction;"))
    private static Direction implNegative1(Direction.AxisDirection direction, Direction.Axis axis) {
        return Direction.get(Redirectionor.NEGATIVE, axis);
    }
}
