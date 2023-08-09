package com.teampotato.redirectionor.mixin.client.renderer.block;

import com.teampotato.redirectionor.common.Maps;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ModelBlockRenderer.class)
public abstract class ModelBlockRendererMixin {
    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
    private int redirectDirectionGet3DDataValue(Direction instance) {
        return Maps.DIRECTION_DATA_VALUE_MAP.getInt(instance);
    }
}
