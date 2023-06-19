package com.teampotato.redirectionor.mixin.item;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.item.ArmorStandItem;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ArmorStandItem.class)
public abstract class ArmorStandItemMixin {
    @Redirect(method = "useOn", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown1() {
        return Redirectionor.DOWN;
    }
}
