package com.teampotato.redirector.mixin.net.minecraft.commands.arguments.selector.options;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.commands.arguments.selector.options.EntitySelectorOptions;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntitySelectorOptions.class)
public abstract class EntitySelectorOptionsMixin {
    @Dynamic
    @Redirect(method = {"method_9946", "lambda$bootStrap$33"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/GameType;values()[Lnet/minecraft/world/level/GameType;"))
    private static GameType[] redirectGameTypes() {
        return CommonValues.GAME_TYPES;
    }
}
