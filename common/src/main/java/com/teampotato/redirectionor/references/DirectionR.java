package com.teampotato.redirectionor.references;

import net.minecraft.core.Direction;

public class DirectionR {
    public static final Direction[] DIRECTIONS = Direction.values();
    public static final Direction EAST = Direction.EAST;
    public static final Direction SOUTH = Direction.SOUTH;
    public static final Direction NORTH = Direction.NORTH;
    public static final Direction WEST = Direction.WEST;
    public static final Direction UP = Direction.UP;
    public static final Direction DOWN = Direction.DOWN;

    public static class AxisR {
        public static final Direction.Axis X = Direction.Axis.X;
        public static final Direction.Axis Y = Direction.Axis.Y;
        public static final Direction.Axis Z = Direction.Axis.Z;
    }

    public static class OrdinalR {
        public static final int WEST_ORDINAL = WEST.ordinal();
        public static final int NORTH_ORDINAL = NORTH.ordinal();
        public static final int EAST_ORDINAL = EAST.ordinal();
        public static final int SOUTH_ORDINAL = SOUTH.ordinal();
    }

    public static class PlaneR {
        public static final Direction.Plane HORIZONTAL = Direction.Plane.HORIZONTAL;
        public static final Direction.Plane VERTICAL = Direction.Plane.VERTICAL;
    }

    public static class DataValueR {
        public static final int EAST_3D_DATA_VALUE = EAST.get3DDataValue();
        public static final int SOUTH_3D_DATA_VALUE = SOUTH.get3DDataValue();
        public static final int NORTH_3D_DATA_VALUE = NORTH.get3DDataValue();
        public static final int WEST_3D_DATA_VALUE = WEST.get3DDataValue();
        public static final int UP_3D_DATA_VALUE = UP.get3DDataValue();
        public static final int DOWN_3D_DATA_VALUE = DOWN.get3DDataValue();
    }

    public static class AxisDirectionR {
        public static final Direction.AxisDirection POSITIVE = Direction.AxisDirection.POSITIVE;
        public static final Direction.AxisDirection NEGATIVE = Direction.AxisDirection.NEGATIVE;
    }
}
