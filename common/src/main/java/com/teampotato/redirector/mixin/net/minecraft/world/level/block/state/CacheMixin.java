package com.teampotato.redirector.mixin.net.minecraft.world.level.block.state;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Predicate;
import java.util.stream.Stream;

@Mixin(targets = "net.minecraft.world.level.block.state.BlockBehaviour$BlockStateBase$Cache")
public abstract class CacheMixin {
    @Shadow @Final protected VoxelShape collisionShape;

    @Redirect(method = "<init>(Lnet/minecraft/world/level/block/state/BlockState;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SupportType;values()[Lnet/minecraft/world/level/block/SupportType;"))
    private SupportType[] redirectSupportTypes() {
        return CommonValues.SUPPORT_TYPES;
    }

    @Redirect(method = "<init>(Lnet/minecraft/world/level/block/state/BlockState;)V", at = @At(value = "INVOKE", target = "Ljava/util/stream/Stream;anyMatch(Ljava/util/function/Predicate;)Z"))
    private boolean avoidStream(Stream<Direction.Axis> instance, Predicate<Direction.Axis> predicate) {
        for (Direction.Axis axis : CommonValues.AXES) {
            if (this.collisionShape.min(axis) < 0.0 || this.collisionShape.max(axis) > 1.0) return true;
        }
        return false;
    }
}
