package com.teampotato.redirectionor.mixin.client.gui.screens;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.gui.screens.EditServerScreen;
import net.minecraft.client.multiplayer.ServerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EditServerScreen.class)
public abstract class EditServerScreenMixin {
    @Unique
    private static final ServerData.ServerPackStatus[] SERVER_PACK_STATUSES = ServerData.ServerPackStatus.values();
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ServerData$ServerPackStatus;values()[Lnet/minecraft/client/multiplayer/ServerData$ServerPackStatus;"))
    private ServerData.ServerPackStatus[] redirectServerPackStatus() {
        return SERVER_PACK_STATUSES;
    }
}
