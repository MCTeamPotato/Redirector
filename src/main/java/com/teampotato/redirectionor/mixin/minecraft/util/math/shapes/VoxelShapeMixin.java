package com.teampotato.redirectionor.mixin.minecraft.util.math.shapes;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = VoxelShape.class, priority = 10)
public abstract class VoxelShapeMixin {
    @Redirect(method = "calculateFace", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$AxisDirection;POSITIVE:Lnet/minecraft/util/Direction$AxisDirection;"))
    private static Direction.AxisDirection implPositive() {
        return Redirectionor.POSITIVE;
    }
}
