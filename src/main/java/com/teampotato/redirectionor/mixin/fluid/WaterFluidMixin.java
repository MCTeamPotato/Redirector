package com.teampotato.redirectionor.mixin.fluid;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WaterFluid.class)
public abstract class WaterFluidMixin {
    @Redirect(method = "canBeReplacedWith", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown1() {
        return Redirectionor.DOWN;
    }
}
