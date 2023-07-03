package com.teampotato.redirectionor.mixin.minecraft.world.level.pathfinder;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;

@Mixin(WalkNodeEvaluator.class)
public abstract class MixinWalkNodeEvaluator extends NodeEvaluator {
    @Shadow @Nullable protected abstract Node findAcceptedNode(int pX, int pY, int pZ, int p_164729_, double p_164730_, Direction p_164731_, BlockPathTypes p_164732_);
    @Shadow protected abstract boolean isDiagonalValid(Node p_77630_, @org.jetbrains.annotations.Nullable Node p_77631_, @org.jetbrains.annotations.Nullable Node p_77632_, @org.jetbrains.annotations.Nullable Node p_77633_);
    @Shadow protected abstract boolean isNeighborValid(@org.jetbrains.annotations.Nullable Node p_77627_, Node p_77628_);
    @Shadow protected abstract BlockPathTypes getCachedBlockType(Mob pEntity, int pX, int pY, int pZ);
    @Shadow protected abstract double getFloorLevel(BlockPos pPos);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @SuppressWarnings("NullableProblems")
    @Overwrite
    public int getNeighbors(Node[] p_77640_, Node p_77641_) {
        int i = 0;
        int j = 0;
        BlockPathTypes blockPathTypes = this.getCachedBlockType(this.mob, p_77641_.x, p_77641_.y, p_77641_.z);
        if (this.mob.getPathfindingMalus(this.getCachedBlockType(this.mob, p_77641_.x, p_77641_.y + 1, p_77641_.z)) >= 0.0F && blockPathTypes != BlockPathTypes.STICKY_HONEY) {
            j = Mth.floor(Math.max(1.0F, this.mob.getStepHeight()));
        }

        double d0 = this.getFloorLevel(new BlockPos(p_77641_.x, p_77641_.y, p_77641_.z));
        Node node = this.findAcceptedNode(p_77641_.x, p_77641_.y, p_77641_.z + 1, j, d0, Redirectionor.SOUTH, blockPathTypes);
        if (this.isNeighborValid(node, p_77641_)) p_77640_[i++] = node;

        Node node1 = this.findAcceptedNode(p_77641_.x - 1, p_77641_.y, p_77641_.z, j, d0, Redirectionor.WEST, blockPathTypes);
        if (this.isNeighborValid(node1, p_77641_)) p_77640_[i++] = node1;

        Node node2 = this.findAcceptedNode(p_77641_.x + 1, p_77641_.y, p_77641_.z, j, d0, Redirectionor.EAST, blockPathTypes);
        if (this.isNeighborValid(node2, p_77641_)) p_77640_[i++] = node2;

        Node node3 = this.findAcceptedNode(p_77641_.x, p_77641_.y, p_77641_.z - 1, j, d0, Redirectionor.NORTH, blockPathTypes);
        if (this.isNeighborValid(node3, p_77641_)) p_77640_[i++] = node3;

        Node node4 = this.findAcceptedNode(p_77641_.x - 1, p_77641_.y, p_77641_.z - 1, j, d0, Redirectionor.NORTH, blockPathTypes);
        if (this.isDiagonalValid(p_77641_, node1, node3, node4)) p_77640_[i++] = node4;

        Node node5 = this.findAcceptedNode(p_77641_.x + 1, p_77641_.y, p_77641_.z - 1, j, d0, Redirectionor.NORTH, blockPathTypes);
        if (this.isDiagonalValid(p_77641_, node2, node3, node5)) p_77640_[i++] = node5;

        Node node6 = this.findAcceptedNode(p_77641_.x - 1, p_77641_.y, p_77641_.z + 1, j, d0, Redirectionor.SOUTH, blockPathTypes);
        if (this.isDiagonalValid(p_77641_, node1, node, node6)) p_77640_[i++] = node6;

        Node node7 = this.findAcceptedNode(p_77641_.x + 1, p_77641_.y, p_77641_.z + 1, j, d0, Redirectionor.SOUTH, blockPathTypes);
        if (this.isDiagonalValid(p_77641_, node2, node, node7)) p_77640_[i++] = node7;
        return i;
    }
}
