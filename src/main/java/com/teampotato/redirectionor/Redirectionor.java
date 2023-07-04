package com.teampotato.redirectionor;

import net.minecraft.core.Direction;
import net.minecraft.core.Direction8;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraftforge.fml.common.Mod;

@Mod(Redirectionor.ID)
public class Redirectionor {
    public static final String ID = "redirectionor";

    public static Direction[] DIRECTIONS = Direction.values();

    public static Direction EAST = Direction.EAST;
    public static Direction SOUTH = Direction.SOUTH;
    public static Direction NORTH = Direction.NORTH;
    public static Direction WEST = Direction.WEST;
    public static Direction UP = Direction.UP;
    public static Direction DOWN = Direction.DOWN;

    public static Direction.AxisDirection UP_AXIS_DIRECTION = UP.getAxisDirection();

    public static int EAST_3D_DATA_VALUE = EAST.get3DDataValue();
    public static int SOUTH_3D_DATA_VALUE = SOUTH.get3DDataValue();
    public static int NORTH_3D_DATA_VALUE = NORTH.get3DDataValue();
    public static int WEST_3D_DATA_VALUE = WEST.get3DDataValue();
    public static int UP_3D_DATA_VALUE = UP.get3DDataValue();
    public static int DOWN_3D_DATA_VALUE = DOWN.get3DDataValue();

    public static int WEST_ORDINAL = WEST.ordinal();
    public static int NORTH_ORDINAL = NORTH.ordinal();
    public static int EAST_ORDINAL = EAST.ordinal();
    public static int SOUTH_ORDINAL = SOUTH.ordinal();

    public static Direction.Axis X = Direction.Axis.X;
    public static Direction.Axis Y = Direction.Axis.Y;
    public static Direction.Axis Z = Direction.Axis.Z;

    public static Direction.Plane HORIZONTAL = Direction.Plane.HORIZONTAL;
    public static Direction.Plane VERTICAL = Direction.Plane.VERTICAL;

    public static VariantProperties.Rotation R0 = VariantProperties.Rotation.R0;
    public static VariantProperties.Rotation R90 = VariantProperties.Rotation.R90;
    public static VariantProperties.Rotation R180 = VariantProperties.Rotation.R180;
    public static VariantProperties.Rotation R270 = VariantProperties.Rotation.R270;

    public static AttachFace FLOOR_FACE = AttachFace.FLOOR;
    public static AttachFace WALL_FACE = AttachFace.WALL;
    public static AttachFace CEILING_FACE = AttachFace.CEILING;

    public static DoorHingeSide LEFT = DoorHingeSide.LEFT;
    public static DoorHingeSide RIGHT = DoorHingeSide.RIGHT;

    public static Half TOP = Half.TOP;
    public static Half BOTTOM = Half.BOTTOM;

    public static StairsShape STRAIGHT = StairsShape.STRAIGHT;
    public static StairsShape INNER_LEFT = StairsShape.INNER_LEFT;
    public static StairsShape INNER_RIGHT = StairsShape.INNER_RIGHT;
    public static StairsShape OUTER_LEFT = StairsShape.OUTER_LEFT;
    public static StairsShape OUTER_RIGHT = StairsShape.OUTER_RIGHT;

    public static BellAttachType FLOOR_TYPE = BellAttachType.FLOOR;
    public static BellAttachType CEILING_TYPE = BellAttachType.CEILING;
    public static BellAttachType SINGLE_WALL_TYPE = BellAttachType.SINGLE_WALL;
    public static BellAttachType DOUBLE_WALL_TYPE = BellAttachType.DOUBLE_WALL;

    public static Direction.AxisDirection POSITIVE = Direction.AxisDirection.POSITIVE;
    public static Direction.AxisDirection NEGATIVE = Direction.AxisDirection.NEGATIVE;

    public static Rotation COUNTERCLOCKWISE_90 = Rotation.COUNTERCLOCKWISE_90;
    public static Rotation CLOCKWISE_180 = Rotation.CLOCKWISE_180;
    public static Rotation CLOCKWISE_90 = Rotation.CLOCKWISE_90;

    public static RenderShape INVISIBLE = RenderShape.INVISIBLE;
    public static RenderShape ENTITYBLOCK_ANIMATED = RenderShape.ENTITYBLOCK_ANIMATED;
    public static RenderShape MODEL = RenderShape.MODEL;

    public static BedPart BED_HEAD = BedPart.HEAD;

    public static Direction8 _8_NORTH = Direction8.NORTH;
    public static Direction8 NORTH_EAST = Direction8.NORTH_EAST;
    public static Direction8 _8_EAST = Direction8.EAST;
    public static Direction8 SOUTH_EAST = Direction8.SOUTH_EAST;
    public static Direction8 _8_SOUTH = Direction8.SOUTH;
    public static Direction8 _8_WEST =  Direction8.WEST;
    public static Direction8 NORTH_WEST = Direction8.NORTH_WEST;
}