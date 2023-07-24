package com.teampotato.redirectionor.mixin.minecraft.client.renderer.blockentity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.blockentity.BedRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BedPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BedRenderer.class)
public abstract class MixinBedRenderer {
    @Redirect(method = "render(Lnet/minecraft/world/level/block/entity/BedBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BedPart;HEAD:Lnet/minecraft/world/level/block/state/properties/BedPart;"))
    private BedPart implHead() {
        return Redirectionor.BED_HEAD;
    }

    @Redirect(method = "render(Lnet/minecraft/world/level/block/entity/BedBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }
}
