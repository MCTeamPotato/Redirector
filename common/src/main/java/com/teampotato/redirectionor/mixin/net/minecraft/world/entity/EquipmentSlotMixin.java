package com.teampotato.redirectionor.mixin.net.minecraft.world.entity;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

@Mixin(EquipmentSlot.class)
public abstract class EquipmentSlotMixin {
    @Unique
    private static final Map<String, EquipmentSlot> EQUIPMENT_SLOT_NAME_MAP = new Object2ObjectOpenHashMap<>();
    @Unique
    private static final Map<EquipmentSlot.Type, EquipmentSlot> EQUIPMENT_SLOT_TYPE_MAP = new Object2ObjectOpenHashMap<>();

    static {
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            EQUIPMENT_SLOT_NAME_MAP.put(equipmentSlot.getName(), equipmentSlot);
            EQUIPMENT_SLOT_TYPE_MAP.put(equipmentSlot.getType(), equipmentSlot);
        }
    }
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static EquipmentSlot byName(String targetName) {
        return EQUIPMENT_SLOT_NAME_MAP.get(targetName);
    }


    /**
     * @author Kasualix
     * @reason use faster map impl
     * Returns the slot type based on the slot group and the index inside that group.
     */
    @Overwrite
    public static EquipmentSlot byTypeAndIndex(EquipmentSlot.Type slotType, int slotIndex) {
        EquipmentSlot equipmentSlot = EQUIPMENT_SLOT_TYPE_MAP.get(slotType);
        if (equipmentSlot != null && equipmentSlot.getIndex() == slotIndex) return equipmentSlot;
        throw new IllegalArgumentException("Invalid slot '" + slotType + "': " + slotIndex);
    }
}
