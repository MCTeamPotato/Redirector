package com.teampotato.redirectionor;

import net.minecraft.data.BlockModelFields;
import net.minecraft.state.properties.*;
import net.minecraft.util.AxisRotation;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraftforge.fml.common.Mod;

@Mod(Redirectionor.ID)
public class Redirectionor {
    public static final String ID = "redirectionor";

    public static final Direction[] DIRECTIONS = Direction.values();
    public static final Direction DOWN = Direction.DOWN;
    public static final Direction UP = Direction.UP;
    public static final Direction NORTH = Direction.NORTH;
    public static final Direction SOUTH = Direction.SOUTH;
    public static final Direction WEST = Direction.WEST;
    public static final Direction EAST = Direction.EAST;

    public static final int DOWN_3D_DATA_VALUE = DOWN.get3DDataValue();
    public static final int UP_3D_DATA_VALUE = UP.get3DDataValue();
    public static final int NORTH_3D_DATA_VALUE = NORTH.get3DDataValue();
    public static final int SOUTH_3D_DATA_VALUE = SOUTH.get3DDataValue();
    public static final int WEST_3D_DATA_VALUE = WEST.get3DDataValue();
    public static final int EAST_3D_DATA_VALUE = EAST.get3DDataValue();

    public static final int NORTH_ORDINAL = NORTH.ordinal();
    public static final int SOUTH_ORDINAL = SOUTH.ordinal();
    public static final int WEST_ORDINAL = WEST.ordinal();
    public static final int EAST_ORDINAL = EAST.ordinal();

    public static final BlockModelFields.Rotation R0 = BlockModelFields.Rotation.R0;
    public static final BlockModelFields.Rotation R90 = BlockModelFields.Rotation.R90;
    public static final BlockModelFields.Rotation R180 = BlockModelFields.Rotation.R180;
    public static final BlockModelFields.Rotation R270 = BlockModelFields.Rotation.R270;

    public static final Rotation NONE = Rotation.NONE;
    public static final Rotation CLOCKWISE_90 = Rotation.CLOCKWISE_90;
    public static final Rotation CLOCKWISE_180 = Rotation.CLOCKWISE_180;
    public static final Rotation COUNTERCLOCKWISE_90 = Rotation.COUNTERCLOCKWISE_90;

    public static final AxisRotation AXIS_NONE = AxisRotation.NONE;
    public static final AxisRotation AXIS_FORWARD = AxisRotation.FORWARD;
    public static final AxisRotation AXIS_BACKWARD = AxisRotation.BACKWARD;

    public static final Half TOP = Half.TOP;
    public static final Half BOTTOM = Half.BOTTOM;

    public static final StairsShape STRAIGHT = StairsShape.STRAIGHT;
    public static final StairsShape INNER_LEFT = StairsShape.INNER_LEFT;
    public static final StairsShape INNER_RIGHT = StairsShape.INNER_RIGHT;
    public static final StairsShape OUTER_LEFT = StairsShape.OUTER_LEFT;
    public static final StairsShape OUTER_RIGHT = StairsShape.OUTER_RIGHT;

    public static final DoorHingeSide LEFT = DoorHingeSide.LEFT;
    public static final DoorHingeSide RIGHT = DoorHingeSide.RIGHT;

    public static final Direction.AxisDirection POSITIVE = Direction.AxisDirection.POSITIVE;
    public static final Direction.AxisDirection NEGATIVE = Direction.AxisDirection.NEGATIVE;

    public static final Direction.Axis[] AXISES = Direction.Axis.values();
    public static final Direction.Axis X = Direction.Axis.X;
    public static final Direction.Axis Y = Direction.Axis.Y;
    public static final Direction.Axis Z = Direction.Axis.Z;

    public static final BellAttachment FLOOR_TYPE = BellAttachment.FLOOR;
    public static final BellAttachment CEILING_TYPE = BellAttachment.CEILING;
    public static final BellAttachment SINGLE_WALL_TYPE = BellAttachment.SINGLE_WALL;
    public static final BellAttachment DOUBLE_WALL_TYPE = BellAttachment.DOUBLE_WALL;

    public static final AttachFace FLOOR = AttachFace.FLOOR;
    public static final AttachFace WALL = AttachFace.WALL;
    public static final AttachFace CEILING = AttachFace.CEILING;
}