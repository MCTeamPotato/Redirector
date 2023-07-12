package com.teampotato.redirectionor.mixin.minecraft.world.level;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.SignalGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SignalGetter.class)
public interface MixinSignalGetter {
    @Shadow int getDirectSignal(BlockPos blockPos, Direction direction);

    @Shadow int getSignal(BlockPos blockPos, Direction direction);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    default boolean hasNeighborSignal(BlockPos blockPos) {
        if (this.getSignal(blockPos.below(), Redirectionor.DOWN) > 0) {
            return true;
        } else if (this.getSignal(blockPos.above(), Redirectionor.UP) > 0) {
            return true;
        } else if (this.getSignal(blockPos.north(), Redirectionor.NORTH) > 0) {
            return true;
        } else if (this.getSignal(blockPos.south(), Redirectionor.SOUTH) > 0) {
            return true;
        } else if (this.getSignal(blockPos.west(), Redirectionor.WEST) > 0) {
            return true;
        } else {
            return this.getSignal(blockPos.east(), Redirectionor.EAST) > 0;
        }
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    default int getDirectSignalTo(BlockPos blockPos) {
        int i = 0;
        i = Math.max(i, this.getDirectSignal(blockPos.below(), Redirectionor.DOWN));
        if (i < 15) {
            i = Math.max(i, this.getDirectSignal(blockPos.above(), Redirectionor.UP));
            if (i < 15) {
                i = Math.max(i, this.getDirectSignal(blockPos.north(), Redirectionor.NORTH));
                if (i < 15) {
                    i = Math.max(i, this.getDirectSignal(blockPos.south(), Redirectionor.SOUTH));
                    if (i < 15) {
                        i = Math.max(i, this.getDirectSignal(blockPos.west(), Redirectionor.WEST));
                        if (i < 15) {
                            i = Math.max(i, this.getDirectSignal(blockPos.east(), Redirectionor.EAST));
                        }
                    }
                }
            }
        }
        return i;
    }
}
