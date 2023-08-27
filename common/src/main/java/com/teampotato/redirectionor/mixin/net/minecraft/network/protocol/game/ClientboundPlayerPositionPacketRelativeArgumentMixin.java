package com.teampotato.redirectionor.mixin.net.minecraft.network.protocol.game;

import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientboundPlayerPositionPacket.RelativeArgument.class)
public abstract class ClientboundPlayerPositionPacketRelativeArgumentMixin {
    @Unique private static final ClientboundPlayerPositionPacket.RelativeArgument[] CLIENTBOUND_PLAYER_POSITION_PACKET_RELATIVE_ARGUMENTS = ClientboundPlayerPositionPacket.RelativeArgument.values();
    @Redirect(method = "unpack", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/protocol/game/ClientboundPlayerPositionPacket$RelativeArgument;values()[Lnet/minecraft/network/protocol/game/ClientboundPlayerPositionPacket$RelativeArgument;"))
    private static ClientboundPlayerPositionPacket.RelativeArgument[] redirectRelativeArgument() {
        return CLIENTBOUND_PLAYER_POSITION_PACKET_RELATIVE_ARGUMENTS;
    }
}
