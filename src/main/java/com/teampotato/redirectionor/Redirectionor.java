package com.teampotato.redirectionor;

import net.minecraft.core.Direction;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraftforge.fml.common.Mod;

@Mod(Redirectionor.ID)
public class Redirectionor {
    public static final String ID = "redirectionor";

    public static final Direction[] DIRECTIONS = Direction.values();

    public static final Direction EAST = Direction.EAST;
    public static final Direction SOUTH = Direction.SOUTH;
    public static final Direction NORTH = Direction.NORTH;
    public static final Direction WEST = Direction.WEST;
    public static final Direction UP = Direction.UP;
    public static final Direction DOWN = Direction.DOWN;

    public static final int EAST_3D_DATA_VALUE = EAST.get3DDataValue();
    public static final int SOUTH_3D_DATA_VALUE = SOUTH.get3DDataValue();
    public static final int NORTH_3D_DATA_VALUE = NORTH.get3DDataValue();
    public static final int WEST_3D_DATA_VALUE = WEST.get3DDataValue();
    public static final int UP_3D_DATA_VALUE = UP.get3DDataValue();
    public static final int DOWN_3D_DATA_VALUE = DOWN.get3DDataValue();

    public static final int WEST_ORDINAL = WEST.ordinal();
    public static final int NORTH_ORDINAL = NORTH.ordinal();
    public static final int EAST_ORDINAL = EAST.ordinal();
    public static final int SOUTH_ORDINAL = SOUTH.ordinal();

    public static final Direction.Axis X = Direction.Axis.X;
    public static final Direction.Axis Y = Direction.Axis.Y;
    public static final Direction.Axis Z = Direction.Axis.Z;

    public static final Direction.Plane HORIZONTAL = Direction.Plane.HORIZONTAL;
    public static final Direction.Plane VERTICAL = Direction.Plane.VERTICAL;

    public static final VariantProperties.Rotation R0 = VariantProperties.Rotation.R0;
    public static final VariantProperties.Rotation R90 = VariantProperties.Rotation.R90;
    public static final VariantProperties.Rotation R180 = VariantProperties.Rotation.R180;
    public static final VariantProperties.Rotation R270 = VariantProperties.Rotation.R270;

    public static final AttachFace FLOOR_FACE = AttachFace.FLOOR;
    public static final AttachFace WALL_FACE = AttachFace.WALL;
    public static final AttachFace CEILING_FACE = AttachFace.CEILING;

    public static final DoorHingeSide LEFT = DoorHingeSide.LEFT;
    public static final DoorHingeSide RIGHT = DoorHingeSide.RIGHT;

    public static final Half TOP = Half.TOP;
    public static final Half BOTTOM = Half.BOTTOM;

    public static final StairsShape STRAIGHT = StairsShape.STRAIGHT;
    public static final StairsShape INNER_LEFT = StairsShape.INNER_LEFT;
    public static final StairsShape INNER_RIGHT = StairsShape.INNER_RIGHT;
    public static final StairsShape OUTER_LEFT = StairsShape.OUTER_LEFT;
    public static final StairsShape OUTER_RIGHT = StairsShape.OUTER_RIGHT;

    public static final BellAttachType FLOOR_TYPE = BellAttachType.FLOOR;
    public static final BellAttachType CEILING_TYPE = BellAttachType.CEILING;
    public static final BellAttachType SINGLE_WALL_TYPE = BellAttachType.SINGLE_WALL;
    public static final BellAttachType DOUBLE_WALL_TYPE = BellAttachType.DOUBLE_WALL;

    public static final Direction.AxisDirection POSITIVE = Direction.AxisDirection.POSITIVE;
    public static final Direction.AxisDirection NEGATIVE = Direction.AxisDirection.NEGATIVE;
}
