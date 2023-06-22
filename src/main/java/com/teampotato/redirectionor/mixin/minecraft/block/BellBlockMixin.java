package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.BellBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.BellAttachment;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = BellBlock.class, priority = 10)
public abstract class BellBlockMixin {
    @Shadow @Final public static DirectionProperty FACING;
    @Shadow @Final public static EnumProperty<BellAttachment> ATTACHMENT;
    @Shadow @Final private static VoxelShape EAST_WEST_FLOOR_SHAPE;
    @Shadow @Final private static VoxelShape NORTH_SOUTH_FLOOR_SHAPE;
    @Shadow @Final private static VoxelShape NORTH_SOUTH_BETWEEN;
    @Shadow @Final private static VoxelShape EAST_WEST_BETWEEN;
    @Shadow @Final private static VoxelShape CEILING_SHAPE;
    @Shadow @Final private static VoxelShape TO_NORTH;
    @Shadow @Final private static VoxelShape TO_SOUTH;
    @Shadow @Final private static VoxelShape TO_WEST;
    @Shadow @Final private static VoxelShape TO_EAST;

    @Redirect(method = "canSurvive", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown2() {
        return Redirectionor.DOWN;
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private VoxelShape getVoxelShape(BlockState pState) {
        Direction direction = pState.getValue(FACING);
        BellAttachment bellattachment = pState.getValue(ATTACHMENT);
        if (bellattachment == BellAttachment.FLOOR) {
            return direction != Redirectionor.NORTH && direction != Redirectionor.SOUTH ? EAST_WEST_FLOOR_SHAPE : NORTH_SOUTH_FLOOR_SHAPE;
        } else if (bellattachment == BellAttachment.CEILING) {
            return CEILING_SHAPE;
        } else if (bellattachment == BellAttachment.DOUBLE_WALL) {
            return direction != Redirectionor.NORTH && direction != Redirectionor.SOUTH ? EAST_WEST_BETWEEN : NORTH_SOUTH_BETWEEN;
        } else if (direction == Redirectionor.NORTH) {
            return TO_NORTH;
        } else if (direction == Redirectionor.SOUTH) {
            return TO_SOUTH;
        } else {
            return direction == Redirectionor.EAST ? TO_EAST : TO_WEST;
        }
    }
}
