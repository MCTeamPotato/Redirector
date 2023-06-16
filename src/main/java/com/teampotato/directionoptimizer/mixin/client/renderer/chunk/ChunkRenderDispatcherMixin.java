package com.teampotato.directionoptimizer.mixin.client.renderer.chunk;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChunkRenderDispatcher.ChunkRender.class)
public abstract class ChunkRenderDispatcherMixin {
    @Redirect(method = "setOrigin", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
