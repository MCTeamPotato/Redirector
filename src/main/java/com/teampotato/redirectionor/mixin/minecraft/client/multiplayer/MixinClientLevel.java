package com.teampotato.redirectionor.mixin.minecraft.client.multiplayer;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientLevel.class)
public abstract class MixinClientLevel {
    @Redirect(method = "doAnimateTick", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}
