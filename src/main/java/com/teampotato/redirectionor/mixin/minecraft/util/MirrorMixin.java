package com.teampotato.redirectionor.mixin.minecraft.util;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Mirror.class)
public abstract class MirrorMixin {
    @Redirect(method = {"getRotation", "mirror(Lnet/minecraft/util/Direction;)Lnet/minecraft/util/Direction;"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;X:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implX() {
        return Redirectionor.X;
    }

    @Redirect(method = {"getRotation", "mirror(Lnet/minecraft/util/Direction;)Lnet/minecraft/util/Direction;"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;Z:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implZ() {
        return Redirectionor.Z;
    }

    @Redirect(method = "getRotation", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;NONE:Lnet/minecraft/util/Rotation;"))
    private Rotation implNone() {
        return Redirectionor.NONE;
    }

    @Redirect(method = "getRotation", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;CLOCKWISE_180:Lnet/minecraft/util/Rotation;"))
    private Rotation implClockWise180() {
        return Redirectionor.CLOCKWISE_180;
    }
}
