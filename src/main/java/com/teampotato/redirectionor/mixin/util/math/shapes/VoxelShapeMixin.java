package com.teampotato.redirectionor.mixin.util.math.shapes;

import com.google.common.math.DoubleMath;
import com.teampotato.redirectionor.Redirectionor;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.SplitVoxelShape;
import net.minecraft.util.math.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = VoxelShape.class, priority = 10)
public abstract class VoxelShapeMixin {
    @Shadow protected abstract DoubleList getCoords(Direction.Axis pAxis);

    @Shadow protected abstract int findIndex(Direction.Axis pAxis, double pPosition);

    /**
     * @author Kasalix
     * @reason avoid allocation
     */
    @Overwrite
    private VoxelShape calculateFace(Direction pSide) {
        Direction.Axis direction$axis = pSide.getAxis();
        Direction.AxisDirection direction$axisdirection = pSide.getAxisDirection();
        DoubleList doublelist = this.getCoords(direction$axis);
        if (doublelist.size() == 2 && DoubleMath.fuzzyEquals(doublelist.getDouble(0), 0.0D, 1.0E-7D) && DoubleMath.fuzzyEquals(doublelist.getDouble(1), 1.0D, 1.0E-7D)) {
            return (VoxelShape) (Object)this;
        } else {
            int i = this.findIndex(direction$axis, direction$axisdirection == Redirectionor.POSITIVE ? 0.9999999D : 1.0E-7D);
            return new SplitVoxelShape((VoxelShape) (Object)this, direction$axis, i);
        }
    }
}
