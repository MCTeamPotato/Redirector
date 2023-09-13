package com.teampotato.redirector.mixin.net.minecraft.server.commands;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.server.commands.GameModeCommand;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameModeCommand.class)
public abstract class GameModeCommandMixin {
    @Redirect(method = "register", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/GameType;values()[Lnet/minecraft/world/level/GameType;"))
    private static GameType[] redirectGameTypes() {
        return CommonValues.GAME_TYPES;
    }
}
