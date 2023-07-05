package com.teampotato.redirectionor;

import net.minecraft.data.BlockModelFields;
import net.minecraft.state.properties.BellAttachment;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraftforge.fml.common.Mod;

@Mod(Redirectionor.ID)
public class Redirectionor {
    public static final String ID = "redirectionor";

    public static Direction[] DIRECTIONS = Direction.values();
    public static Direction DOWN = Direction.DOWN;
    public static Direction UP = Direction.UP;
    public static Direction NORTH = Direction.NORTH;
    public static Direction SOUTH = Direction.SOUTH;
    public static Direction WEST = Direction.WEST;
    public static Direction EAST = Direction.EAST;

    public static int DIRECTIONS_LENGTH = DIRECTIONS.length;

    public static int DOWN_3D_DATA_VALUE = DOWN.get3DDataValue();
    public static int UP_3D_DATA_VALUE = UP.get3DDataValue();
    public static int NORTH_3D_DATA_VALUE = NORTH.get3DDataValue();
    public static int SOUTH_3D_DATA_VALUE = SOUTH.get3DDataValue();
    public static int WEST_3D_DATA_VALUE = WEST.get3DDataValue();
    public static int EAST_3D_DATA_VALUE = EAST.get3DDataValue();

    public static int NORTH_ORDINAL = NORTH.ordinal();
    public static int SOUTH_ORDINAL = SOUTH.ordinal();
    public static int WEST_ORDINAL = WEST.ordinal();
    public static int EAST_ORDINAL = EAST.ordinal();

    public static BlockModelFields.Rotation R0 = BlockModelFields.Rotation.R0;
    public static BlockModelFields.Rotation R90 = BlockModelFields.Rotation.R90;
    public static BlockModelFields.Rotation R180 = BlockModelFields.Rotation.R180;
    public static BlockModelFields.Rotation R270 = BlockModelFields.Rotation.R270;

    public static Half TOP = Half.TOP;
    public static Half BOTTOM = Half.BOTTOM;

    public static StairsShape STRAIGHT = StairsShape.STRAIGHT;
    public static StairsShape INNER_LEFT = StairsShape.INNER_LEFT;
    public static StairsShape INNER_RIGHT = StairsShape.INNER_RIGHT;
    public static StairsShape OUTER_LEFT = StairsShape.OUTER_LEFT;
    public static StairsShape OUTER_RIGHT = StairsShape.OUTER_RIGHT;

    public static DoorHingeSide LEFT = DoorHingeSide.LEFT;
    public static DoorHingeSide RIGHT = DoorHingeSide.RIGHT;

    public static Direction.AxisDirection POSITIVE = Direction.AxisDirection.POSITIVE;
    public static Direction.AxisDirection NEGATIVE = Direction.AxisDirection.NEGATIVE;

    //TODO: incomplete
    public static Direction.Axis[] AXISES = Direction.Axis.values();
    public static Direction.Axis X = Direction.Axis.X;
    public static Direction.Axis Y = Direction.Axis.Y;
    public static Direction.Axis Z = Direction.Axis.Z;

    public static BellAttachment FLOOR_TYPE = BellAttachment.FLOOR;
    public static BellAttachment CEILING_TYPE = BellAttachment.CEILING;
    public static BellAttachment DOUBLE_WALL_TYPE = BellAttachment.DOUBLE_WALL;
}