package com.teampotato.redirectionor.mixin.client;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.Options;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.PlayerModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Options.class)
public abstract class OptionsMixin {
    @Redirect(method = {"load", "save"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/sounds/SoundSource;values()[Lnet/minecraft/sounds/SoundSource;"))
    private SoundSource[] redirectSoundSource() {
        return Redirectionor.SOUND_SOURCES;
    }

    @Redirect(method = {"load", "save"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/PlayerModelPart;values()[Lnet/minecraft/world/entity/player/PlayerModelPart;"))
    private PlayerModelPart[] redirectPlayerModelPart() {
        return Redirectionor.PLAYER_MODEL_PARTS;
    }
}
