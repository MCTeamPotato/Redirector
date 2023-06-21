package com.teampotato.redirectionor.mixin.client.renderer.debug;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.debug.SolidFaceDebugRenderer;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SolidFaceDebugRenderer.class)
public abstract class SolidFaceDebugRendererMixin {
    @Redirect(method = "render", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "render", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
