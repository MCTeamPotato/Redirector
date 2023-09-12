package com.teampotato.redirector.mixin.net.minecraft.server.commands;

import com.teampotato.redirector.redirect.CommonValues;
import net.minecraft.server.commands.StopSoundCommand;
import net.minecraft.sounds.SoundSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StopSoundCommand.class)
public abstract class StopSoundCommandMixin {
    @Redirect(method = "register", at = @At(value = "INVOKE", target = "Lnet/minecraft/sounds/SoundSource;values()[Lnet/minecraft/sounds/SoundSource;"))
    private static SoundSource[] redirectSoundSources() {
        return CommonValues.SOUND_SOURCES;
    }
}
