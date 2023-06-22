package com.teampotato.redirectionor.mixin.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrindstoneBlock;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = GrindstoneBlock.class, priority = 10)
public abstract class GrindstoneBlockMixin extends HorizontalFaceBlock {
    @Shadow @Final public static VoxelShape FLOOR_EAST_WEST_GRINDSTONE;
    @Shadow @Final public static VoxelShape FLOOR_NORTH_SOUTH_GRINDSTONE;
    @Shadow @Final public static VoxelShape WALL_NORTH_GRINDSTONE;
    @Shadow @Final public static VoxelShape WALL_SOUTH_GRINDSTONE;
    @Shadow @Final public static VoxelShape WALL_EAST_GRINDSTONE;
    @Shadow @Final public static VoxelShape WALL_WEST_GRINDSTONE;
    @Shadow @Final public static VoxelShape CEILING_EAST_WEST_GRINDSTONE;
    @Shadow @Final public static VoxelShape CEILING_NORTH_SOUTH_GRINDSTONE;

    public GrindstoneBlockMixin(Properties p_i48402_1_) {
        super(p_i48402_1_);
    }

    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private VoxelShape getVoxelShape(BlockState pState) {
        Direction direction = pState.getValue(FACING);
        switch(pState.getValue(FACE)) {
            case FLOOR:
                if (direction != Redirectionor.NORTH && direction != Redirectionor.SOUTH) return FLOOR_EAST_WEST_GRINDSTONE;
                return FLOOR_NORTH_SOUTH_GRINDSTONE;
            case WALL:
                if (direction == Redirectionor.NORTH) {
                    return WALL_NORTH_GRINDSTONE;
                } else if (direction == Redirectionor.SOUTH) {
                    return WALL_SOUTH_GRINDSTONE;
                } else {
                    if (direction == Redirectionor.EAST) return WALL_EAST_GRINDSTONE;
                    return WALL_WEST_GRINDSTONE;
                }
            case CEILING:
                if (direction != Redirectionor.NORTH && direction != Redirectionor.SOUTH) return CEILING_EAST_WEST_GRINDSTONE;
                return CEILING_NORTH_SOUTH_GRINDSTONE;
            default:
                return FLOOR_EAST_WEST_GRINDSTONE;
        }
    }
}
