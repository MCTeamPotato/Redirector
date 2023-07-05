package com.teampotato.redirectionor.mixin.minecraft.client.renderer.chunk;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ChunkRenderDispatcher.RenderChunk.class, priority = 10)
public abstract class MixinChunkRenderDispatcher {
    @Shadow protected abstract double getDistToPlayerSqr();
    @Shadow protected abstract boolean doesChunkExistAt(BlockPos pPos);

    @Shadow @Final private BlockPos.MutableBlockPos[] relativeOrigins;

    @Redirect(method = "setOrigin", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] implValues1() {
        return Redirectionor.DIRECTIONS;
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public boolean hasAllNeighbors() {
        int i = 24;
        if (!(this.getDistToPlayerSqr() > 576.0D)) {
            return true;
        } else {
            return this.doesChunkExistAt(this.relativeOrigins[Redirectionor.WEST_ORDINAL]) &&
                    this.doesChunkExistAt(this.relativeOrigins[Redirectionor.NORTH_ORDINAL]) &&
                    this.doesChunkExistAt(this.relativeOrigins[Redirectionor.EAST_ORDINAL]) &&
                    this.doesChunkExistAt(this.relativeOrigins[Redirectionor.SOUTH_ORDINAL]);
        }
    }
}
