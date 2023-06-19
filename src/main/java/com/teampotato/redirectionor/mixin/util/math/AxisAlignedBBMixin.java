package com.teampotato.redirectionor.mixin.util.math;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AxisAlignedBB.class)
public abstract class AxisAlignedBBMixin {
    @Redirect(method = "getDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDown1() {
        return Redirectionor.DOWN;
    }
}
