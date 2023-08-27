package com.teampotato.redirectionor.mixin.net.minecraft.compat.modernfix;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.SupportType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.world.level.block.state.BlockBehaviour$BlockStateBase$Cache")
public abstract class BlockBehaviourMixin {
    @Unique private static final Direction.Axis[] redirectionor$AXES = Direction.Axis.values();
    @Unique private static final SupportType[] SUPPORT_TYPES = SupportType.values();
    @Redirect(method = "<init>(Lnet/minecraft/world/level/block/state/BlockState;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction$Axis;values()[Lnet/minecraft/core/Direction$Axis;"))
    private Direction.Axis[] redirectDirection() {
        return redirectionor$AXES;
    }

    @Redirect(method = "<init>(Lnet/minecraft/world/level/block/state/BlockState;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SupportType;values()[Lnet/minecraft/world/level/block/SupportType;"))
    private SupportType[] redirectSupportType() {
        return SUPPORT_TYPES;
    }
}
