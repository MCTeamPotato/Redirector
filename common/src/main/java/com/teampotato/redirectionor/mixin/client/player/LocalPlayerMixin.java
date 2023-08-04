package com.teampotato.redirectionor.mixin.client.player;

import com.mojang.authlib.GameProfile;
import com.teampotato.redirectionor.references.DirectionReferences;
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

@Mixin(value = LocalPlayer.class, priority = 2000)
public abstract class LocalPlayerMixin extends AbstractClientPlayer {
    public LocalPlayerMixin(ClientLevel clientLevel, GameProfile gameProfile) {
        super(clientLevel, gameProfile);
    }

    @Shadow protected abstract boolean suffocatesAt(BlockPos pos);

    @Unique
    private static final Direction[] DIRECTIONS = new Direction[]{DirectionReferences.WEST, DirectionReferences.EAST, DirectionReferences.NORTH, DirectionReferences.SOUTH};

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    @SuppressWarnings("unused")
    private void moveTowardsClosestSpace(double x, double z) {
        BlockPos blockPos = new BlockPos(x, this.getY(), z);
        if (!this.suffocatesAt(blockPos)) {
            return;
        }
        double d = x - (double)blockPos.getX();
        double e = z - (double)blockPos.getZ();
        Direction direction = null;
        double f = Double.MAX_VALUE;
        for (Direction direction2 : DIRECTIONS) {
            double h;
            double g = direction2.getAxis().choose(d, 0.0, e);
            double d2 = h = direction2.getAxisDirection() == DirectionReferences.AxisDirectionReferences.POSITIVE ? 1.0 - g : g;
            if (!(h < f) || this.suffocatesAt(blockPos.relative(direction2))) continue;
            f = h;
            direction = direction2;
        }
        if (direction != null) {
            Vec3 vec3 = this.getDeltaMovement();
            if (direction.getAxis() == DirectionReferences.AxisReferences.X) {
                this.setDeltaMovement(0.1 * (double)direction.getStepX(), vec3.y, vec3.z);
            } else {
                this.setDeltaMovement(vec3.x, vec3.y, 0.1 * (double)direction.getStepZ());
            }
        }
    }

}
