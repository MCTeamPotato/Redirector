package com.teampotato.redirector.forge.mixin.net.minecraftforge.fml.network;

import com.teampotato.redirector.forge.utils.CommonValues;
import net.minecraftforge.fml.network.NetworkDirection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = NetworkDirection.class, remap = false)
public abstract class NetworkDirectionMixin {
    @Redirect(method = "reply", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/fml/network/NetworkDirection;values()[Lnet/minecraftforge/fml/network/NetworkDirection;"))
    private NetworkDirection[] redirectNetworkDirections() {
        return CommonValues.NETWORK_DIRECTIONS;
    }
}
