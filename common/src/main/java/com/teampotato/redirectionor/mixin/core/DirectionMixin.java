package com.teampotato.redirectionor.mixin.core;

import com.teampotato.redirectionor.common.Maps;
import com.teampotato.redirectionor.common.Values;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public abstract class DirectionMixin {
    @Mixin(Direction.class)
    public abstract static class MainMixin {
        @Redirect(method = "allShuffled", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
        private static Direction[] redirectDirection () {
            return Values.DIRECTIONS;
        }
    }

    @Mixin(Direction.Axis.class)
    public abstract static class AxisMixin {
        /**
         * @author Kasualix
         * @reason use faster impl
         */
        @Overwrite
        @SuppressWarnings("DataFlowIssue")
        public Direction.Plane getPlane() {
            return Maps.PLANE_MAP.get((Direction.Axis) (Object) this);
        }
    }
}
