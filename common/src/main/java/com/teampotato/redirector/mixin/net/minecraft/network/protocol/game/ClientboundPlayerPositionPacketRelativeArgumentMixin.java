package com.teampotato.redirector.mixin.net.minecraft.network.protocol.game;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientboundPlayerPositionPacket.RelativeArgument.class)
public abstract class ClientboundPlayerPositionPacketRelativeArgumentMixin {
    @Redirect(method = "unpack", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/protocol/game/ClientboundPlayerPositionPacket$RelativeArgument;values()[Lnet/minecraft/network/protocol/game/ClientboundPlayerPositionPacket$RelativeArgument;"))
    private static ClientboundPlayerPositionPacket.RelativeArgument[] redirectClientboundPlayerPositionPacketRelativeArguments() {
        return CommonValues.RELATIVE_ARGUMENTS;
    }
}
