package com.teampotato.redirector.mixin.net.minecraft.world.item;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Enchantments.class)
public abstract class EnchantmentsMixin {
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private static EquipmentSlot[] redirectEquipmentSlots() {
        return CommonValues.EQUIPMENT_SLOTS;
    }
}
