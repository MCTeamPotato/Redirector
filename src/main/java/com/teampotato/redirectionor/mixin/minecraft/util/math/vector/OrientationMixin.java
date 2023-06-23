package com.teampotato.redirectionor.mixin.minecraft.util.math.vector;

import com.google.common.collect.Maps;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.util.TriplePermutation;
import net.minecraft.util.math.vector.Orientation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;
import java.util.Map;

@Mixin(value = Orientation.class, priority = 10)
public abstract class OrientationMixin {
    @Shadow @Nullable private Map<Direction, Direction> rotatedDirections;
    @Shadow @Final private TriplePermutation permutation;
    @Shadow public abstract boolean inverts(Direction.Axis pAxis);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Direction rotate(Direction pDirection) {
        if (this.rotatedDirections == null) {
            this.rotatedDirections = Maps.newEnumMap(Direction.class);

            for(Direction direction : Redirectionor.DIRECTIONS) {
                Direction.AxisDirection direction$axisdirection = direction.getAxisDirection();
                Direction.Axis direction$axis1 = Redirectionor.AXISES[this.permutation.permutation(direction.getAxis().ordinal())];
                this.rotatedDirections.put(direction, Direction.fromAxisAndDirection(direction$axis1, this.inverts(direction$axis1) ? direction$axisdirection.opposite() : direction$axisdirection));
            }
        }

        return this.rotatedDirections.get(pDirection);
    }
}
