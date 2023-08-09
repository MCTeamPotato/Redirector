package com.teampotato.redirectionor.mixin.client.renderer.chunk;

import com.teampotato.redirectionor.common.Maps;
import com.teampotato.redirectionor.common.Values;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChunkRenderDispatcher.RenderChunk.class)
public abstract class ChunkRenderDispatcherMixin {
    @Redirect(method = "setOrigin", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirection() {
        return Values.DIRECTIONS;
    }

    @Redirect(method = "hasAllNeighbors", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;ordinal()I"))
    private int redirectDirectionOrdinal(Direction instance) {
        return Maps.DIRECTION_ORDINAL_MAP.getInt(instance);
    }
}
