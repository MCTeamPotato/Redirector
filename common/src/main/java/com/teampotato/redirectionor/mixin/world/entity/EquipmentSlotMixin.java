package com.teampotato.redirectionor.mixin.world.entity;

import com.teampotato.redirectionor.common.Maps;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EquipmentSlot.class)
public abstract class EquipmentSlotMixin {/**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static EquipmentSlot byTypeAndIndex(EquipmentSlot.Type type, int i) {
        EquipmentSlot equipmentSlot = Maps.TYPE_EQUIPMENT_SLOT_MAP.get(type);
        if (equipmentSlot.getIndex() != i) throw new IllegalArgumentException("Invalid slot '" + type + "': " + i);
        return equipmentSlot;
    }

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static EquipmentSlot byName(String string) {
        return Maps.STRING_EQUIPMENT_SLOT_MAP.get(string);
    }
}
