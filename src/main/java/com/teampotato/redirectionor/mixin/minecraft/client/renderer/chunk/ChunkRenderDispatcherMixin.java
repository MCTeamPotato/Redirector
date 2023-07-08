package com.teampotato.redirectionor.mixin.minecraft.client.renderer.chunk;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChunkRenderDispatcher.ChunkRender.class)
public abstract class ChunkRenderDispatcherMixin {

    @Redirect(method = "setOrigin", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "hasAllNeighbors", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;ordinal()I", ordinal = 0, remap = false))
    private int implOrdinal0(Direction instance) {
        return Redirectionor.WEST_ORDINAL;
    }

    @Redirect(method = "hasAllNeighbors", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;ordinal()I", ordinal = 1, remap = false))
    private int implOrdinal1(Direction instance) {
        return Redirectionor.NORTH_ORDINAL;
    }

    @Redirect(method = "hasAllNeighbors", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;ordinal()I", ordinal = 2, remap = false))
    private int implOrdinal2(Direction instance) {
        return Redirectionor.EAST_ORDINAL;
    }

    @Redirect(method = "hasAllNeighbors", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;ordinal()I", ordinal = 3, remap = false))
    private int implOrdinal3(Direction instance) {
        return Redirectionor.SOUTH_ORDINAL;
    }
}
