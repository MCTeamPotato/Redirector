package com.teampotato.redirectionor.mixin;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.BlockUtil;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockUtil.class)
public abstract class BlockUtilMixin {
    @Redirect(method = "getLargestRectangleAround", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$AxisDirection;NEGATIVE:Lnet/minecraft/core/Direction$AxisDirection;"))
    private static Direction.AxisDirection redirectAxisDirectionNEGATIVE() {
        return DirectionReferences.AxisDirectionReferences.NEGATIVE;
    }
}
