package com.teampotato.redirectionor.mixin.minecraft.entity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;

import java.util.Random;

@Mixin(value = Entity.class, priority = 10)
public abstract class EntityMixin {
    @Shadow public World level;
    @Shadow @Final protected Random random;
    @Shadow public abstract Vector3d getDeltaMovement();
    @Shadow public abstract void setDeltaMovement(double pX, double pY, double pZ);

    @Unique private static final Direction[] redirectionor$directions = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST, Direction.UP};

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    protected void moveTowardsClosestSpace(double pX, double pY, double pZ) {
        BlockPos blockpos = new BlockPos(pX, pY, pZ);
        Vector3d vector3d = new Vector3d(pX - (double)blockpos.getX(), pY - (double)blockpos.getY(), pZ - (double)blockpos.getZ());
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        Direction direction = Redirectionor.UP;
        double d0 = Double.MAX_VALUE;

        for(Direction direction1 : redirectionor$directions) {
            blockpos$mutable.setWithOffset(blockpos, direction1);
            if (!this.level.getBlockState(blockpos$mutable).isCollisionShapeFullBlock(this.level, blockpos$mutable)) {
                double d1 = vector3d.get(direction1.getAxis());
                double d2 = direction1.getAxisDirection() == Redirectionor.POSITIVE ? 1.0D - d1 : d1;
                if (d2 < d0) {
                    d0 = d2;
                    direction = direction1;
                }
            }
        }

        float f = this.random.nextFloat() * 0.2F + 0.1F;
        float f1 = (float)direction.getAxisDirection().getStep();
        Vector3d vector3d1 = this.getDeltaMovement().scale(0.75D);
        if (direction.getAxis() == Direction.Axis.X) {
            this.setDeltaMovement(f1 * f, vector3d1.y, vector3d1.z);
        } else if (direction.getAxis() == Direction.Axis.Y) {
            this.setDeltaMovement(vector3d1.x, f1 * f, vector3d1.z);
        } else if (direction.getAxis() == Direction.Axis.Z) {
            this.setDeltaMovement(vector3d1.x, vector3d1.y, f1 * f);
        }
    }

    //TODO:Axis.X
}
