package com.teampotato.redirectionor.mixin.net.minecraftforge.fml.network;

import net.minecraftforge.fml.network.NetworkDirection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = NetworkDirection.class, remap = false)
public abstract class NetworkDirectionMixin {
    @Unique
    private static final NetworkDirection[] NETWORK_DIRECTIONS = NetworkDirection.values();
    @Redirect(method = "reply", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/fml/network/NetworkDirection;values()[Lnet/minecraftforge/fml/network/NetworkDirection;"))
    private NetworkDirection[] redirectNetworkDirection() {
        return NETWORK_DIRECTIONS;
    }
}
