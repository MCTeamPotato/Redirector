package com.teampotato.redirectionor.mixin.world.level;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameType.class)
public abstract class GameTypeMixin {
    @Redirect(method = {"byId(ILnet/minecraft/world/level/GameType;)Lnet/minecraft/world/level/GameType;", "byName(Ljava/lang/String;Lnet/minecraft/world/level/GameType;)Lnet/minecraft/world/level/GameType;"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/GameType;values()[Lnet/minecraft/world/level/GameType;"))
    private static GameType[] redirectGameType() {
        return Redirectionor.GAME_TYPES;
    }

}
