package com.teampotato.redirectionor.mixin.minecraft.server.level;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.server.level.PlayerRespawnLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerRespawnLogic.class)
public abstract class MixinPlayerRespawnLogic {
    @Redirect(method = "getOverworldRespawnPos", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private static Direction implUp() {
        return Redirectionor.UP;
    }
}
