package com.teampotato.redirectionor.mixin.minecraft.util;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.util.TeleportationRepositioner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = TeleportationRepositioner.class, priority = 10)
public abstract class TeleportationRepositionerMixin {


    @Redirect(method = "getLargestRectangleAround", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$AxisDirection;NEGATIVE:Lnet/minecraft/util/Direction$AxisDirection;"))
    private static Direction.AxisDirection implPositive() {
        return Redirectionor.POSITIVE;
    }
}
