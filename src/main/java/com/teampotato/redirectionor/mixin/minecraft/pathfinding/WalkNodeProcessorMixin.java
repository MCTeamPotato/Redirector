package com.teampotato.redirectionor.mixin.minecraft.pathfinding;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.entity.MobEntity;
import net.minecraft.pathfinding.NodeProcessor;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.pathfinding.WalkNodeProcessor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;

@Mixin(value = WalkNodeProcessor.class, priority = 10)
public abstract class WalkNodeProcessorMixin extends NodeProcessor {
    @Shadow protected abstract PathNodeType getCachedBlockType(MobEntity pEntity, int pX, int pY, int pZ);
    @Shadow public static double getFloorLevel(IBlockReader pLevel, BlockPos pPos) {
        return 0.0;
    }
    @Shadow @Nullable protected abstract PathPoint getLandNode(int p_186332_1_, int p_186332_2_, int p_186332_3_, int p_186332_4_, double p_186332_5_, Direction p_186332_7_, PathNodeType p_186332_8_);
    @Shadow protected abstract boolean isNeighborValid(PathPoint p_237235_1_, PathPoint p_237235_2_);
    @Shadow protected abstract boolean isDiagonalValid(PathPoint p_222860_1_, @Nullable PathPoint p_222860_2_, @Nullable PathPoint p_222860_3_, @Nullable PathPoint p_222860_4_);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public int getNeighbors(PathPoint[] p_222859_1_, PathPoint p_222859_2_) {
        int i = 0;
        int j = 0;
        PathNodeType pathNodeType = this.getCachedBlockType(this.mob, p_222859_2_.x, p_222859_2_.y, p_222859_2_.z);
        if (this.mob.getPathfindingMalus(this.getCachedBlockType(this.mob, p_222859_2_.x, p_222859_2_.y + 1, p_222859_2_.z)) >= 0.0F && pathNodeType != PathNodeType.STICKY_HONEY) j = MathHelper.floor(Math.max(1.0F, this.mob.maxUpStep));

        double d0 = getFloorLevel(this.level, new BlockPos(p_222859_2_.x, p_222859_2_.y, p_222859_2_.z));
        PathPoint pathpoint = this.getLandNode(p_222859_2_.x, p_222859_2_.y, p_222859_2_.z + 1, j, d0, Redirectionor.SOUTH, pathNodeType);
        if (this.isNeighborValid(pathpoint, p_222859_2_)) p_222859_1_[i++] = pathpoint;

        PathPoint pathpoint1 = this.getLandNode(p_222859_2_.x - 1, p_222859_2_.y, p_222859_2_.z, j, d0, Redirectionor.WEST, pathNodeType);
        if (this.isNeighborValid(pathpoint1, p_222859_2_)) p_222859_1_[i++] = pathpoint1;

        PathPoint pathpoint2 = this.getLandNode(p_222859_2_.x + 1, p_222859_2_.y, p_222859_2_.z, j, d0, Redirectionor.EAST, pathNodeType);
        if (this.isNeighborValid(pathpoint2, p_222859_2_)) p_222859_1_[i++] = pathpoint2;

        PathPoint pathpoint3 = this.getLandNode(p_222859_2_.x, p_222859_2_.y, p_222859_2_.z - 1, j, d0, Redirectionor.NORTH, pathNodeType);
        if (this.isNeighborValid(pathpoint3, p_222859_2_)) p_222859_1_[i++] = pathpoint3;

        PathPoint pathpoint4 = this.getLandNode(p_222859_2_.x - 1, p_222859_2_.y, p_222859_2_.z - 1, j, d0, Redirectionor.NORTH, pathNodeType);
        if (this.isDiagonalValid(p_222859_2_, pathpoint1, pathpoint3, pathpoint4)) p_222859_1_[i++] = pathpoint4;

        PathPoint pathpoint5 = this.getLandNode(p_222859_2_.x + 1, p_222859_2_.y, p_222859_2_.z - 1, j, d0, Redirectionor.NORTH, pathNodeType);
        if (this.isDiagonalValid(p_222859_2_, pathpoint2, pathpoint3, pathpoint5)) p_222859_1_[i++] = pathpoint5;


        PathPoint pathpoint6 = this.getLandNode(p_222859_2_.x - 1, p_222859_2_.y, p_222859_2_.z + 1, j, d0, Redirectionor.SOUTH, pathNodeType);
        if (this.isDiagonalValid(p_222859_2_, pathpoint1, pathpoint, pathpoint6)) p_222859_1_[i++] = pathpoint6;

        PathPoint pathpoint7 = this.getLandNode(p_222859_2_.x + 1, p_222859_2_.y, p_222859_2_.z + 1, j, d0, Redirectionor.SOUTH, pathNodeType);
        if (this.isDiagonalValid(p_222859_2_, pathpoint2, pathpoint, pathpoint7)) p_222859_1_[i++] = pathpoint7;

        return i;
    }
}
