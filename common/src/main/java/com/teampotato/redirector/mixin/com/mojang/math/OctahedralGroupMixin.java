package com.teampotato.redirector.mixin.com.mojang.math;

import com.mojang.math.OctahedralGroup;
import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(OctahedralGroup.class)
public abstract class OctahedralGroupMixin {
    @Redirect(method = "rotate(Lnet/minecraft/core/Direction;)Lnet/minecraft/core/Direction;", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirections() {
        return CommonValues.DIRECTIONS;
    }

    @Redirect(method = "rotate(Lnet/minecraft/core/Direction;)Lnet/minecraft/core/Direction;", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction$Axis;values()[Lnet/minecraft/core/Direction$Axis;"))
    private Direction.Axis[] redirectDirectionAxes() {
        return CommonValues.AXES;
    }
}
