package com.teampotato.redirectionor.mixin.item;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.item.DirectionalPlaceContext;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DirectionalPlaceContext.class)
public abstract class DirectionalPlaceContextMixin {
    @Redirect(method = "getNearestLookingDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown1() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "getNearestLookingDirections", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown2() {
        return Redirectionor.DOWN;
    }
}
