package com.teampotato.redirectionor.mixin.client.renderer.entity.layers;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SheepFurLayer.class)
public abstract class SheepFurLayerMixin {
    @Redirect(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/Sheep;FFFFFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/DyeColor;values()[Lnet/minecraft/world/item/DyeColor;"))
    private DyeColor[] redirectDyeColor() {
        return Values.DYE_COLORS;
    }
}
