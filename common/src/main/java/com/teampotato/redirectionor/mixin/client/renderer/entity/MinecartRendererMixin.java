package com.teampotato.redirectionor.mixin.client.renderer.entity;

import com.teampotato.redirectionor.references.RenderShapeReferences;
import net.minecraft.client.renderer.entity.MinecartRenderer;
import net.minecraft.world.level.block.RenderShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinecartRenderer.class)
public abstract class MinecartRendererMixin {
    @Redirect(method = "render(Lnet/minecraft/world/entity/vehicle/AbstractMinecart;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;INVISIBLE:Lnet/minecraft/world/level/block/RenderShape;"))
    private RenderShape redirectRenderShapeINVISIBLE() {
        return RenderShapeReferences.INVISIBLE;
    }
}
