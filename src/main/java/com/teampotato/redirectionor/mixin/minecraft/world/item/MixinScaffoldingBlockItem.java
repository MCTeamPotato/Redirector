package com.teampotato.redirectionor.mixin.minecraft.world.item;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ScaffoldingBlockItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ScaffoldingBlockItem.class)
public abstract class MixinScaffoldingBlockItem {
    @Redirect(method = "updatePlacementContext", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
