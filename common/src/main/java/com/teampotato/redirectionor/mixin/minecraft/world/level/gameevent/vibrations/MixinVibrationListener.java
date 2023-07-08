package com.teampotato.redirectionor.mixin.minecraft.world.level.gameevent.vibrations;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VibrationSystem.Listener.class)
public abstract class MixinVibrationListener {
    @Redirect(method = "isOccluded", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] implValues() {
        return Redirectionor.DIRECTIONS;
    }
}
