package com.teampotato.redirectionor.mixin.net.minecraftforge.client.model;

import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraftforge.client.model.SeparateTransformsModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = SeparateTransformsModel.Loader.class, remap = false)
public abstract class SeparateTransformsModelLoaderMixin {
    @Unique
  private static final ItemTransforms.TransformType[] TRANSFORM_TYPES = ItemTransforms.TransformType.values();

    @Redirect(method = "read(Lcom/google/gson/JsonObject;Lcom/google/gson/JsonDeserializationContext;)Lnet/minecraftforge/client/model/SeparateTransformsModel;", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/block/model/ItemTransforms$TransformType;values()[Lnet/minecraft/client/renderer/block/model/ItemTransforms$TransformType;"))
    private ItemTransforms.TransformType[] redirectTransformTypeValues() {
        return TRANSFORM_TYPES;
    }
}
