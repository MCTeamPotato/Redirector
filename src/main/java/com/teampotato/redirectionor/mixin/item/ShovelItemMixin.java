package com.teampotato.redirectionor.mixin.item;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShovelItem.class)
public abstract class ShovelItemMixin {
    @Redirect(method = "useOn", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown1() {
        return Redirectionor.DOWN;
    }
}
