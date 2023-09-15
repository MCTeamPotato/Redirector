package com.teampotato.redirector.mixin.net.minecraft.client.multiplayer;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.world.InteractionHand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientPacketListener.class)
public abstract class ClientPacketListenerMixin {
    @Redirect(method = "findTotem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/InteractionHand;values()[Lnet/minecraft/world/InteractionHand;"))
    private static InteractionHand[] redirectInteractionHands() {
        return CommonValues.INTERACTION_HANDS;
    }
}
