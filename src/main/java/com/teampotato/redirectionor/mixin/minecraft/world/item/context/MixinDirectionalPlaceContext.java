package com.teampotato.redirectionor.mixin.minecraft.world.item.context;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.DirectionalPlaceContext;
import org.spongepowered.asm.mixin.*;

@Mixin(DirectionalPlaceContext.class)
public abstract class MixinDirectionalPlaceContext {
    @Shadow @Final private Direction direction;

    @Unique private static final Direction[] DEFAULT_RETURN = new Direction[]{Redirectionor.DOWN, Redirectionor.NORTH, Redirectionor.EAST, Redirectionor.SOUTH, Redirectionor.WEST, Redirectionor.UP};
    @Unique private static final Direction[] UP_RETURN = new Direction[]{   Redirectionor.DOWN, Redirectionor.UP,    Redirectionor.NORTH, Redirectionor.EAST, Redirectionor.SOUTH, Redirectionor.WEST};
    @Unique private static final Direction[] NORTH_RETURN = new Direction[]{Redirectionor.DOWN, Redirectionor.NORTH, Redirectionor.EAST,  Redirectionor.WEST, Redirectionor.UP,    Redirectionor.SOUTH};
    @Unique private static final Direction[] SOUTH_RETURN = new Direction[]{Redirectionor.DOWN, Redirectionor.SOUTH, Redirectionor.EAST,  Redirectionor.WEST, Redirectionor.UP,    Redirectionor.NORTH};
    @Unique private static final Direction[] WEST_RETURN = new Direction[]{ Redirectionor.DOWN, Redirectionor.WEST,  Redirectionor.SOUTH, Redirectionor.UP,   Redirectionor.NORTH, Redirectionor.EAST};
    @Unique private static final Direction[] EAST_RETURN = new Direction[]{ Redirectionor.DOWN, Redirectionor.EAST,  Redirectionor.SOUTH, Redirectionor.UP,   Redirectionor.NORTH, Redirectionor.WEST};

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Direction[] getNearestLookingDirections() {
        return switch (this.direction) {
            default -> DEFAULT_RETURN;
            case UP -> UP_RETURN;
            case NORTH -> NORTH_RETURN;
            case SOUTH -> SOUTH_RETURN;
            case WEST -> WEST_RETURN;
            case EAST -> EAST_RETURN;
        };
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Direction getHorizontalDirection() {
        return this.direction.getAxis() == Redirectionor.Y ? Redirectionor.NORTH : this.direction;
    }
}
