package com.teampotato.redirectionor.mixin.client.resources.sounds;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.resources.sounds.Sound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Sound.Type.class)
public abstract class SoundTypeMixin {
    @Redirect(method = "getByName", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/sounds/Sound$Type;values()[Lnet/minecraft/client/resources/sounds/Sound$Type;"))
    private static Sound.Type[] redirectSoundType() {
        return Redirectionor.SOUND_TYPES;
    }
}
