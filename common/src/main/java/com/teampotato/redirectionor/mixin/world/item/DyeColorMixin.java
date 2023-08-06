package com.teampotato.redirectionor.mixin.world.item;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DyeColor.class)
public abstract class DyeColorMixin {
    @Redirect(method = "byName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/DyeColor;values()[Lnet/minecraft/world/item/DyeColor;"))
    private static DyeColor[] redirectDyeColor() {
        return Redirectionor.DYE_COLORS;
    }
}
