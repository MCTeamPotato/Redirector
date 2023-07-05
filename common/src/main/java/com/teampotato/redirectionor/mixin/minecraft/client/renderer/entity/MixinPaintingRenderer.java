package com.teampotato.redirectionor.mixin.minecraft.client.renderer.entity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.entity.PaintingRenderer;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PaintingRenderer.class)
public abstract class MixinPaintingRenderer {
    @Redirect(method = "renderPainting", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
    private Direction implEast() {
        return Redirectionor.EAST;
    }

    @Redirect(method = "renderPainting", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "renderPainting", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "renderPainting", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;WEST:Lnet/minecraft/core/Direction;"))
    private Direction implWest() {
        return Redirectionor.WEST;
    }
}
