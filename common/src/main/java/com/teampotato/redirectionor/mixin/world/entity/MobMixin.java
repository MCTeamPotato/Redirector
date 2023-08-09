package com.teampotato.redirectionor.mixin.world.entity;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Mob.class)
public class MobMixin {
    @Redirect(method = {"dropCustomDeathLoot", "populateDefaultEquipmentSlots", "populateDefaultEquipmentEnchantments", "convertTo"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private EquipmentSlot[] redirectEquipmentSlot() {
        return Values.EQUIPMENT_SLOTS;
    }
}
