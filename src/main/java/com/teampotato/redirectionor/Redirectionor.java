package com.teampotato.redirectionor;

import net.minecraft.core.Direction;
import net.minecraft.core.Direction8;
import net.minecraft.core.FrontAndTop;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
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

    public static final Rotation COUNTERCLOCKWISE_90 = Rotation.COUNTERCLOCKWISE_90;
    public static final Rotation CLOCKWISE_180 = Rotation.CLOCKWISE_180;
    public static final Rotation CLOCKWISE_90 = Rotation.CLOCKWISE_90;

    public static final RenderShape INVISIBLE = RenderShape.INVISIBLE;
    public static final RenderShape ENTITYBLOCK_ANIMATED = RenderShape.ENTITYBLOCK_ANIMATED;
    public static final RenderShape MODEL = RenderShape.MODEL;

    public static final BedPart BED_HEAD = BedPart.HEAD;
    public static final BedPart BED_FOOT = BedPart.FOOT;

    public static final Direction8 _8_NORTH = Direction8.NORTH;
    public static final Direction8 NORTH_EAST = Direction8.NORTH_EAST;
    public static final Direction8 _8_EAST = Direction8.EAST;
    public static final Direction8 SOUTH_EAST = Direction8.SOUTH_EAST;
    public static final Direction8 _8_SOUTH = Direction8.SOUTH;
    public static final Direction8 SOUTH_WEST = Direction8.SOUTH_WEST;
    public static final Direction8 _8_WEST =  Direction8.WEST;
    public static final Direction8 NORTH_WEST = Direction8.NORTH_WEST;

    public static final FrontAndTop DOWN_EAST = FrontAndTop.DOWN_EAST;
    public static final FrontAndTop DOWN_NORTH = FrontAndTop.DOWN_NORTH;
    public static final FrontAndTop DOWN_SOUTH = FrontAndTop.DOWN_SOUTH;
    public static final FrontAndTop DOWN_WEST = FrontAndTop.DOWN_WEST;
    public static final FrontAndTop UP_EAST = FrontAndTop.UP_EAST;
    public static final FrontAndTop UP_NORTH = FrontAndTop.UP_NORTH;
    public static final FrontAndTop UP_SOUTH = FrontAndTop.UP_SOUTH;
    public static final FrontAndTop UP_WEST = FrontAndTop.UP_WEST;
    public static final FrontAndTop WEST_UP = FrontAndTop.WEST_UP;
    public static final FrontAndTop EAST_UP = FrontAndTop.EAST_UP;
    public static final FrontAndTop NORTH_UP = FrontAndTop.NORTH_UP;
    public static final FrontAndTop SOUTH_UP = FrontAndTop.SOUTH_UP;
}