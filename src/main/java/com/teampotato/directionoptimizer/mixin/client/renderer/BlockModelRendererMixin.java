package com.teampotato.directionoptimizer.mixin.client.renderer;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockModelRenderer.class)
public abstract class BlockModelRendererMixin {
    @Redirect(method = "renderModelSmooth", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }

    @Redirect(method = "renderModelFlat", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt2() {
        return DirectionOptimizer.DIRECTIONS;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt3() {
        return DirectionOptimizer.DIRECTIONS;
    }

    @Redirect(method = "renderModel(Lcom/mojang/blaze3d/matrix/MatrixStack$Entry;Lcom/mojang/blaze3d/vertex/IVertexBuilder;Lnet/minecraft/block/BlockState;Lnet/minecraft/client/renderer/model/IBakedModel;FFFIILnet/minecraftforge/client/model/data/IModelData;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt4() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
