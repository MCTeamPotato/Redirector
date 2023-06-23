package com.teampotato.redirectionor.mixin.minecraft.util.math.shapes;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.AxisRotation;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShapePart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = VoxelShapePart.class, priority = 10)
public abstract class VoxelShapePartMixin {

    @Shadow public abstract int getSize(Direction.Axis pAxis);
    @Shadow public abstract boolean isFull(AxisRotation pRotation, int pX, int pY, int pZ);

    /**
     * @author Kasalix
     * @reason avoid allocation
     */
    @Overwrite
    private void forAllAxisFaces(VoxelShapePart.IFaceConsumer pFaceConsumer, AxisRotation pAxisRotation) {
        AxisRotation axisrotation = pAxisRotation.inverse();
        Direction.Axis direction$axis = axisrotation.cycle(Direction.Axis.Z);
        int i = this.getSize(axisrotation.cycle(Direction.Axis.X));
        int j = this.getSize(axisrotation.cycle(Direction.Axis.Y));
        int k = this.getSize(direction$axis);
        Direction direction = Direction.fromAxisAndDirection(direction$axis, Redirectionor.NEGATIVE);
        Direction direction1 = Direction.fromAxisAndDirection(direction$axis, Redirectionor.POSITIVE);

        for(int l = 0; l < i; ++l) {
            for(int i1 = 0; i1 < j; ++i1) {
                boolean flag = false;

                for(int j1 = 0; j1 <= k; ++j1) {
                    boolean flag1 = j1 != k && this.isFull(axisrotation, l, i1, j1);
                    if (!flag && flag1) {
                        pFaceConsumer.consume(direction, axisrotation.cycle(l, i1, j1, Direction.Axis.X), axisrotation.cycle(l, i1, j1, Direction.Axis.Y), axisrotation.cycle(l, i1, j1, Direction.Axis.Z));
                    }

                    if (flag && !flag1) {
                        pFaceConsumer.consume(direction1, axisrotation.cycle(l, i1, j1 - 1, Direction.Axis.X), axisrotation.cycle(l, i1, j1 - 1, Direction.Axis.Y), axisrotation.cycle(l, i1, j1 - 1, Direction.Axis.Z));
                    }

                    flag = flag1;
                }
            }
        }

    }
}
