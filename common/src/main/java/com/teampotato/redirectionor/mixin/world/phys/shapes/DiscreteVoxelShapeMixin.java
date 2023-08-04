package com.teampotato.redirectionor.mixin.world.phys.shapes;

import com.teampotato.redirectionor.references.AxisCycleReferences;
import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.AxisCycle;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DiscreteVoxelShape.class)
public abstract class DiscreteVoxelShapeMixin {
    @Redirect(method = "forAllAxisFaces", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$AxisDirection;POSITIVE:Lnet/minecraft/core/Direction$AxisDirection;"))
    private Direction.AxisDirection redirectAxisDirectionPOSITIVE() {
        return DirectionReferences.AxisDirectionReferences.POSITIVE;
    }

    @Redirect(method = "forAllAxisFaces", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$AxisDirection;NEGATIVE:Lnet/minecraft/core/Direction$AxisDirection;"))
    private Direction.AxisDirection redirectAxisDirectionNEGATIVE() {
        return DirectionReferences.AxisDirectionReferences.NEGATIVE;
    }

    @Redirect(method = {"forAllEdges", "forAllFaces"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/AxisCycle;NONE:Lnet/minecraft/core/AxisCycle;"))
    private AxisCycle redirectAxisCycleNONE() {
        return AxisCycleReferences.NONE;
    }

    @Redirect(method = {"forAllEdges", "forAllFaces", "firstFull(Lnet/minecraft/core/Direction$Axis;II)I", "lastFull(Lnet/minecraft/core/Direction$Axis;II)I"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/AxisCycle;FORWARD:Lnet/minecraft/core/AxisCycle;"))
    private AxisCycle redirectAxisCycleFORWARD() {
        return AxisCycleReferences.FORWARD;
    }

    @Redirect(method = {"forAllEdges", "forAllFaces", "firstFull(Lnet/minecraft/core/Direction$Axis;II)I", "lastFull(Lnet/minecraft/core/Direction$Axis;II)I"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/AxisCycle;BACKWARD:Lnet/minecraft/core/AxisCycle;"))
    private AxisCycle redirectAxisCycleBACKWARD() {
        return AxisCycleReferences.BACKWARD;
    }
}
