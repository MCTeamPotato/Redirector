package com.teampotato.redirectionor.mixin.world.level.block.entity;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShulkerBoxBlockEntity.class)
public abstract class ShulkerBoxBlockEntityMixin {
    @Redirect(method = "moveCollidedEntities", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$AxisDirection;POSITIVE:Lnet/minecraft/core/Direction$AxisDirection;"))
    private Direction.AxisDirection redirectAxisDirectionPOSITIVE() {
        return DirectionReferences.AxisDirectionReferences.POSITIVE;
    }
}
