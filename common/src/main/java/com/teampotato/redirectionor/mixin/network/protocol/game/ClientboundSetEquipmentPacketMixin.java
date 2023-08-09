package com.teampotato.redirectionor.mixin.network.protocol.game;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.network.protocol.game.ClientboundSetEquipmentPacket;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientboundSetEquipmentPacket.class)
public abstract class ClientboundSetEquipmentPacketMixin {
    @Redirect(method = "<init>(Lnet/minecraft/network/FriendlyByteBuf;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private EquipmentSlot[] redirectEquipmentSlot() {
        return Values.EQUIPMENT_SLOTS;
    }
}
