package com.teampotato.redirectionor.mixin.api;

import com.teampotato.redirectionor.api.ExtendedVoxelShape;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapePart;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(VoxelShape.class)
public abstract class VoxelShapeImpl implements ExtendedVoxelShape {
    @Shadow @Final protected VoxelShapePart shape;

    @Override
    public VoxelShapePart redirectionor$getShape() {
        return this.shape;
    }
}
