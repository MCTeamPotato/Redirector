package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Predicate;
import java.util.stream.Stream;

public abstract class AbstractBlockMixin {

    @Mixin(AbstractBlock.AbstractBlockState.class)
    public abstract static class AbstractBlockStateMixin {
        @Redirect(method = "entityCanStandOn", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
        private Direction implUp() {
            return Redirectionor.UP;
        }
    }

    @Mixin(targets = "net.minecraft.block.AbstractBlock$AbstractBlockState$Cache")
    public abstract static class CacheMixin {
        @Shadow @Final protected VoxelShape collisionShape;

        @Redirect(method = "<init>(Lnet/minecraft/block/BlockState;)V", at = @At(value = "INVOKE", target = "Ljava/util/stream/Stream;anyMatch(Ljava/util/function/Predicate;)Z"))
        private boolean avoidAllocationAndStream(Stream<?> instance, Predicate<?> predicate) {
            for (Direction.Axis axis : Redirectionor.AXISES) {
                if (this.collisionShape.min(axis) < 0.0D || this.collisionShape.max(axis) > 1.0D) return true;
            }
            return false;
        }
    }
}
