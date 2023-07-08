package com.teampotato.redirectionor.mixin.minecraft.client.renderer;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = BlockModelRenderer.class, priority = 10)
public abstract class BlockModelRendererMixin {

    @Redirect(method = {"renderModelSmooth", "renderModelFlat", "calculateShape"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 0))
    private int implValue0(Direction instance) {
        return Redirectionor.WEST_3D_DATA_VALUE;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 1))
    private int implValue1(Direction instance) {
        return Redirectionor.EAST_3D_DATA_VALUE;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 2))
    private int implValue2(Direction instance) {
        return Redirectionor.DOWN_3D_DATA_VALUE;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 3))
    private int implValue3(Direction instance) {
        return Redirectionor.UP_3D_DATA_VALUE;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 4))
    private int implValue4(Direction instance) {
        return Redirectionor.NORTH_3D_DATA_VALUE;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 5))
    private int implValue5(Direction instance) {
        return Redirectionor.SOUTH_3D_DATA_VALUE;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 6))
    private int implValue6(Direction instance) {
        return Redirectionor.WEST_3D_DATA_VALUE;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 7))
    private int implValue7(Direction instance) {
        return Redirectionor.EAST_3D_DATA_VALUE;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 8))
    private int implValue8(Direction instance) {
        return Redirectionor.DOWN_3D_DATA_VALUE;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 9))
    private int implValue9(Direction instance) {
        return Redirectionor.UP_3D_DATA_VALUE;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 10))
    private int implValue10(Direction instance) {
        return Redirectionor.NORTH_3D_DATA_VALUE;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 11))
    private int implValue11(Direction instance) {
        return Redirectionor.SOUTH_3D_DATA_VALUE;
    }
}
