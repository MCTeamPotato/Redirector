package com.teampotato.redirectionor.mixin.net.minecraft.server.level;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerEntity.class)
public abstract class ServerEntityMixin {
    @Redirect(method = "sendPairingData", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private EquipmentSlot[] redirectEquipmentSlot() {
        return Redirectionor.EQUIPMENT_SLOTS;
    }
}
