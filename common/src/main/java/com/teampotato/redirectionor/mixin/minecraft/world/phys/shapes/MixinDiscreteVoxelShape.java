package com.teampotato.redirectionor.mixin.minecraft.world.phys.shapes;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.AxisCycle;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = DiscreteVoxelShape.class, priority = 10)
public abstract class MixinDiscreteVoxelShape {
    @Shadow public abstract int getSize(Direction.Axis p_82851_);

    @Shadow public abstract boolean isFull(AxisCycle p_82836_, int p_82837_, int p_82838_, int p_82839_);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void forAllAxisFaces(DiscreteVoxelShape.IntFaceConsumer p_82813_, AxisCycle p_82814_) {
        AxisCycle axiscycle = p_82814_.inverse();
        Direction.Axis direction$axis = axiscycle.cycle(Redirectionor.Z);
        int k = this.getSize(direction$axis);
        Direction direction = Direction.fromAxisAndDirection(direction$axis, Redirectionor.NEGATIVE);
        Direction direction1 = Direction.fromAxisAndDirection(direction$axis, Redirectionor.POSITIVE);

        for(int l = 0; l < this.getSize(axiscycle.cycle(Redirectionor.X)); ++l) {
            for(int i1 = 0; i1 < this.getSize(axiscycle.cycle(Redirectionor.Y)); ++i1) {
                boolean flag = false;

                for(int j1 = 0; j1 <= k; ++j1) {
                    boolean flag1 = j1 != k && this.isFull(axiscycle, l, i1, j1);
                    if (!flag && flag1) {
                        p_82813_.consume(direction, axiscycle.cycle(l, i1, j1, Redirectionor.X), axiscycle.cycle(l, i1, j1, Redirectionor.Y), axiscycle.cycle(l, i1, j1, Redirectionor.Z));
                    }

                    if (flag && !flag1) {
                        p_82813_.consume(direction1, axiscycle.cycle(l, i1, j1 - 1, Redirectionor.X), axiscycle.cycle(l, i1, j1 - 1, Redirectionor.Y), axiscycle.cycle(l, i1, j1 - 1, Redirectionor.Z));
                    }

                    flag = flag1;
                }
            }
        }

    }
}
