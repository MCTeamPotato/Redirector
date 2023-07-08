package com.teampotato.redirectionor.mixin.minecraft.world.entity.projectile;

import com.google.common.collect.Lists;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ShulkerBullet;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(value = ShulkerBullet.class, priority = 10)
public abstract class MixinShulkerBullet extends Projectile {
    @Shadow @Nullable private Entity finalTarget;
    @Shadow protected abstract void setMoveDirection(@org.jetbrains.annotations.Nullable Direction pDirection);
    @Shadow private int flightSteps;
    @Shadow private double targetDeltaZ;
    @Shadow private double targetDeltaY;
    @Shadow private double targetDeltaX;
    protected MixinShulkerBullet(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Redirect(method = "<init>(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/core/Direction$Axis;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void selectNextMoveDirection(@Nullable Direction.Axis axis) {
        double d = 0.5;
        BlockPos blockPos;
        if (this.finalTarget == null) {
            blockPos = this.blockPosition().below();
        } else {
            d = (double)this.finalTarget.getBbHeight() * 0.5;
            blockPos = BlockPos.containing(this.finalTarget.getX(), this.finalTarget.getY() + d, this.finalTarget.getZ());
        }

        double e = (double)blockPos.getX() + 0.5;
        double f = (double)blockPos.getY() + d;
        double g = (double)blockPos.getZ() + 0.5;
        Direction direction = null;
        if (!blockPos.closerToCenterThan(this.position(), 2.0)) {
            BlockPos blockPos2 = this.blockPosition();
            List<Direction> list = Lists.newArrayList();
            if (axis != Redirectionor.X) {
                if (blockPos2.getX() < blockPos.getX() && this.level().isEmptyBlock(blockPos2.east())) {
                    list.add(Redirectionor.EAST);
                } else if (blockPos2.getX() > blockPos.getX() && this.level().isEmptyBlock(blockPos2.west())) {
                    list.add(Redirectionor.WEST);
                }
            }

            if (axis != Redirectionor.Y) {
                if (blockPos2.getY() < blockPos.getY() && this.level().isEmptyBlock(blockPos2.above())) {
                    list.add(Redirectionor.UP);
                } else if (blockPos2.getY() > blockPos.getY() && this.level().isEmptyBlock(blockPos2.below())) {
                    list.add(Redirectionor.DOWN);
                }
            }

            if (axis != Redirectionor.Z) {
                if (blockPos2.getZ() < blockPos.getZ() && this.level().isEmptyBlock(blockPos2.south())) {
                    list.add(Redirectionor.SOUTH);
                } else if (blockPos2.getZ() > blockPos.getZ() && this.level().isEmptyBlock(blockPos2.north())) {
                    list.add(Redirectionor.NORTH);
                }
            }

            direction = Direction.getRandom(this.random);
            if (list.isEmpty()) {
                for(int i = 5; !this.level().isEmptyBlock(blockPos2.relative(direction)) && i > 0; --i) {
                    direction = Direction.getRandom(this.random);
                }
            } else {
                direction = list.get(this.random.nextInt(list.size()));
            }

            e = this.getX() + (double)direction.getStepX();
            f = this.getY() + (double)direction.getStepY();
            g = this.getZ() + (double)direction.getStepZ();
        }

        this.setMoveDirection(direction);
        double h = e - this.getX();
        double j = f - this.getY();
        double k = g - this.getZ();
        double l = Math.sqrt(h * h + j * j + k * k);
        if (l == 0.0) {
            this.targetDeltaX = 0.0;
            this.targetDeltaY = 0.0;
            this.targetDeltaZ = 0.0;
        } else {
            this.targetDeltaX = h / l * 0.15;
            this.targetDeltaY = j / l * 0.15;
            this.targetDeltaZ = k / l * 0.15;
        }

        this.hasImpulse = true;
        this.flightSteps = 10 + this.random.nextInt(5) * 10;
    }
}
