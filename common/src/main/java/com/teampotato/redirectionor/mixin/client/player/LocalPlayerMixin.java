package com.teampotato.redirectionor.mixin.client.player;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(LocalPlayer.class)
public abstract class LocalPlayerMixin {
    @Unique
    private static final Direction[] DIRECTIONS = new Direction[]{Direction.WEST, Direction.EAST, Direction.NORTH, Direction.SOUTH};

    @Inject(method = "moveTowardsClosestSpace", at = @At("HEAD"), locals = LocalCapture.PRINT)
    private void redirectDirection(double d, double e, CallbackInfo ci, double arg1) {}
}
