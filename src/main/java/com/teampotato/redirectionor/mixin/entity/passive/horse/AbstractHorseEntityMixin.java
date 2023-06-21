package com.teampotato.redirectionor.mixin.entity.passive.horse;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractHorseEntity.class)
public abstract class AbstractHorseEntityMixin {
    @Redirect(method = "getDismountLocationInDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp1() {
        return Redirectionor.UP;
    }
}
