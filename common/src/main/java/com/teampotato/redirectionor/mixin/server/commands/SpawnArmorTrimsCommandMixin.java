package com.teampotato.redirectionor.mixin.server.commands;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.server.commands.SpawnArmorTrimsCommand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpawnArmorTrimsCommand.class)
public abstract class SpawnArmorTrimsCommandMixin {
    @Redirect(method = "spawnArmorTrims", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ArmorMaterials;values()[Lnet/minecraft/world/item/ArmorMaterials;"))
    private static ArmorMaterials[] redirectArmorMaterials() {
        return Values.ARMOR_MATERIALS;
    }

    @Redirect(method = "spawnArmorTrims", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private static EquipmentSlot[] redirectEquipmentSlot() {
        return Values.EQUIPMENT_SLOTS;
    }
}
