package com.teampotato.redirectionor.references;

import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import net.minecraft.core.Direction;

import java.util.Map;

public final class DirectionReferences {
    public static final Direction[] DIRECTIONS = Direction.values();
    public static final Direction EAST = Direction.EAST;
    public static final Direction SOUTH = Direction.SOUTH;
    public static final Direction NORTH = Direction.NORTH;
    public static final Direction WEST = Direction.WEST;
    public static final Direction UP = Direction.UP;
    public static final Direction DOWN = Direction.DOWN;

    public static final class AxisReferences {
        public static final Direction.Axis X = Direction.Axis.X;
        public static final Direction.Axis Y = Direction.Axis.Y;
        public static final Direction.Axis Z = Direction.Axis.Z;
    }

    public static final class OrdinalReferences {
        public static final int WEST_ORDINAL = WEST.ordinal();
        public static final int NORTH_ORDINAL = NORTH.ordinal();
        public static final int EAST_ORDINAL = EAST.ordinal();
        public static final int SOUTH_ORDINAL = SOUTH.ordinal();
        public static final int UP_ORDINAL = UP.ordinal();
        public static final int DOWN_ORDINAL = DOWN.ordinal();

        public static final Map<Direction, Integer> ORDINAL_MAP = new Object2IntLinkedOpenHashMap<>();

        static {
            ORDINAL_MAP.put(EAST, EAST_ORDINAL);
            ORDINAL_MAP.put(SOUTH, SOUTH_ORDINAL);
            ORDINAL_MAP.put(NORTH, NORTH_ORDINAL);
            ORDINAL_MAP.put(WEST, WEST_ORDINAL);
            ORDINAL_MAP.put(UP, UP_ORDINAL);
            ORDINAL_MAP.put(DOWN, DOWN_ORDINAL);
        }
    }
    public static final class PlaneReferences {
        public static final Direction.Plane HORIZONTAL = Direction.Plane.HORIZONTAL;
        public static final Direction.Plane VERTICAL = Direction.Plane.VERTICAL;
    }

    public static final class DataValueReferences {
        public static final int EAST_3D_DATA_VALUE = EAST.get3DDataValue();
        public static final int SOUTH_3D_DATA_VALUE = SOUTH.get3DDataValue();
        public static final int NORTH_3D_DATA_VALUE = NORTH.get3DDataValue();
        public static final int WEST_3D_DATA_VALUE = WEST.get3DDataValue();
        public static final int UP_3D_DATA_VALUE = UP.get3DDataValue();
        public static final int DOWN_3D_DATA_VALUE = DOWN.get3DDataValue();

        public static final Map<Direction, Integer> DATA_VALUE_MAP = new Object2IntLinkedOpenHashMap<>();

        static {
            DATA_VALUE_MAP.put(EAST, EAST_3D_DATA_VALUE);
            DATA_VALUE_MAP.put(SOUTH, SOUTH_3D_DATA_VALUE);
            DATA_VALUE_MAP.put(NORTH, NORTH_3D_DATA_VALUE);
            DATA_VALUE_MAP.put(WEST, WEST_3D_DATA_VALUE);
            DATA_VALUE_MAP.put(UP, UP_3D_DATA_VALUE);
            DATA_VALUE_MAP.put(DOWN, DOWN_3D_DATA_VALUE);
        }
    }

    public static final class AxisDirectionReferences {
        public static final Direction.AxisDirection POSITIVE = Direction.AxisDirection.POSITIVE;
        public static final Direction.AxisDirection NEGATIVE = Direction.AxisDirection.NEGATIVE;
    }
}
