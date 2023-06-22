package com.teampotato.redirectionor.mixin.item;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.item.DirectionalPlaceContext;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = DirectionalPlaceContext.class, priority = 10)
public abstract class DirectionalPlaceContextMixin {
    @Shadow @Final private Direction direction;

    @Unique private static final Direction[] DOWN_CASE = new Direction[]{Redirectionor.DOWN, Redirectionor.NORTH, Redirectionor.EAST, Redirectionor.SOUTH, Redirectionor.WEST, Redirectionor.UP};
    @Unique private static final Direction[] UP_CASE = new Direction[]{Redirectionor.DOWN, Redirectionor.UP, Redirectionor.NORTH, Redirectionor.EAST, Redirectionor.SOUTH, Redirectionor.WEST};
    @Unique private static final Direction[] NORTH_CASE = new Direction[]{Redirectionor.DOWN, Redirectionor.NORTH, Redirectionor.EAST, Redirectionor.WEST, Redirectionor.UP, Redirectionor.SOUTH};
    @Unique private static final Direction[] SOUTH_CASE = new Direction[]{Redirectionor.DOWN, Redirectionor.SOUTH, Redirectionor.EAST, Redirectionor.WEST, Redirectionor.UP, Redirectionor.NORTH};
    @Unique private static final Direction[] WEST_CASE = new Direction[]{Redirectionor.DOWN, Redirectionor.WEST, Redirectionor.SOUTH, Redirectionor.UP, Redirectionor.NORTH, Redirectionor.EAST};
    @Unique private static final Direction[] EAST_CASE = new Direction[]{Redirectionor.DOWN, Redirectionor.EAST, Redirectionor.SOUTH, Redirectionor.UP, Redirectionor.NORTH, Redirectionor.WEST};

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Direction[] getNearestLookingDirections() {
        switch(this.direction) {
            case DOWN:
            default:
                return DOWN_CASE;
            case UP:
                return UP_CASE;
            case NORTH:
                return NORTH_CASE;
            case SOUTH:
                return SOUTH_CASE;
            case WEST:
                return WEST_CASE;
            case EAST:
                return EAST_CASE;
        }
    }

    @Redirect(method = "getHorizontalDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }
}
