package com.teampotato.redirector.forge.mixin.net.minecraftforge.client.model;

import com.teampotato.redirector.forge.utils.ClientValues;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraftforge.client.model.SeparatePerspectiveModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = SeparatePerspectiveModel.Loader.class, remap = false)
public abstract class SeparatePerspectiveModelMixin {
    @Redirect(method = "read(Lcom/google/gson/JsonDeserializationContext;Lcom/google/gson/JsonObject;)Lnet/minecraftforge/client/model/SeparatePerspectiveModel;", at = @At(value = "INVOKE", remap = false, target = "Lnet/minecraft/client/renderer/block/model/ItemTransforms$TransformType;values()[Lnet/minecraft/client/renderer/block/model/ItemTransforms$TransformType;"))
    private ItemTransforms.TransformType[] redirectItemTransformsTransformTypes() {
        return ClientValues.TRANSFORM_TYPES;
    }
}
