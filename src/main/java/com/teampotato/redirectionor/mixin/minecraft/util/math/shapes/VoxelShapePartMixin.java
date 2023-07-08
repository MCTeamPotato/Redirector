package com.teampotato.redirectionor.mixin.minecraft.util.math.shapes;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.AxisRotation;
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

    @Redirect(method = {"forAllAxisFaces", "isFullWide(Lnet/minecraft/util/AxisRotation;III)Z", "isFull(Lnet/minecraft/util/AxisRotation;III)Z", "lastFull(Lnet/minecraft/util/Direction$Axis;II)I", "getXSize", "forAllAxisEdges"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;X:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implX() {
        return Redirectionor.X;
    }

    @Redirect(method = {"forAllAxisFaces", "isFullWide(Lnet/minecraft/util/AxisRotation;III)Z", "isFull(Lnet/minecraft/util/AxisRotation;III)Z", "getYSize", "forAllAxisEdges"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;Y:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implY() {
        return Redirectionor.Y;
    }

    @Redirect(method = {"forAllAxisFaces", "isFullWide(Lnet/minecraft/util/AxisRotation;III)Z", "isFull(Lnet/minecraft/util/AxisRotation;III)Z", "getZSize", "forAllAxisEdges"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;Z:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implZ() {
        return Redirectionor.Z;
    }

    @Redirect(method = {"lastFull(Lnet/minecraft/util/Direction$Axis;II)I", "forAllEdges", "forAllFaces"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/AxisRotation;FORWARD:Lnet/minecraft/util/AxisRotation;"))
    private AxisRotation implForward() {
        return Redirectionor.AXIS_FORWARD;
    }

    @Redirect(method = {"lastFull(Lnet/minecraft/util/Direction$Axis;II)I", "forAllEdges", "forAllFaces"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/AxisRotation;BACKWARD:Lnet/minecraft/util/AxisRotation;"))
    private AxisRotation implBackward() {
        return Redirectionor.AXIS_BACKWARD;
    }

    @Redirect(method = {"forAllEdges", "forAllFaces"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/AxisRotation;NONE:Lnet/minecraft/util/AxisRotation;"))
    private AxisRotation implNone() {
        return Redirectionor.AXIS_NONE;
    }
}
