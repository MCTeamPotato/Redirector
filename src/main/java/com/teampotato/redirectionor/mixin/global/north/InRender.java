package com.teampotato.redirectionor.mixin.global.north;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.blockentity.BellRenderer;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({BellRenderer.class})
public abstract class InRender {
    @Redirect(method = "render*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }
}
