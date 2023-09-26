package com.teampotato.redirector.forge.mixin.net.minecraft.client.renderer.block.model;

import com.teampotato.redirector.forge.utils.ClientValues;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemDisplayContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemTransforms.Deserializer.class)
public abstract class ItemTransformsDeserializerMixin {
    @Redirect(method = "deserialize(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lnet/minecraft/client/renderer/block/model/ItemTransforms;", at = @At(value = "INVOKE", remap = false, target = "Lnet/minecraft/world/item/ItemDisplayContext;values()[Lnet/minecraft/world/item/ItemDisplayContext;"))
    private ItemDisplayContext[] redirectItemDisplayContexts() {
        return ClientValues.ITEM_DISPLAY_CONTEXTS;
    }
}
