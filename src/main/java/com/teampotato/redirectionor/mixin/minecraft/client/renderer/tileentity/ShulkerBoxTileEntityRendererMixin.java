package com.teampotato.redirectionor.mixin.minecraft.client.renderer.tileentity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.tileentity.ShulkerBoxTileEntityRenderer;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShulkerBoxTileEntityRenderer.class)
public abstract class ShulkerBoxTileEntityRendererMixin {
    @Redirect(method = "render(Lnet/minecraft/tileentity/ShulkerBoxTileEntity;FLcom/mojang/blaze3d/matrix/MatrixStack;Lnet/minecraft/client/renderer/IRenderTypeBuffer;II)V", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
