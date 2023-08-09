package com.teampotato.redirectionor.mixin.world.level.block;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.SculkSensorBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SculkSensorBlock.class)
public abstract class SculkSensorBlockMixin {
    @Redirect(method = "tryResonateVibration", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirection() {
        return Values.DIRECTIONS;
    }
}
