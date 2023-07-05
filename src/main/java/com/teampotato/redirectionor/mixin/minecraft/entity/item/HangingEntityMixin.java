package com.teampotato.redirectionor.mixin.minecraft.entity.item;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.entity.item.HangingEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HangingEntity.class)
public abstract class HangingEntityMixin {
    @Redirect(method = "survives", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
