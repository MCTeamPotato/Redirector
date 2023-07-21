package com.teampotato.redirectionor.mixin.minecraft.world.entity.projectile;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.projectile.ShulkerBullet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShulkerBullet.class)
public abstract class MixinShulkerBullet  {
    @Redirect(method = "selectNextMoveDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "selectNextMoveDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
    private Direction implEast() {
        return Redirectionor.EAST;
    }

    @Redirect(method = "selectNextMoveDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "selectNextMoveDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "selectNextMoveDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;WEST:Lnet/minecraft/core/Direction;"))
    private Direction implWest() {
        return Redirectionor.WEST;
    }

    @Redirect(method = {"selectNextMoveDirection", "<init>(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/core/Direction$Axis;)V"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }

    @Redirect(method = "selectNextMoveDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Axis;X:Lnet/minecraft/core/Direction$Axis;"))
    private Direction.Axis implX() {
        return Redirectionor.X;
    }

    @Redirect(method = "selectNextMoveDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Axis;Y:Lnet/minecraft/core/Direction$Axis;"))
    private Direction.Axis implY() {
        return Redirectionor.Y;
    }

    @Redirect(method = "selectNextMoveDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Axis;Z:Lnet/minecraft/core/Direction$Axis;"))
    private Direction.Axis implZ() {
        return Redirectionor.Z;
    }
}
