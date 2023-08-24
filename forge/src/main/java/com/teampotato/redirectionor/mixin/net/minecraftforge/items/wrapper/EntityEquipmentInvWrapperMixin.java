package com.teampotato.redirectionor.mixin.net.minecraftforge.items.wrapper;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.items.wrapper.EntityEquipmentInvWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = EntityEquipmentInvWrapper.class, remap = false)
public abstract class EntityEquipmentInvWrapperMixin {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EquipmentSlot;values()[Lnet/minecraft/world/entity/EquipmentSlot;"))
    private EquipmentSlot[] redirectEquipmentSlotValues() {
        return Redirectionor.EQUIPMENT_SLOTS;
    }
}
