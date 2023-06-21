package com.teampotato.redirectionor.mixin.item;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.item.ScaffoldingItem;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ScaffoldingItem.class)
public abstract class ScaffoldingItemMixin {
    @Redirect(method = "updatePlacementContext", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp1() {
        return Redirectionor.UP;
    }
}
