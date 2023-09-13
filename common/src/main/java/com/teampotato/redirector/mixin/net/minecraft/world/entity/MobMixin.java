package com.teampotato.redirector.mixin.net.minecraft.world.entity;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Mob.class)
public abstract class MobMixin {
    @Redirect(method = {"dropCustomDeathLoot", "populateDefaultEquipmentSlots", "populateDefaultEquipmentEnchantments", "convertTo"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private EquipmentSlot[] redirectEquipmentSlots() {
        return CommonValues.EQUIPMENT_SLOTS;
    }
}
