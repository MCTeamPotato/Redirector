package com.teampotato.redirectionor.mixin.minecraft.client.gui.screen;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.gui.screen.EditStructureScreen;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EditStructureScreen.class)
public abstract class MixinEditStructureScreen {
    @Redirect(method = "lambda$init$7", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;NONE:Lnet/minecraft/util/Mirror;"))
    private Mirror implMirrorNone() {
        return Redirectionor.MIRROR_NONE;
    }

    @Redirect(method = "lambda$init$7", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;FRONT_BACK:Lnet/minecraft/util/Mirror;"))
    private Mirror implFrontBack() {
        return Redirectionor.FRONT_BACK;
    }

    @Redirect(method = "lambda$init$7", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;LEFT_RIGHT:Lnet/minecraft/util/Mirror;"))
    private Mirror implLeftRight() {
        return Redirectionor.LEFT_RIGHT;
    }

    @Redirect(method = "lambda$init$10", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;NONE:Lnet/minecraft/util/Rotation;"))
    private Rotation implNone() {
        return Redirectionor.NONE;
    }

    @Redirect(method = "lambda$init$11", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;CLOCKWISE_90:Lnet/minecraft/util/Rotation;"))
    private Rotation implClockWise90() {
        return Redirectionor.CLOCKWISE_90;
    }

    @Redirect(method = "lambda$init$12", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;CLOCKWISE_180:Lnet/minecraft/util/Rotation;"))
    private Rotation implClockWise180() {
        return Redirectionor.CLOCKWISE_180;
    }

    @Redirect(method = "lambda$init$13", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;COUNTERCLOCKWISE_90:Lnet/minecraft/util/Rotation;"))
    private Rotation implCounterClockWise90() {
        return Redirectionor.COUNTERCLOCKWISE_90;
    }
}
