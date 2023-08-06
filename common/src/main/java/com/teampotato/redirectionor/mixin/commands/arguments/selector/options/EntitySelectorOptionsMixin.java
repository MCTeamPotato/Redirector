package com.teampotato.redirectionor.mixin.commands.arguments.selector.options;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.commands.arguments.selector.options.EntitySelectorOptions;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntitySelectorOptions.class)
public abstract class EntitySelectorOptionsMixin {
    @Redirect(method = "method_9946", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/GameType;values()[Lnet/minecraft/world/level/GameType;"))
    private static GameType[] redirectGameType() {
        return Redirectionor.GAME_TYPES;
    }
}
