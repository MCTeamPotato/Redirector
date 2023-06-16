package com.teampotato.directionoptimizer.mixin.client.renderer.model;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.client.renderer.model.SimpleBakedModel;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SimpleBakedModel.Builder.class)
public abstract class SimpleBakedModelMixin {
    @Redirect(method = "<init>(ZZZLnet/minecraft/client/renderer/model/ItemCameraTransforms;Lnet/minecraft/client/renderer/model/ItemOverrideList;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
