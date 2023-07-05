package com.teampotato.redirectionor.mixin.minecraft.core.dispenser;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.ShulkerBoxDispenseBehavior;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShulkerBoxDispenseBehavior.class)
public abstract class MixinShulkerBoxDispenseBehavior {
    @Redirect(method = "execute", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
