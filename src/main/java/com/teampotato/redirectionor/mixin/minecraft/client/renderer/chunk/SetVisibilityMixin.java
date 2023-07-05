package com.teampotato.redirectionor.mixin.minecraft.client.renderer.chunk;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.chunk.SetVisibility;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SetVisibility.class)
public abstract class SetVisibilityMixin {
    @Redirect(method = "toString", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt() {
        return Redirectionor.DIRECTIONS;
    }
}
