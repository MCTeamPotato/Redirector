package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.GrindstoneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GrindstoneBlock.class)
public abstract class MixinGrindstoneBlock extends FaceAttachedHorizontalDirectionalBlock {
    @Shadow @Final public static VoxelShape FLOOR_EAST_WEST_GRINDSTONE;

    @Shadow @Final public static VoxelShape FLOOR_NORTH_SOUTH_GRINDSTONE;

    @Shadow @Final public static VoxelShape WALL_NORTH_GRINDSTONE;

    @Shadow @Final public static VoxelShape WALL_SOUTH_GRINDSTONE;

    @Shadow @Final public static VoxelShape WALL_EAST_GRINDSTONE;

    @Shadow @Final public static VoxelShape WALL_WEST_GRINDSTONE;

    @Shadow @Final public static VoxelShape CEILING_EAST_WEST_GRINDSTONE;

    @Shadow @Final public static VoxelShape CEILING_NORTH_SOUTH_GRINDSTONE;

    public MixinGrindstoneBlock(Properties pProperties) {
        super(pProperties);
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private VoxelShape getVoxelShape(BlockState pState) {
        Direction direction = pState.getValue(FACING);
        switch (pState.getValue(FACE)) {
            case FLOOR -> {
                if (direction != Redirectionor.NORTH && direction != Redirectionor.SOUTH) return FLOOR_EAST_WEST_GRINDSTONE;
                return FLOOR_NORTH_SOUTH_GRINDSTONE;
            }
            case WALL -> {
                if (direction == Redirectionor.NORTH) {
                    return WALL_NORTH_GRINDSTONE;
                } else if (direction == Redirectionor.SOUTH) {
                    return WALL_SOUTH_GRINDSTONE;
                } else {
                    if (direction == Redirectionor.EAST) return WALL_EAST_GRINDSTONE;
                    return WALL_WEST_GRINDSTONE;
                }
            }
            case CEILING -> {
                if (direction != Redirectionor.NORTH && direction != Redirectionor.SOUTH) return CEILING_EAST_WEST_GRINDSTONE;
                return CEILING_NORTH_SOUTH_GRINDSTONE;
            }
            default -> {
                return FLOOR_EAST_WEST_GRINDSTONE;
            }
        }
    }
}
