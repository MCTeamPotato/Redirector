package com.teampotato.redirectionor.mixin.minecraft.world.level.material;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.material.FlowingFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FlowingFluid.class)
public abstract class MixinFlowingFluid {
    @Redirect(method = {"isSolidFace", "getNewLiquid"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp () {
        return Redirectionor.UP;
    }
}
