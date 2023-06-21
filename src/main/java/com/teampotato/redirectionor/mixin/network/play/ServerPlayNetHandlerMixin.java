package com.teampotato.redirectionor.mixin.network.play;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.network.play.ServerPlayNetHandler;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayNetHandler.class)
public abstract class ServerPlayNetHandlerMixin {
    @Redirect(method = "handleUseItemOn", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp1() {
        return Redirectionor.UP;
    }
}
