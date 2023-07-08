package com.teampotato.redirectionor.mixin.minecraft.util.math.shapes;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShapes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VoxelShapes.class)
public abstract class VoxelShapesMixin {

    @Redirect(method = {"blockOccudes", "getFaceShape", "mergedFaceOccludes"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$AxisDirection;POSITIVE:Lnet/minecraft/util/Direction$AxisDirection;"))
    private static Direction.AxisDirection implPositive() {
        return Redirectionor.POSITIVE;
    }
}
