package com.teampotato.redirectionor.mixin.world.entity;

import com.teampotato.redirectionor.references.DirectionReferences;
import com.teampotato.redirectionor.references.RenderShapeReferences;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(value = Entity.class, priority = 2000)
public abstract class EntityMixin {
    @Shadow public abstract Vec3 getDeltaMovement();
    @Shadow public abstract void setDeltaMovement(double x, double y, double z);

    @Shadow public Level level;

    @Shadow @Final protected Random random;

    @Redirect(method = "spawnSprintParticle", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;INVISIBLE:Lnet/minecraft/world/level/block/RenderShape;"))
    private RenderShape redirectRenderShapeINVISIBLE() {
        return RenderShapeReferences.INVISIBLE;
    }

    @Unique
    private static final Direction[] DIRECTIONS = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST, Direction.UP};

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    @SuppressWarnings("unused")
    protected void moveTowardsClosestSpace(double x, double y, double z) {
        BlockPos blockPos = new BlockPos(x, y, z);
        Vec3 vec3 = new Vec3(x - (double)blockPos.getX(), y - (double)blockPos.getY(), z - (double)blockPos.getZ());
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        Direction direction = DirectionReferences.UP;
        double d = Double.MAX_VALUE;
        for (Direction direction2 : DIRECTIONS) {
            double f;
            mutableBlockPos.setWithOffset(blockPos, direction2);
            if (this.level.getBlockState(mutableBlockPos).isCollisionShapeFullBlock(this.level, mutableBlockPos)) continue;
            double e = vec3.get(direction2.getAxis());
            double d2 = f = direction2.getAxisDirection() == DirectionReferences.AxisDirectionReferences.POSITIVE ? 1.0 - e : e;
            if (!(f < d)) continue;
            d = f;
            direction = direction2;
        }
        float g = this.random.nextFloat() * 0.2f + 0.1f;
        float h = direction.getAxisDirection().getStep();
        Vec3 vec32 = this.getDeltaMovement().scale(0.75);
        if (direction.getAxis() == DirectionReferences.AxisReferences.X) {
            this.setDeltaMovement(h * g, vec32.y, vec32.z);
        } else if (direction.getAxis() == DirectionReferences.AxisReferences.Y) {
            this.setDeltaMovement(vec32.x, h * g, vec32.z);
        } else if (direction.getAxis() == DirectionReferences.AxisReferences.Z) {
            this.setDeltaMovement(vec32.x, vec32.y, h * g);
        }
    }
}
