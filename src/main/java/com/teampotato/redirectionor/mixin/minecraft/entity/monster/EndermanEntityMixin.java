package com.teampotato.redirectionor.mixin.minecraft.entity.monster;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EndermanEntity.class)
public abstract class EndermanEntityMixin {
    @Redirect(method = "teleport(DDD)Z", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}
