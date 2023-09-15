package com.teampotato.redirector.mixin.net.minecraft.world.entity;

import com.teampotato.redirector.utils.map.CommonMaps;
import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EquipmentSlot.class)
public abstract class EquipmentSlotMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static EquipmentSlot byName(String targetName) {
        return CommonMaps.EQUIPMENT_SLOT_NAME_MAP.get(targetName);
    }

    @Redirect(method = "byTypeAndIndex", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private static EquipmentSlot[] redirectEquipmentSlots() {
        return CommonValues.EQUIPMENT_SLOTS;
    }
}
