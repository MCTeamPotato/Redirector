package com.teampotato.redirector.mixin.net.minecraft.client.resources.model;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.client.resources.model.SimpleBakedModel;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SimpleBakedModel.Builder.class)
public abstract class SimpleBakedModelBuilderMixin {
    @Redirect(method = "<init>(ZZZLnet/minecraft/client/renderer/block/model/ItemTransforms;Lnet/minecraft/client/renderer/block/model/ItemOverrides;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirectionsStatic() {
        return CommonValues.DIRECTIONS;
    }
}
