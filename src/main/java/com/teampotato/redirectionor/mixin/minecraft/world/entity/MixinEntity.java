package com.teampotato.redirectionor.mixin.minecraft.world.entity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Entity.class)
public abstract class MixinEntity {
    @Shadow public Level level;
    @Shadow @Final protected RandomSource random;
    @Shadow public abstract Vec3 getDeltaMovement();
    @Shadow public abstract void setDeltaMovement(double pX, double pY, double pZ);
    private static final Direction[] DIRECTIONS = new Direction[]{Redirectionor.NORTH, Redirectionor.SOUTH, Redirectionor.WEST, Redirectionor.EAST, Redirectionor.UP};

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    protected void moveTowardsClosestSpace(double pX, double pY, double pZ) {
        BlockPos blockpos = new BlockPos(pX, pY, pZ);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        Direction direction = Redirectionor.UP;
        double d0 = Double.MAX_VALUE;

        for(Direction direction1 : DIRECTIONS) {
            blockpos$mutableblockpos.setWithOffset(blockpos, direction1);
            if (!this.level.getBlockState(blockpos$mutableblockpos).isCollisionShapeFullBlock(this.level, blockpos$mutableblockpos)) {
                double d1 = (new Vec3(pX - (double)blockpos.getX(), pY - (double)blockpos.getY(), pZ - (double)blockpos.getZ())).get(direction1.getAxis());
                double d2 = direction1.getAxisDirection() == Redirectionor.POSITIVE ? 1.0D - d1 : d1;
                if (d2 < d0) {
                    d0 = d2;
                    direction = direction1;
                }
            }
        }

        float f = this.random.nextFloat() * 0.2F + 0.1F;
        float f1 = (float)direction.getAxisDirection().getStep();
        Vec3 vec31 = this.getDeltaMovement().scale(0.75D);
        if (direction.getAxis() == Redirectionor.X) {
            this.setDeltaMovement(f1 * f, vec31.y, vec31.z);
        } else if (direction.getAxis() == Redirectionor.Y) {
            this.setDeltaMovement(vec31.x, f1 * f, vec31.z);
        } else if (direction.getAxis() == Redirectionor.Z) {
            this.setDeltaMovement(vec31.x, vec31.y, f1 * f);
        }
    }
}
