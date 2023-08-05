package com.teampotato.redirectionor.mixin.client.gui.screens.inventory;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.gui.screens.inventory.SmithingScreen;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SmithingScreen.class)
public abstract class SmithingScreenMixin {
    @Redirect(method = "updateArmorStandPreview", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private EquipmentSlot[] redirectEquipmentSlot() {
        return Redirectionor.EQUIPMENT_SLOTS;
    }
}
