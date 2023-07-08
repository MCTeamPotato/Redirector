package com.teampotato.redirectionor.mixin.minecraft.util.math.shapes;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShapePart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VoxelShapePart.class)
public abstract class VoxelShapePartMixin {

    @Redirect(method = "forAllAxisFaces", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$AxisDirection;POSITIVE:Lnet/minecraft/util/Direction$AxisDirection;"))
    private Direction.AxisDirection implPositive() {
        return Redirectionor.POSITIVE;
    }

    @Redirect(method = "forAllAxisFaces", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$AxisDirection;NEGATIVE:Lnet/minecraft/util/Direction$AxisDirection;"))
    private Direction.AxisDirection implNegative() {
        return Redirectionor.NEGATIVE;
    }

    @Redirect(method = "forAllAxisFaces", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;X:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implX() {
        return Redirectionor.X;
    }

    @Redirect(method = "forAllAxisFaces", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;Y:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implY() {
        return Redirectionor.Y;
    }

    @Redirect(method = "forAllAxisFaces", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;Z:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implZ() {
        return Redirectionor.Z;
    }
}
