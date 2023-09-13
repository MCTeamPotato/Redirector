package com.teampotato.redirector.mixin.net.minecraft.client.renderer.entity.layers;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SheepFurLayer.class)
public abstract class SheepFurLayerMixin {
    @Redirect(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/Sheep;FFFFFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/DyeColor;values()[Lnet/minecraft/world/item/DyeColor;"))
    private DyeColor[] redirectDyeColors() {
        return CommonValues.DYE_COLORS;
    }
}
