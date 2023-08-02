package com.teampotato.redirectionor.mixin.client.renderer.block;

import com.teampotato.redirectionor.references.RenderShapeReferences;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.world.level.block.RenderShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockRenderDispatcher.class)
public abstract class BlockRenderDispatcherMixin {
    @Redirect(method = "renderSingleBlock", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;INVISIBLE:Lnet/minecraft/world/level/block/RenderShape;"))
    private RenderShape redirectRenderShapeINVISIBLE() {
        return RenderShapeReferences.INVISIBLE;
    }
    @Redirect(method = {"renderBreakingTexture", "renderBatched"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;MODEL:Lnet/minecraft/world/level/block/RenderShape;"))
    private RenderShape redirectRenderShapeMODEL() {
        return RenderShapeReferences.MODEL;
    }
}
