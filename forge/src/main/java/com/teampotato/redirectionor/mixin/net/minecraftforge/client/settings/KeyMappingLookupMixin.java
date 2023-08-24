package com.teampotato.redirectionor.mixin.net.minecraftforge.client.settings;

import net.minecraftforge.client.settings.KeyMappingLookup;
import net.minecraftforge.client.settings.KeyModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = KeyMappingLookup.class, remap = false)
public abstract class KeyMappingLookupMixin {
    @Unique
    private static KeyModifier[] KEY_MODIFIERS = null;
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/client/settings/KeyModifier;values()[Lnet/minecraftforge/client/settings/KeyModifier;"))
    private static KeyModifier[] redirectKeyModifierValues() {
        if (KEY_MODIFIERS == null) KEY_MODIFIERS = KeyModifier.values();
        return KEY_MODIFIERS;
    }
}
