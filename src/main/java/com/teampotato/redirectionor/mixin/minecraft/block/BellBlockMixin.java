package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.BellBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.BellAttachment;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import javax.annotation.Nullable;

@Mixin(value = BellBlock.class, priority = 10)
public abstract class BellBlockMixin extends ContainerBlock {
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

    protected BellBlockMixin(Properties p_i48446_1_) {
        super(p_i48446_1_);
    }

    @Redirect(method = "getConnectedDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDown3() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "getConnectedDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private static Direction implUp() {
        return Redirectionor.UP;
    }
    @Redirect(method = "canSurvive", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown2() {
        return Redirectionor.DOWN;
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        Direction direction = p_196258_1_.getClickedFace();
        BlockPos blockpos = p_196258_1_.getClickedPos();
        World world = p_196258_1_.getLevel();
        Direction.Axis direction$axis = direction.getAxis();
        if (direction$axis == Redirectionor.Y) {
            BlockState blockstate = this.defaultBlockState().setValue(ATTACHMENT, direction == Redirectionor.DOWN ? BellAttachment.CEILING : BellAttachment.FLOOR)
                    .setValue(FACING, p_196258_1_.getHorizontalDirection());
            if (blockstate.canSurvive(p_196258_1_.getLevel(), blockpos)) return blockstate;
        } else {
            BlockState blockstate1 = this.defaultBlockState().setValue(FACING, direction.getOpposite())
                    .setValue(ATTACHMENT, (direction$axis == Redirectionor.X &&
                            world.getBlockState(blockpos.west()).isFaceSturdy(world, blockpos.west(), Redirectionor.EAST) &&
                            world.getBlockState(blockpos.east()).isFaceSturdy(world, blockpos.east(), Redirectionor.WEST) ||
                            direction$axis == Redirectionor.Z && world.getBlockState(blockpos.north()).isFaceSturdy(world, blockpos.north(), Redirectionor.SOUTH) &&
                                    world.getBlockState(blockpos.south()).isFaceSturdy(world, blockpos.south(), Redirectionor.NORTH)) ? BellAttachment.DOUBLE_WALL : BellAttachment.SINGLE_WALL);
            if (blockstate1.canSurvive(p_196258_1_.getLevel(), p_196258_1_.getClickedPos())) return blockstate1;

            blockstate1 = blockstate1.setValue(ATTACHMENT, world.getBlockState(blockpos.below()).isFaceSturdy(world, blockpos.below(), Redirectionor.UP) ? BellAttachment.FLOOR : BellAttachment.CEILING);
            if (blockstate1.canSurvive(p_196258_1_.getLevel(), p_196258_1_.getClickedPos())) return blockstate1;
        }

        return null;
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
