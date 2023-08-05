package com.teampotato.redirectionor.mixin.server.commands;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.server.commands.GameModeCommand;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameModeCommand.class)
public class GameModeCommandMixin {
    @Redirect(method = "register", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/GameType;values()[Lnet/minecraft/world/level/GameType;"))
    private static GameType[] redirectGameType() {
        return Redirectionor.GAME_TYPES;
    }
}
