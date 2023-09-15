package com.teampotato.redirector.mixin.net.minecraft.client.gui.screens;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.client.gui.screens.OptionsScreen;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(OptionsScreen.class)
public abstract class OptionsScreenMixin {
    @Redirect(method = "createDifficultyButton", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/Difficulty;values()[Lnet/minecraft/world/Difficulty;"))
    private static Difficulty[] redirectDifficulties() {
        return CommonValues.DIFFICULTIES;
    }
}
