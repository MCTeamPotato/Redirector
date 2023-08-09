package com.teampotato.redirectionor.mixin.world.entity.monster;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.ZombieVillager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ZombieVillager.class)
public abstract class ZombieVillagerMixin {
    @Redirect(method = "finishConversion", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private EquipmentSlot[] redirectEquipmentSlot() {
        return Values.EQUIPMENT_SLOTS;
    }
}
