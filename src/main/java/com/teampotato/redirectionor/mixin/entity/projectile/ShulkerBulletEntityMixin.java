package com.teampotato.redirectionor.mixin.entity.projectile;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShulkerBulletEntity.class)
public abstract class ShulkerBulletEntityMixin {
    @Redirect(method = "selectNextMoveDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}
