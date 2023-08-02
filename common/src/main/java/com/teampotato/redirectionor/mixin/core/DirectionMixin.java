package com.teampotato.redirectionor.mixin.core;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

public class DirectionMixin {
    @Mixin(Direction.Axis.class)
    public abstract static class AxisMixin {
        /**
         * @author Kasualix
         * @reason use faster impl
         */
        @Overwrite
        @SuppressWarnings("DataFlowIssue")
        public Direction.Plane getPlane() {
            return DirectionReferences.PlaneReferences.PLANE_MAP.get((Direction.Axis) (Object) this);
        }
    }
}
