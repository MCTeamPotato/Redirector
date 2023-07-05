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

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;FLOOR:Lnet/minecraft/state/properties/BellAttachment;"))
    private BellAttachment implFloor() {
        return Redirectionor.FLOOR_TYPE;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;CEILING:Lnet/minecraft/state/properties/BellAttachment;"))
    private BellAttachment implCeiling() {
        return Redirectionor.CEILING_TYPE;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;DOUBLE_WALL:Lnet/minecraft/state/properties/BellAttachment;"))
    private BellAttachment implDoubleWall() {
        return Redirectionor.DOUBLE_WALL_TYPE;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
    private Direction implEast() {
        return Redirectionor.EAST;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "getVoxelShape", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }
}
