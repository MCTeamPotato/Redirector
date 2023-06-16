package com.teampotato.directionoptimizer.mixin.entity.monster;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShulkerEntity.class)
public abstract class ShulkerEntityMixin {
    @Redirect(method = "findAttachableFace", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
