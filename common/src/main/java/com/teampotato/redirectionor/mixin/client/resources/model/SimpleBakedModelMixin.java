package com.teampotato.redirectionor.mixin.client.resources.model;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.client.resources.model.SimpleBakedModel;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class SimpleBakedModelMixin {
    @Mixin(SimpleBakedModel.Builder.class)
    public abstract static class MixinBuilder {
        @Redirect(method = "<init>(ZZZLnet/minecraft/client/renderer/block/model/ItemTransforms;Lnet/minecraft/client/renderer/block/model/ItemOverrides;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
        private Direction[] redirectDirectionValues() {
            return DirectionReferences.DIRECTIONS;
        }
    }
}
