package com.teampotato.redirectionor.mixin.com.mojang.math;

import com.mojang.math.OctahedralGroup;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = OctahedralGroup.class, remap = false)
public abstract class OctahedralGroupMixin {
    @Unique
  private static final Direction.Axis[] redirectionor$AXES = Direction.Axis.values();

    @Redirect(method = "rotate(Lnet/minecraft/core/Direction;)Lnet/minecraft/core/Direction;", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirectionValues() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "rotate(Lnet/minecraft/core/Direction;)Lnet/minecraft/core/Direction;", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction$Axis;values()[Lnet/minecraft/core/Direction$Axis;"))
    private Direction.Axis[] redirectDirectionAxisValues() {
        return redirectionor$AXES;
    }
}
