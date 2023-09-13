package com.teampotato.redirector.mixin.net.minecraft.server.commands;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.server.commands.PlaySoundCommand;
import net.minecraft.sounds.SoundSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlaySoundCommand.class)
public abstract class PlaySoundCommandMixin {
    @Redirect(method = "register", at = @At(value = "INVOKE", target = "Lnet/minecraft/sounds/SoundSource;values()[Lnet/minecraft/sounds/SoundSource;"))
    private static SoundSource[] redirectSoundSources() {
        return CommonValues.SOUND_SOURCES;
    }
}
