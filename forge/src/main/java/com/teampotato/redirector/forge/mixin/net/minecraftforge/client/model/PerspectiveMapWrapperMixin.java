package com.teampotato.redirector.forge.mixin.net.minecraftforge.client.model;

import com.teampotato.redirector.forge.utils.ClientValues;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraftforge.client.model.PerspectiveMapWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = PerspectiveMapWrapper.class, remap = false)
public abstract class PerspectiveMapWrapperMixin {
    @Redirect(method = {"getTransforms(Lnet/minecraft/client/resources/model/ModelState;)Lcom/google/common/collect/ImmutableMap;", "getTransformsWithFallback", "getTransforms(Lnet/minecraft/client/renderer/block/model/ItemTransforms;)Lcom/google/common/collect/ImmutableMap;"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/block/model/ItemTransforms$TransformType;values()[Lnet/minecraft/client/renderer/block/model/ItemTransforms$TransformType;"))
    private static ItemTransforms.TransformType[] redirectItemTransformsTransformTypes() {
        return ClientValues.TRANSFORM_TYPES;
    }
}
