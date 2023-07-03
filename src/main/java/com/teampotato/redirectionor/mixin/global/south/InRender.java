package com.teampotato.redirectionor.mixin.global.south;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.blockentity.BedRenderer;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({BedRenderer.class, ChestRenderer.class})
public abstract class InRender {
    @Redirect(method = "render*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }
}
