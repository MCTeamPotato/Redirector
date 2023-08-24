package com.teampotato.redirectionor.mixin.net.minecraft.world.entity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EquipmentSlot.class)
public abstract class EquipmentSlotMixin {
    @Redirect(method = {"byName", "byTypeAndIndex"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private static EquipmentSlot[] redirectEquipmentSlot() {
        return Redirectionor.EQUIPMENT_SLOTS;
    }
}
