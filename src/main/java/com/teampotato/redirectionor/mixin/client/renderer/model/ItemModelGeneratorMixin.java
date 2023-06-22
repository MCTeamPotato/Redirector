package com.teampotato.redirectionor.mixin.client.renderer.model;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.model.ItemModelGenerator;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemModelGenerator.class)
public abstract class ItemModelGeneratorMixin {
    @Redirect(method = "processFrames", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }
}
