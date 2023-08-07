package com.teampotato.redirectionor.mixin.client.gui.screens;

import net.minecraft.client.gui.screens.SkinCustomizationScreen;
import net.minecraft.world.entity.player.PlayerModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SkinCustomizationScreen.class)
public abstract class SkinCustomizationScreenMixin {
    @Unique
    private static final PlayerModelPart[] PLAYER_MODEL_PARTS = PlayerModelPart.values();
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/PlayerModelPart;values()[Lnet/minecraft/world/entity/player/PlayerModelPart;"))
    private PlayerModelPart[] redirectPlayerModelPart() {
        return PLAYER_MODEL_PARTS;
    }
}
