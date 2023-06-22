package com.teampotato.redirectionor.mixin.minecraft.util;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.util.TransportationHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TransportationHelper.class)
public abstract class TransportationHelperMixin {
    @Redirect(method = "findCeilingFrom", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"), remap = false)
    private static Direction implUp1() {
        return Redirectionor.UP;
    }
}
