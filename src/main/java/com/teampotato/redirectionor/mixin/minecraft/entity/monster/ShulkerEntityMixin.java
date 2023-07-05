package com.teampotato.redirectionor.mixin.minecraft.entity.monster;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShulkerEntity.class)
public abstract class ShulkerEntityMixin {
    @Redirect(method = "findAttachableFace", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "defineSynchedData", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}
