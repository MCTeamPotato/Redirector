package com.teampotato.redirector.mixin.net.minecraft.core.dispenser;

import com.teampotato.redirector.redirect.CommonValues;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DispenseItemBehavior.class)
public abstract class DispenseItemBehaviorMixin {
    @Redirect(method = "bootStrap", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/DyeColor;values()[Lnet/minecraft/world/item/DyeColor;"))
    private static DyeColor[] redirectDyeColors() {
        return CommonValues.DYE_COLORS;
    }
}
//TODO: Continue