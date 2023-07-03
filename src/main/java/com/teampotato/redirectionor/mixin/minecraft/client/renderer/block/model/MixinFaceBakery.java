package com.teampotato.redirectionor.mixin.minecraft.client.renderer.block.model;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FaceBakery.class)
public abstract class MixinFaceBakery {
    @Redirect(method = "setupShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] implValues1() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "calculateFacing", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] implValues2() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "calculateFacing", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private static Direction implUp() {
        return Redirectionor.UP;
    }

    @Redirect(method = "recalculateWinding", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] implValues3() {
        return Redirectionor.DIRECTIONS;
    }
}
