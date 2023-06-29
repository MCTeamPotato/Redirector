package com.teampotato.redirectionor;

import net.minecraft.core.Direction;
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
}
