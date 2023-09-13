package com.teampotato.redirector.mixin.net.minecraft.network.protocol.game;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.network.protocol.game.ClientboundSetEquipmentPacket;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientboundSetEquipmentPacket.class)
public abstract class ClientboundSetEquipmentPacketMixin {
    @Redirect(method = "read", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private EquipmentSlot[] redirectEquipmentSlots() {
        return CommonValues.EQUIPMENT_SLOTS;
    }
}
