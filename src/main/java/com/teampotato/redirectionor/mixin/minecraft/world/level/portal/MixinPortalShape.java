package com.teampotato.redirectionor.mixin.minecraft.world.level.portal;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.portal.PortalShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PortalShape.class)
public abstract class MixinPortalShape {
    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }
}
