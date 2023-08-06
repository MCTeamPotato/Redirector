package com.teampotato.redirectionor.mixin.client.gui.screens.worldselection;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CreateWorldScreen.class)
public abstract class CreateWorldScreenMixin {
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/Difficulty;values()[Lnet/minecraft/world/Difficulty;"))
    private Difficulty[] redirectDifficulty() {
        return Redirectionor.DIFFICULTIES;
    }
}
