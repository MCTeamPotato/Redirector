package com.teampotato.redirectionor.mixin.server.commands;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.server.commands.PlaySoundCommand;
import net.minecraft.sounds.SoundSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlaySoundCommand.class)
public abstract class PlaySoundCommandMixin {
    @Redirect(method = "register", at = @At(value = "INVOKE", target = "Lnet/minecraft/sounds/SoundSource;values()[Lnet/minecraft/sounds/SoundSource;"))
    private static SoundSource[] redirectSoundSource() {
        return Redirectionor.SOUND_SOURCES;
    }
}
