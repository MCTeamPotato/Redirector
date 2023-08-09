package com.teampotato.redirectionor.mixin.client.gui.screens;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.client.gui.screens.SoundOptionsScreen;
import net.minecraft.sounds.SoundSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SoundOptionsScreen.class)
public abstract class SoundOptionsScreenMixin {
    @Redirect(method = "getAllSoundOptionsExceptMaster", at = @At(value = "INVOKE", target = "Lnet/minecraft/sounds/SoundSource;values()[Lnet/minecraft/sounds/SoundSource;"))
    private SoundSource[] redirectSoundSource() {
        return Values.SOUND_SOURCES;
    }
}
