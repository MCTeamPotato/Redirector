package com.teampotato.redirectionor.mixin.minecraft.client.multiplayer;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.multiplayer.PlayerController;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerController.class)
public abstract class PlayerControllerMixin {
    @Redirect(method = {"stopDestroyBlock", "releaseUsingItem"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown1() {
        return Redirectionor.DOWN;
    }
}
