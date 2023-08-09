package com.teampotato.redirectionor.mixin.core;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Direction.class)
public abstract class DirectionMixin {
    @Redirect(method = "allShuffled", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirection() {
        return Values.DIRECTIONS;
    }
}
