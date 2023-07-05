package com.teampotato.redirectionor.mixin.minecraft.dispenser;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.dispenser.ShulkerBoxDispenseBehavior;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShulkerBoxDispenseBehavior.class)
public abstract class ShulkerBoxDispenseBehaviorMixin {
    @Redirect(method = "execute", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
