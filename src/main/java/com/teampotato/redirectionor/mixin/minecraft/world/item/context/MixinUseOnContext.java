package com.teampotato.redirectionor.mixin.minecraft.world.item.context;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(UseOnContext.class)
public abstract class MixinUseOnContext {
    @Redirect(method = "getHorizontalDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }
}
