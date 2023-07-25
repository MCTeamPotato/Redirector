package com.teampotato.redirectionor.mixin.world.phys.shapes;

import com.teampotato.redirectionor.references.DirectionReferences;
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
}
