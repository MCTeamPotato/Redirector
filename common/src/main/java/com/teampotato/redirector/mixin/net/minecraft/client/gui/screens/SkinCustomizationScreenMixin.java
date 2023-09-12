package com.teampotato.redirector.mixin.net.minecraft.client.gui.screens;

import com.teampotato.redirector.redirect.ClientValues;
import net.minecraft.client.gui.screens.SkinCustomizationScreen;
import net.minecraft.world.entity.player.PlayerModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SkinCustomizationScreen.class)
public abstract class SkinCustomizationScreenMixin {
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/PlayerModelPart;values()[Lnet/minecraft/world/entity/player/PlayerModelPart;"))
    private PlayerModelPart[] redirectPlayerModelParts() {
        return ClientValues.PLAYER_MODEL_PARTS;
    }
}
