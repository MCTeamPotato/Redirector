package com.teampotato.redirectionor.mixin.client.renderer.chunk;

import com.teampotato.redirectionor.references.DirectionReferences;
import com.teampotato.redirectionor.references.RenderShapeReferences;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RenderShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class ChunkRenderDispatcherMixin {
    @Mixin(ChunkRenderDispatcher.RenderChunk.class)
    public abstract static class RenderChunkMixin {
        @Redirect(method = "setOrigin", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
        private Direction[] redirectDirectionValues() {
            return DirectionReferences.DIRECTIONS;
        }

        @Redirect(method = "hasAllNeighbors", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;ordinal()I"))
        private int redirectDirectionOrdinal(Direction instance) {
            return DirectionReferences.OrdinalReferences.ORDINAL_MAP.getInt(instance);
        }
    }

    @Mixin(targets = "net.minecraft.client.renderer.chunk.ChunkRenderDispatcher$RenderChunk$RebuildTask")
    public abstract static class RebuildTaskMixin {
        @Redirect(method = "compile", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;INVISIBLE:Lnet/minecraft/world/level/block/RenderShape;"))
        private RenderShape redirectRenderShapeINVISIBLE() {
            return RenderShapeReferences.INVISIBLE;
        }
    }
}
