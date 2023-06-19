package com.teampotato.redirectionor.mixin.client.renderer;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.FluidBlockRenderer;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FluidBlockRenderer.class)
public abstract class FluidBlockRendererMixin {
    @Redirect(method = "tesselate", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}
