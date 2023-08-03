package com.teampotato.redirectionor.mixin.world.phys.shapes;

import com.teampotato.redirectionor.references.AxisCycleReferences;
import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.AxisCycle;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VoxelShape.class)
public abstract class VoxelShapeMixin {
    @Redirect(method = "calculateFace", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$AxisDirection;POSITIVE:Lnet/minecraft/core/Direction$AxisDirection;"))
    private Direction.AxisDirection redirectAxisDirectionPOSITIVE() {
        return DirectionReferences.AxisDirectionReferences.POSITIVE;
    }

    @Redirect(method = "min(Lnet/minecraft/core/Direction$Axis;DD)D", at = @At(value = "FIELD", target = "Lnet/minecraft/core/AxisCycle;FORWARD:Lnet/minecraft/core/AxisCycle;"))
    private AxisCycle redirectAxisCycleFORWARD() {
        return AxisCycleReferences.FORWARD;
    }

    @Redirect(method = "max(Lnet/minecraft/core/Direction$Axis;DD)D", at = @At(value = "FIELD", target = "Lnet/minecraft/core/AxisCycle;BACKWARD:Lnet/minecraft/core/AxisCycle;"))
    private AxisCycle redirectAxisCycleBACKWARD() {
        return AxisCycleReferences.BACKWARD;
    }
}
