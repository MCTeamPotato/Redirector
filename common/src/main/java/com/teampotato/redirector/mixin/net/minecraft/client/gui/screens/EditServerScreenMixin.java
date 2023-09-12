package com.teampotato.redirector.mixin.net.minecraft.client.gui.screens;

import com.teampotato.redirector.redirect.ClientValues;
import net.minecraft.client.gui.screens.EditServerScreen;
import net.minecraft.client.multiplayer.ServerData;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EditServerScreen.class)
public abstract class EditServerScreenMixin {
    @Dynamic
    @Redirect(method = {"method_19817", "func_213031_c", "lambda$init$1"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ServerData$ServerPackStatus;values()[Lnet/minecraft/client/multiplayer/ServerData$ServerPackStatus;"))
    private ServerData.ServerPackStatus[] redirectServerDataServerPackStatus() {
        return ClientValues.SERVER_PACK_STATUSES;
    }
}
