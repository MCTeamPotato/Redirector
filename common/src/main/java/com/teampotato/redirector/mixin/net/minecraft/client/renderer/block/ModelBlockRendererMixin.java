package com.teampotato.redirector.mixin.net.minecraft.client.renderer.block;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ModelBlockRenderer.class)
public abstract class ModelBlockRendererMixin {
    @Redirect(method = {"tesselateWithAO", "tesselateWithoutAO", "calculateShape", "renderModel"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirections() {
        return CommonValues.DIRECTIONS;
    }

    @Mixin(ModelBlockRenderer.SizeInfo.class)
    public abstract static class SizeInfoMixin {
        @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
        private Direction[] redirectDirections() {
            return CommonValues.DIRECTIONS;
        }
    }
}
