package com.teampotato.redirectionor.mixin.com.mojang.realmsclient.client;

import com.mojang.realmsclient.client.Ping;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = Ping.class, remap = false)
public abstract class PingMixin {
    @Unique
  private static final Ping.Region[] redirectionor$REGIONS = Ping.Region.values();
    @Redirect(method = "pingAllRegions", at = @At(value = "INVOKE", target = "Lcom/mojang/realmsclient/client/Ping$Region;values()[Lcom/mojang/realmsclient/client/Ping$Region;"))
    private static Ping.Region[] redirectPingRegionValues() {
        return redirectionor$REGIONS;
    }
}
