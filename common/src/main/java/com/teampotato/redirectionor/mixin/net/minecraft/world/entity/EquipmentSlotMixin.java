package com.teampotato.redirectionor.mixin.net.minecraft.world.entity;

import com.teampotato.redirectionor.Redirectionor;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(EquipmentSlot.class)
public abstract class EquipmentSlotMixin {

    @Redirect(method = "byTypeAndIndex", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private static EquipmentSlot[] redirectEquipmentSlotValues() {
        return Redirectionor.EQUIPMENT_SLOTS;
    }

    @Unique
    private static final Map<String, EquipmentSlot> EQUIPMENT_SLOT_NAME_MAP = new Object2ObjectOpenHashMap<>();

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static EquipmentSlot byName(String targetName) {
        if (EQUIPMENT_SLOT_NAME_MAP.isEmpty()) {
            for (EquipmentSlot equipmentSlot : Redirectionor.EQUIPMENT_SLOTS) {
                EQUIPMENT_SLOT_NAME_MAP.put(equipmentSlot.getName(), equipmentSlot);
            }
        }
        return EQUIPMENT_SLOT_NAME_MAP.get(targetName);
    }
}