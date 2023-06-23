package com.teampotato.redirectionor.mixin.minecraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.TripWireBlock;
import net.minecraft.block.TripWireHookBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = TripWireBlock.class, priority = 10)
public abstract class TripWireBlockMixin {
    @Shadow @Final private TripWireHookBlock hook;
    private static final Direction[] DIRECTIONS = new Direction[]{Direction.SOUTH, Direction.WEST};

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void updateSource(World pLevel, BlockPos pPos, BlockState pState) {
        for(Direction direction : DIRECTIONS) {
            for(int i = 1; i < 42; ++i) {
                BlockPos blockpos = pPos.relative(direction, i);
                BlockState blockstate = pLevel.getBlockState(blockpos);
                if (blockstate.is(this.hook)) {
                    if (blockstate.getValue(TripWireHookBlock.FACING) == direction.getOpposite()) this.hook.calculateState(pLevel, blockpos, blockstate, false, true, i, pState);
                    break;
                }
                if (!blockstate.is((TripWireBlock)(Object)this)) break;
            }
        }
    }
}
