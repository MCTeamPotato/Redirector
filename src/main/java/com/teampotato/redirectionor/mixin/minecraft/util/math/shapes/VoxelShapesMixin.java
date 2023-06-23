package com.teampotato.redirectionor.mixin.minecraft.util.math.shapes;

import com.google.common.math.DoubleMath;
import com.teampotato.redirectionor.Redirectionor;
import com.teampotato.redirectionor.api.ExtendedVoxelShape;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.SplitVoxelShape;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(VoxelShapes.class)
public abstract class VoxelShapesMixin {
    @Shadow public static VoxelShape block() {
        throw new RuntimeException();
    }

    @Shadow public static boolean joinIsNotEmpty(VoxelShape pShape1, VoxelShape pShape2, IBooleanFunction pResultOperator) {
        throw new RuntimeException();
    }

    @Shadow public static VoxelShape empty() {
        throw new RuntimeException();
    }

    @Shadow public static VoxelShape joinUnoptimized(VoxelShape pShape1, VoxelShape pShape2, IBooleanFunction pFunction) {
        throw new RuntimeException();
    }

    /**
     * @author Kasalix
     * @reason avoid allocation
     */
    @Overwrite
    @OnlyIn(Dist.CLIENT)
    public static boolean blockOccudes(VoxelShape pShape, VoxelShape pAdjacentShape, Direction pSide) {
        if (pShape == block() && pAdjacentShape == block()) {
            return true;
        } else if (pAdjacentShape.isEmpty()) {
            return false;
        } else {
            Direction.Axis direction$axis = pSide.getAxis();
            Direction.AxisDirection direction$axisdirection = pSide.getAxisDirection();
            VoxelShape voxelshape = direction$axisdirection == Redirectionor.POSITIVE ? pShape : pAdjacentShape;
            VoxelShape voxelshape1 = direction$axisdirection == Redirectionor.POSITIVE ? pAdjacentShape : pShape;
            IBooleanFunction ibooleanfunction = direction$axisdirection == Redirectionor.POSITIVE ? IBooleanFunction.ONLY_FIRST : IBooleanFunction.ONLY_SECOND;
            return DoubleMath.fuzzyEquals(voxelshape.max(direction$axis), 1.0D, 1.0E-7D) && DoubleMath.fuzzyEquals(voxelshape1.min(direction$axis), 0.0D, 1.0E-7D) && !joinIsNotEmpty(new SplitVoxelShape(voxelshape, direction$axis, ((ExtendedVoxelShape)voxelshape).redirectionor$getShape().getSize(direction$axis) - 1), new SplitVoxelShape(voxelshape1, direction$axis, 0), ibooleanfunction);
        }
    }

    /**
     * @author Kasalix
     * @reason avoid allocation
     */
    @Overwrite
    public static VoxelShape getFaceShape(VoxelShape pVoxelShape, Direction pDirection) {
        if (pVoxelShape == block()) {
            return block();
        } else {
            Direction.Axis direction$axis = pDirection.getAxis();
            boolean flag;
            int i;
            if (pDirection.getAxisDirection() == Redirectionor.POSITIVE) {
                flag = DoubleMath.fuzzyEquals(pVoxelShape.max(direction$axis), 1.0D, 1.0E-7D);
                i = ((ExtendedVoxelShape)pVoxelShape).redirectionor$getShape().getSize(direction$axis) - 1;
            } else {
                flag = DoubleMath.fuzzyEquals(pVoxelShape.min(direction$axis), 0.0D, 1.0E-7D);
                i = 0;
            }

            return !flag ? empty() : new SplitVoxelShape(pVoxelShape, direction$axis, i);
        }
    }

    /**
     * @author Kasalix
     * @reason avoid allocation
     */
    @Overwrite
    public static boolean mergedFaceOccludes(VoxelShape pShape, VoxelShape pAdjacentShape, Direction pSide) {
        if (pShape != block() && pAdjacentShape != block()) {
            Direction.Axis direction$axis = pSide.getAxis();
            Direction.AxisDirection direction$axisdirection = pSide.getAxisDirection();
            VoxelShape voxelshape = direction$axisdirection == Redirectionor.POSITIVE ? pShape : pAdjacentShape;
            VoxelShape voxelshape1 = direction$axisdirection == Redirectionor.POSITIVE ? pAdjacentShape : pShape;
            if (!DoubleMath.fuzzyEquals(voxelshape.max(direction$axis), 1.0D, 1.0E-7D)) voxelshape = empty();
            if (!DoubleMath.fuzzyEquals(voxelshape1.min(direction$axis), 0.0D, 1.0E-7D)) voxelshape1 = empty();
            return !joinIsNotEmpty(block(), joinUnoptimized(new SplitVoxelShape(voxelshape, direction$axis, ((ExtendedVoxelShape)voxelshape).redirectionor$getShape().getSize(direction$axis) - 1), new SplitVoxelShape(voxelshape1, direction$axis, 0), IBooleanFunction.OR), IBooleanFunction.ONLY_FIRST);
        } else {
            return true;
        }
    }
}
