package com.teampotato.redirectionor.mixin.minecraft.world.level;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Level.class)
public abstract class MixinLevel implements LevelAccessor{
    @Shadow public abstract int getSignal(BlockPos pPos, Direction pFacing);

    @Redirect(method = "updateNeighbourForOutputSignal", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] implValues1() {
        return Redirectionor.DIRECTIONS;
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public int getDirectSignalTo(BlockPos pPos) {
        int i = 0;
        i = Math.max(i, this.getDirectSignal(pPos.below(), Redirectionor.DOWN));
        if (i >= 15) {
            return i;
        } else {
            i = Math.max(i, this.getDirectSignal(pPos.above(), Redirectionor.UP));
            if (i >= 15) {
                return i;
            } else {
                i = Math.max(i, this.getDirectSignal(pPos.north(), Redirectionor.NORTH));
                if (i >= 15) {
                    return i;
                } else {
                    i = Math.max(i, this.getDirectSignal(pPos.south(), Redirectionor.SOUTH));
                    if (i >= 15) {
                        return i;
                    } else {
                        i = Math.max(i, this.getDirectSignal(pPos.west(), Redirectionor.WEST));
                        if (i >= 15) {
                            return i;
                        } else {
                            i = Math.max(i, this.getDirectSignal(pPos.east(), Redirectionor.EAST));
                            return i;
                        }
                    }
                }
            }
        }
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public boolean hasNeighborSignal(BlockPos pPos) {
        return this.getSignal(pPos.below(), Redirectionor.DOWN) > 0 ||
                this.getSignal(pPos.above(), Redirectionor.UP) > 0 ||
                this.getSignal(pPos.north(), Redirectionor.NORTH) > 0 ||
                this.getSignal(pPos.south(), Redirectionor.SOUTH) > 0 ||
                this.getSignal(pPos.west(), Redirectionor.WEST) > 0 ||
                this.getSignal(pPos.east(), Redirectionor.EAST) > 0;
    }

    @Redirect(method = "loadedAndEntityCanStandOn", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
