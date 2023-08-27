package com.teampotato.redirectionor.mixin.net.minecraftforge.client.model;

import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraftforge.client.model.PerspectiveMapWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = PerspectiveMapWrapper.class, remap = false)
public abstract class PerspectiveMapWrapperMixin {
    @Unique
    private static final ItemTransforms.TransformType[] TRANSFORM_TYPES = ItemTransforms.TransformType.values();
    @Redirect(method = {"getTransforms(Lnet/minecraft/client/resources/model/ModelState;)Lcom/google/common/collect/ImmutableMap;", "getTransforms(Lnet/minecraft/client/renderer/block/model/ItemTransforms;)Lcom/google/common/collect/ImmutableMap;", "getTransformsWithFallback"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/block/model/ItemTransforms$TransformType;values()[Lnet/minecraft/client/renderer/block/model/ItemTransforms$TransformType;"))
    private static ItemTransforms.TransformType[] redirectTransformTypeValues() {
        return TRANSFORM_TYPES;
    }
}
