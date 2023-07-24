package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TripWireBlock;
import net.minecraft.world.level.block.TripWireHookBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.*;

@Mixin(value = TripWireBlock.class, priority = 10)
public abstract class MixinTripWireBlock {
    @Shadow @Final private TripWireHookBlock hook;

    @Unique private static Direction[] redirectionor$directions = new Direction[]{Redirectionor.SOUTH, Redirectionor.WEST};
    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void updateSource(Level pLevel, BlockPos pPos, BlockState pState) {
        for(Direction direction : redirectionor$directions) {
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
