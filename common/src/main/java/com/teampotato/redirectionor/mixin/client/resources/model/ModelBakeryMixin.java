package com.teampotato.redirectionor.mixin.client.resources.model;

import com.teampotato.redirectionor.references.RenderShapeReferences;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.world.level.block.RenderShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ModelBakery.class)
public abstract class ModelBakeryMixin {
    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;MODEL:Lnet/minecraft/world/level/block/RenderShape;"))
    private RenderShape redirectRenderShapeMODEL() {
        return RenderShapeReferences.MODEL;
    }
}
