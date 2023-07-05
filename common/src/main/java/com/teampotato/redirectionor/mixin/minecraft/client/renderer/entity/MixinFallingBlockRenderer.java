package com.teampotato.redirectionor.mixin.minecraft.client.renderer.entity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.entity.FallingBlockRenderer;
import net.minecraft.world.level.block.RenderShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FallingBlockRenderer.class)
public abstract class MixinFallingBlockRenderer {
    @Redirect(method = "render(Lnet/minecraft/world/entity/item/FallingBlockEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;MODEL:Lnet/minecraft/world/level/block/RenderShape;"))
    private RenderShape implModel() {
        return Redirectionor.MODEL;
    }
}
