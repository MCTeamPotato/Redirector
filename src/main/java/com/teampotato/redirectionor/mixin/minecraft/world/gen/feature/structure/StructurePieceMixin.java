package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StructurePiece.class)
public abstract class StructurePieceMixin {
    @Redirect(method = {"placeBlock", "setOrientation"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;NONE:Lnet/minecraft/util/Rotation;"))
    private Rotation implRotationNone() {
        return Redirectionor.NONE;
    }

    @Redirect(method = {"placeBlock", "setOrientation"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;NONE:Lnet/minecraft/util/Mirror;"))
    private Mirror implMirrorNone() {
        return Redirectionor.MIRROR_NONE;
    }

    @Redirect(method = "setOrientation", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;LEFT_RIGHT:Lnet/minecraft/util/Mirror;"))
    private Mirror implLeftRight() {
        return Redirectionor.LEFT_RIGHT;
    }

    @Redirect(method = "setOrientation", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;CLOCKWISE_90:Lnet/minecraft/util/Rotation;"))
    private Rotation implClockWise90() {
        return Redirectionor.CLOCKWISE_90;
    }
}
