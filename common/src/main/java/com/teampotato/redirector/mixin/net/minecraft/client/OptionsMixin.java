package com.teampotato.redirector.mixin.net.minecraft.client;

import com.teampotato.redirector.utils.values.ClientValues;
import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.client.Options;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.PlayerModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Options.class)
public abstract class OptionsMixin {
    @Redirect(method = "processOptions", at = @At(value = "INVOKE", target = "Lnet/minecraft/sounds/SoundSource;values()[Lnet/minecraft/sounds/SoundSource;"))
    private SoundSource[] redirectSoundSources() {
        return CommonValues.SOUND_SOURCES;
    }

    @Redirect(method = "processOptions", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/PlayerModelPart;values()[Lnet/minecraft/world/entity/player/PlayerModelPart;"))
    private PlayerModelPart[] redirectPlayerModelParts() {
        return ClientValues.PLAYER_MODEL_PARTS;
    }
}
