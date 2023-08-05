package com.teampotato.redirectionor.mixin.client.gui.screens;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.gui.screens.EditServerScreen;
import net.minecraft.client.multiplayer.ServerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EditServerScreen.class)
public abstract class EditServerScreenMixin {
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ServerData$ServerPackStatus;values()[Lnet/minecraft/client/multiplayer/ServerData$ServerPackStatus;"))
    private ServerData.ServerPackStatus[] redirectServerPackStatus() {
        return Redirectionor.SERVER_PACK_STATUSES;
    }
}
