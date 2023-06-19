package com.teampotato.redirectionor.mixin.client.renderer;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockModelRenderer.class)
public abstract class BlockModelRendererMixin {//TODO: get3DDataValue()
    @Redirect(method = "renderModelSmooth", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "renderModelFlat", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt2() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt3() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "renderModel(Lcom/mojang/blaze3d/matrix/MatrixStack$Entry;Lcom/mojang/blaze3d/vertex/IVertexBuilder;Lnet/minecraft/block/BlockState;Lnet/minecraft/client/renderer/model/IBakedModel;FFFIILnet/minecraftforge/client/model/data/IModelData;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt4() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "calculateShape", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}
