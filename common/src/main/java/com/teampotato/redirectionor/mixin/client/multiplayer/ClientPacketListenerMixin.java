package com.teampotato.redirectionor.mixin.client.multiplayer;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.world.InteractionHand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientPacketListener.class)
public abstract class ClientPacketListenerMixin {
    @Redirect(method = "findTotem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/InteractionHand;values()[Lnet/minecraft/world/InteractionHand;"))
    private static InteractionHand[] redirectInteractionHand() {
        return Redirectionor.INTERACTION_HANDS;
    }
}
