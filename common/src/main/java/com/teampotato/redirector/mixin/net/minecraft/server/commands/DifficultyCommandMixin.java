package com.teampotato.redirector.mixin.net.minecraft.server.commands;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.server.commands.DifficultyCommand;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DifficultyCommand.class)
public abstract class DifficultyCommandMixin {
    @Redirect(method = "register", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/Difficulty;values()[Lnet/minecraft/world/Difficulty;"))
    private static Difficulty[] redirectDifficulties() {
        return CommonValues.DIFFICULTIES;
    }
}
