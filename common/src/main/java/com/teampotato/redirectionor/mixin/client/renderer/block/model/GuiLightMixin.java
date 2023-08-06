package com.teampotato.redirectionor.mixin.client.renderer.block.model;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.block.model.BlockModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockModel.GuiLight.class)
public abstract class GuiLightMixin {
    @Redirect(method = "getByName", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/block/model/BlockModel$GuiLight;values()[Lnet/minecraft/client/renderer/block/model/BlockModel$GuiLight;"))
    private static BlockModel.GuiLight[] redirectGuiLight() {
        return Redirectionor.BLOCK_MODEL_GUI_LIGHTS;
    }
}
