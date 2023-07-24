package com.teampotato.redirectionor.mixin.client.renderer.chunk;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class ChunkRenderDispatcherMixin {
    @Mixin(ChunkRenderDispatcher.RenderChunk.class)
    public abstract static class MixinRenderChunk {
        @Redirect(method = "setOrigin", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
        private Direction[] redirectDirectionValues() {
            return DirectionReferences.DIRECTIONS;
        }
    }
}
