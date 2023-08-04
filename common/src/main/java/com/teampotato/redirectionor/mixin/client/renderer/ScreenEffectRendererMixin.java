package com.teampotato.redirectionor.mixin.client.renderer;

import com.teampotato.redirectionor.references.RenderShapeReferences;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.world.level.block.RenderShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ScreenEffectRenderer.class)
public abstract class ScreenEffectRendererMixin {
    @Redirect(method = "getViewBlockingState", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;INVISIBLE:Lnet/minecraft/world/level/block/RenderShape;"))
    private static RenderShape redirectRenderShapeINVISIBLE() {
        return RenderShapeReferences.INVISIBLE;
    }
}
