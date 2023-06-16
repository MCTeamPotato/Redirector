package com.teampotato.directionoptimizer;

import net.minecraft.util.Direction;
import net.minecraftforge.fml.common.Mod;

@Mod(DirectionOptimizer.ID)
public class DirectionOptimizer {
    public static final String ID = "directionoptimizer";

    public static final Direction[] DIRECTIONS = Direction.values();
    public static final Direction DOWN = Direction.DOWN;
    public static final Direction UP = Direction.UP;
    public static final Direction NORTH = Direction.NORTH;
    public static final Direction SOUTH = Direction.SOUTH;
    public static final Direction WEST = Direction.WEST;
    public static final Direction EAST = Direction.EAST;
}