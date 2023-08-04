package com.teampotato.redirectionor.mixin.world.entity;

import com.teampotato.redirectionor.references.DirectionReferences;
import com.teampotato.redirectionor.references.RenderShapeReferences;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = Entity.class, priority = 2000)
public abstract class EntityMixin {
    @Shadow public abstract Vec3 getDeltaMovement();
    @Shadow public abstract void setDeltaMovement(double x, double y, double z);

    @Shadow @Final protected RandomSource random;

    @Shadow public abstract Level level();

    @Redirect(method = "spawnSprintParticle", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;INVISIBLE:Lnet/minecraft/world/level/block/RenderShape;"))
    private RenderShape redirectRenderShapeINVISIBLE() {
        return RenderShapeReferences.INVISIBLE;
    }

    @Unique
    private static final Direction[] DIRECTIONS = new Direction[]{DirectionReferences.NORTH, DirectionReferences.SOUTH, DirectionReferences.WEST, DirectionReferences.EAST, DirectionReferences.UP};

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
        Direction direction = DirectionReferences.UP;
        double g = Double.MAX_VALUE;
        for (Direction direction2 : DIRECTIONS) {
            double i;
            mutableBlockPos.setWithOffset((Vec3i)blockPos, direction2);
            if (this.level().getBlockState(mutableBlockPos).isCollisionShapeFullBlock(this.level(), mutableBlockPos)) continue;
            double h = vec3.get(direction2.getAxis());
            double d2 = i = direction2.getAxisDirection() == DirectionReferences.AxisDirectionReferences.POSITIVE ? 1.0 - h : h;
            if (!(i < g)) continue;
            g = i;
            direction = direction2;
        }
        float j = this.random.nextFloat() * 0.2f + 0.1f;
        float k = direction.getAxisDirection().getStep();
        Vec3 vec32 = this.getDeltaMovement().scale(0.75);
        if (direction.getAxis() == DirectionReferences.AxisReferences.X) {
            this.setDeltaMovement(k * j, vec32.y, vec32.z);
        } else if (direction.getAxis() == DirectionReferences.AxisReferences.Y) {
            this.setDeltaMovement(vec32.x, k * j, vec32.z);
        } else if (direction.getAxis() == DirectionReferences.AxisReferences.Z) {
            this.setDeltaMovement(vec32.x, vec32.y, k * j);
        }
    }
}
