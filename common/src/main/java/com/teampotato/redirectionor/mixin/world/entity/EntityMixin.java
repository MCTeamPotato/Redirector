package com.teampotato.redirectionor.mixin.world.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.*;

@Mixin(value = Entity.class, priority = 10)
public abstract class EntityMixin {
    @Shadow public abstract Vec3 getDeltaMovement();
    @Shadow public abstract void setDeltaMovement(double x, double y, double z);

    @Shadow @Final protected RandomSource random;

    @Shadow public abstract Level level();

    @Unique
    private static final Direction[] DIRECTIONS = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST, Direction.UP};

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    @SuppressWarnings("unused")
    protected void moveTowardsClosestSpace(double d, double e, double f) {
        BlockPos blockPos = BlockPos.containing(d, e, f);
        Vec3 vec3 = new Vec3(d - (double)blockPos.getX(), e - (double)blockPos.getY(), f - (double)blockPos.getZ());
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        Direction direction = Direction.UP;
        double g = Double.MAX_VALUE;
        for (Direction direction2 : DIRECTIONS) {
            double i;
            mutableBlockPos.setWithOffset(blockPos, direction2);
            if (this.level().getBlockState(mutableBlockPos).isCollisionShapeFullBlock(this.level(), mutableBlockPos)) continue;
            double h = vec3.get(direction2.getAxis());
            double d2 = i = direction2.getAxisDirection() == Direction.AxisDirection.POSITIVE ? 1.0 - h : h;
            if (!(i < g)) continue;
            g = i;
            direction = direction2;
        }
        float j = this.random.nextFloat() * 0.2f + 0.1f;
        float k = direction.getAxisDirection().getStep();
        Vec3 vec32 = this.getDeltaMovement().scale(0.75);
        if (direction.getAxis() == Direction.Axis.X) {
            this.setDeltaMovement(k * j, vec32.y, vec32.z);
        } else if (direction.getAxis() == Direction.Axis.Y) {
            this.setDeltaMovement(vec32.x, k * j, vec32.z);
        } else if (direction.getAxis() == Direction.Axis.Z) {
            this.setDeltaMovement(vec32.x, vec32.y, k * j);
        }
    }
}