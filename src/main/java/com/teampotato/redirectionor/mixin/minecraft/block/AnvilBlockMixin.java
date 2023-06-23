package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = AnvilBlock.class, priority = 10)
public abstract class AnvilBlockMixin {
    @Shadow @Final public static DirectionProperty FACING;
    @Shadow @Final private static VoxelShape X_AXIS_AABB;
    @Shadow @Final private static VoxelShape Z_AXIS_AABB;

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        Direction direction = p_220053_1_.getValue(FACING);
        return direction.getAxis() == Redirectionor.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }
}
