package com.teampotato.redirectionor.mixin.world;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.EnumSet;

@Mixin(World.class)
public abstract class WorldMixin implements IWorld {
    @Shadow public abstract BlockState getBlockState(BlockPos pPos);
    @Shadow public abstract void neighborChanged(BlockPos pPos, Block pBlock, BlockPos pFromPos);
    @Shadow public abstract int getSignal(BlockPos pPos, Direction pFacing);

    @Redirect(method = "updateNeighbourForOutputSignal", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return Redirectionor.DIRECTIONS;
    }

    /**
     * @author Kasualix
     * @reason avoid direction allocation
     */
    @Overwrite
    public void updateNeighborsAtExceptFromFacing(BlockPos pPos, Block pBlockType, Direction pSkipSide) {
        EnumSet<Direction> directions = EnumSet.allOf(Direction.class);
        directions.remove(pSkipSide);
        if (ForgeEventFactory.onNeighborNotify((World) (Object)this, pPos, this.getBlockState(pPos), directions, false).isCanceled()) return;
        if (pSkipSide != Redirectionor.WEST) this.neighborChanged(pPos.west(), pBlockType, pPos);
        if (pSkipSide != Redirectionor.EAST) this.neighborChanged(pPos.east(), pBlockType, pPos);
        if (pSkipSide != Redirectionor.DOWN) this.neighborChanged(pPos.below(), pBlockType, pPos);
        if (pSkipSide != Redirectionor.UP) this.neighborChanged(pPos.above(), pBlockType, pPos);
        if (pSkipSide != Redirectionor.NORTH) this.neighborChanged(pPos.north(), pBlockType, pPos);
        if (pSkipSide != Redirectionor.SOUTH) this.neighborChanged(pPos.south(), pBlockType, pPos);
    }

    /**
     * @author Kasualix
     * @reason avoid direction allocation
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
     * @reason avoid direction allocation
     */
    @Overwrite
    public boolean hasNeighborSignal(BlockPos pPos) {
        if (this.getSignal(pPos.below(), Redirectionor.DOWN) > 0) {
            return true;
        } else if (this.getSignal(pPos.above(), Redirectionor.UP) > 0) {
            return true;
        } else if (this.getSignal(pPos.north(), Redirectionor.NORTH) > 0) {
            return true;
        } else if (this.getSignal(pPos.south(), Redirectionor.SOUTH) > 0) {
            return true;
        } else if (this.getSignal(pPos.west(), Redirectionor.WEST) > 0) {
            return true;
        } else {
            return this.getSignal(pPos.east(), Redirectionor.EAST) > 0;
        }
    }

    @Redirect(method = "loadedAndEntityCanStandOn", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"), remap = false)
    private Direction implUp1() {
        return Redirectionor.UP;
    }
}
