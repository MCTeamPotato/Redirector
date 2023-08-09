package com.teampotato.redirectionor.mixin.server.commands;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.server.commands.StopSoundCommand;
import net.minecraft.sounds.SoundSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StopSoundCommand.class)
public abstract class StopSoundCommandMixin {
    @Redirect(method = "register", at = @At(value = "INVOKE", target = "Lnet/minecraft/sounds/SoundSource;values()[Lnet/minecraft/sounds/SoundSource;"))
    private static SoundSource[] redirectSoundSource() {
        return Values.SOUND_SOURCES;
    }
}
