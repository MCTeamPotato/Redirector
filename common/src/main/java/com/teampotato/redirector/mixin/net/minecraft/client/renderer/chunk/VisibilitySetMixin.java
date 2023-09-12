package com.teampotato.redirector.mixin.net.minecraft.client.renderer.chunk;

import com.teampotato.redirector.redirect.CommonValues;
import net.minecraft.client.renderer.chunk.VisibilitySet;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VisibilitySet.class)
public abstract class VisibilitySetMixin {
    @Redirect(method = "toString", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirections() {
        return CommonValues.DIRECTIONS;
    }
}
