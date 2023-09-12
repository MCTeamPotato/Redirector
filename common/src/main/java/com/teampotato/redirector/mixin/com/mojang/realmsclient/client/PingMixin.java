package com.teampotato.redirector.mixin.com.mojang.realmsclient.client;

import com.mojang.realmsclient.client.Ping;
import com.teampotato.redirector.redirect.ClientValues;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Ping.class)
public abstract class PingMixin {
    @Redirect(method = "pingAllRegions", at = @At(value = "INVOKE", target = "Lcom/mojang/realmsclient/client/Ping$Region;values()[Lcom/mojang/realmsclient/client/Ping$Region;"))
    private static Ping.Region[] redirectRegions() {
        return ClientValues.REGIONS;
    }
}
