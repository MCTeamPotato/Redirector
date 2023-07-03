package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BellBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BellAttachType;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BellBlock.class)
public abstract class MixinBellBlock {
    @Shadow @Final public static DirectionProperty FACING;
    @Shadow @Final public static EnumProperty<BellAttachType> ATTACHMENT;
    @Shadow @Final private static VoxelShape EAST_WEST_FLOOR_SHAPE;
    @Shadow @Final private static VoxelShape NORTH_SOUTH_FLOOR_SHAPE;
    @Shadow @Final private static VoxelShape NORTH_SOUTH_BETWEEN;
    @Shadow @Final private static VoxelShape EAST_WEST_BETWEEN;
    @Shadow @Final private static VoxelShape CEILING_SHAPE;
    @Shadow @Final private static VoxelShape TO_NORTH;
    @Shadow @Final private static VoxelShape TO_SOUTH;
    @Shadow @Final private static VoxelShape TO_EAST;
    @Shadow @Final private static VoxelShape TO_WEST;

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private VoxelShape getVoxelShape(BlockState pState) {
        Direction direction = pState.getValue(FACING);
        BellAttachType bellattachtype = pState.getValue(ATTACHMENT);
        if (bellattachtype == Redirectionor.FLOOR_TYPE) {
            return direction != Redirectionor.NORTH && direction != Redirectionor.SOUTH ? EAST_WEST_FLOOR_SHAPE : NORTH_SOUTH_FLOOR_SHAPE;
        } else if (bellattachtype == Redirectionor.CEILING_TYPE) {
            return CEILING_SHAPE;
        } else if (bellattachtype == Redirectionor.DOUBLE_WALL_TYPE) {
            return direction != Redirectionor.NORTH && direction != Redirectionor.SOUTH ? EAST_WEST_BETWEEN : NORTH_SOUTH_BETWEEN;
        } else if (direction == Redirectionor.NORTH) {
            return TO_NORTH;
        } else if (direction == Redirectionor.SOUTH) {
            return TO_SOUTH;
        } else {
            return direction == Redirectionor.EAST ? TO_EAST : TO_WEST;
        }
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static Direction getConnectedDirection(BlockState pState) {
        return switch (pState.getValue(ATTACHMENT)) {
            case FLOOR -> Redirectionor.UP;
            case CEILING -> Redirectionor.DOWN;
            default -> pState.getValue(FACING).getOpposite();
        };
    }
}
