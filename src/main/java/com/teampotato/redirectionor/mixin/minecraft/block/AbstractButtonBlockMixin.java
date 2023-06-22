package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = AbstractButtonBlock.class, priority = 10)
public abstract class AbstractButtonBlockMixin extends HorizontalFaceBlock {
    @Shadow @Final public static BooleanProperty POWERED;
    @Shadow @Final protected static VoxelShape PRESSED_FLOOR_AABB_X;
    @Shadow @Final protected static VoxelShape FLOOR_AABB_X;
    @Shadow @Final protected static VoxelShape FLOOR_AABB_Z;
    @Shadow @Final protected static VoxelShape PRESSED_FLOOR_AABB_Z;
    @Shadow @Final protected static VoxelShape PRESSED_EAST_AABB;
    @Shadow @Final protected static VoxelShape EAST_AABB;
    @Shadow @Final protected static VoxelShape WEST_AABB;
    @Shadow @Final protected static VoxelShape SOUTH_AABB;
    @Shadow @Final protected static VoxelShape NORTH_AABB;
    @Shadow @Final protected static VoxelShape PRESSED_NORTH_AABB;
    @Shadow @Final protected static VoxelShape PRESSED_SOUTH_AABB;
    @Shadow @Final protected static VoxelShape PRESSED_WEST_AABB;
    @Shadow @Final protected static VoxelShape PRESSED_CEILING_AABB_X;
    @Shadow @Final protected static VoxelShape PRESSED_CEILING_AABB_Z;
    @Shadow @Final protected static VoxelShape CEILING_AABB_Z;
    @Shadow @Final protected static VoxelShape CEILING_AABB_X;

    public AbstractButtonBlockMixin(Properties p_i48402_1_) {
        super(p_i48402_1_);
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        Direction direction = pState.getValue(FACING);
        boolean flag = pState.getValue(POWERED);
        switch(pState.getValue(FACE)) {
            case FLOOR:
                if (direction.getAxis() == Redirectionor.X) {
                    return flag ? PRESSED_FLOOR_AABB_X : FLOOR_AABB_X;
                }

                return flag ? PRESSED_FLOOR_AABB_Z : FLOOR_AABB_Z;
            case WALL:
                switch(direction) {
                    case EAST:
                        return flag ? PRESSED_EAST_AABB : EAST_AABB;
                    case WEST:
                        return flag ? PRESSED_WEST_AABB : WEST_AABB;
                    case SOUTH:
                        return flag ? PRESSED_SOUTH_AABB : SOUTH_AABB;
                    case NORTH:
                    default:
                        return flag ? PRESSED_NORTH_AABB : NORTH_AABB;
                }
            case CEILING:
            default:
                if (direction.getAxis() == Redirectionor.X) {
                    return flag ? PRESSED_CEILING_AABB_X : CEILING_AABB_X;
                } else {
                    return flag ? PRESSED_CEILING_AABB_Z : CEILING_AABB_Z;
                }
        }
    }
}
