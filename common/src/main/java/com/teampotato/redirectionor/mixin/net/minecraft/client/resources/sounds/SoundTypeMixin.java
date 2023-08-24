package com.teampotato.redirectionor.mixin.net.minecraft.client.resources.sounds;

import net.minecraft.client.resources.sounds.Sound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Sound.Type.class)
public abstract class SoundTypeMixin {
    @Unique
    private static final Sound.Type[] SOUND_TYPES = Sound.Type.values();
    @Redirect(method = "getByName", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/sounds/Sound$Type;values()[Lnet/minecraft/client/resources/sounds/Sound$Type;"))
    private static Sound.Type[] redirectSoundType() {
        return SOUND_TYPES;
    }
}
