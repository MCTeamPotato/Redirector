package com.teampotato.redirectionor.mixin.net.minecraftforge.network;

import net.minecraftforge.network.NetworkDirection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = NetworkDirection.class, remap = false)
public abstract class NetworkDirectionMixin {
    @Unique
    static final NetworkDirection[] NETWORK_DIRECTIONS = NetworkDirection.values();

    @Redirect(method = "reply", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/network/NetworkDirection;values()[Lnet/minecraftforge/network/NetworkDirection;"))
    private NetworkDirection[] redirectNetworkDirectionValues() {
        return NETWORK_DIRECTIONS;
    }
}
