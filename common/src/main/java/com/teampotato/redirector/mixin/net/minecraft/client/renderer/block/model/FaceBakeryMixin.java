package com.teampotato.redirector.mixin.net.minecraft.client.renderer.block.model;

import com.teampotato.redirector.redirect.CommonValues;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FaceBakery.class)
public abstract class FaceBakeryMixin {
    @Redirect(method = {"setupShape", "recalculateWinding"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirections() {
        return CommonValues.DIRECTIONS;
    }

    @Redirect(method = "calculateFacing", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirectionsStatic() {
        return CommonValues.DIRECTIONS;
    }
}
