package com.teampotato.redirectionor.mixin.util;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Direction.class)
public abstract class DirectionMixin {

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public static Direction fromAxisAndDirection(Direction.Axis pAxis, Direction.AxisDirection pAxisDirection) {
        switch(pAxis) {
            case X:
                return pAxisDirection == Redirectionor.POSITIVE ? Redirectionor.EAST : Redirectionor.WEST;
            case Y:
                return pAxisDirection == Redirectionor.POSITIVE ? Redirectionor.UP : Redirectionor.DOWN;
            case Z:
            default:
                return pAxisDirection == Redirectionor.POSITIVE ? Redirectionor.SOUTH : Redirectionor.NORTH;
        }
    }
}
