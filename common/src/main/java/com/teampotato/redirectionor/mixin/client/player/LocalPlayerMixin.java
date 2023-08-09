package com.teampotato.redirectionor.mixin.client.player;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = LocalPlayer.class, priority = 10)
public abstract class LocalPlayerMixin extends AbstractClientPlayer {
    public LocalPlayerMixin(ClientLevel clientLevel, GameProfile gameProfile) {
        super(clientLevel, gameProfile);
    }

    @Shadow protected abstract boolean suffocatesAt(BlockPos blockPos);

    @Unique
    private static final Direction[] DIRECTIONS = new Direction[]{Direction.WEST, Direction.EAST, Direction.NORTH, Direction.SOUTH};

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void moveTowardsClosestSpace(double d, double e) {
        BlockPos blockPos = BlockPos.containing(d, this.getY(), e);
        if (!this.suffocatesAt(blockPos)) return;
        double f = d - (double)blockPos.getX();
        double g = e - (double)blockPos.getZ();
        Direction direction = null;
        double h = Double.MAX_VALUE;
        for (Direction direction2 : DIRECTIONS) {
            double j;
            double i = direction2.getAxis().choose(f, 0.0, g);
            double d2 = j = direction2.getAxisDirection() == Direction.AxisDirection.POSITIVE ? 1.0 - i : i;
            if (!(j < h) || this.suffocatesAt(blockPos.relative(direction2))) continue;
            h = j;
            direction = direction2;
        }
        if (direction != null) {
            Vec3 vec3 = this.getDeltaMovement();
            if (direction.getAxis() == Direction.Axis.X) {
                this.setDeltaMovement(0.1 * (double)direction.getStepX(), vec3.y, vec3.z);
            } else {
                this.setDeltaMovement(vec3.x, vec3.y, 0.1 * (double)direction.getStepZ());
            }
        }
    }
}
