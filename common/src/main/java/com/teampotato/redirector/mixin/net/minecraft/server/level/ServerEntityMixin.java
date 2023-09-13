package com.teampotato.redirector.mixin.net.minecraft.server.level;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerEntity.class)
public abstract class ServerEntityMixin {
    @Redirect(method = "sendPairingData", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private EquipmentSlot[] redirectEquipmentSlots() {
        return CommonValues.EQUIPMENT_SLOTS;
    }
}
