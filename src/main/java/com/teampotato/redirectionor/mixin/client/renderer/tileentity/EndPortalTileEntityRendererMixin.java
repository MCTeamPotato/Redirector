package com.teampotato.redirectionor.mixin.client.renderer.tileentity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.tileentity.EndPortalTileEntityRenderer;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EndPortalTileEntityRenderer.class)
public abstract class EndPortalTileEntityRendererMixin {
    @Redirect(method = "renderCube", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "renderCube", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
