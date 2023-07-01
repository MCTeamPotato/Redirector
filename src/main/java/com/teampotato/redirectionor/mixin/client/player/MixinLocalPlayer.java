package com.teampotato.redirectionor.mixin.client.player;

import com.mojang.authlib.GameProfile;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.ProfilePublicKey;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LocalPlayer.class)
public abstract class MixinLocalPlayer extends AbstractClientPlayer {
    @Shadow protected abstract boolean suffocatesAt(BlockPos pPos);

    public MixinLocalPlayer(ClientLevel pClientLevel, GameProfile pGameProfile, @Nullable ProfilePublicKey pProfilePublicKey) {
        super(pClientLevel, pGameProfile, pProfilePublicKey);
    }

    private static final Direction[] adirection = new Direction[]{Redirectionor.WEST, Redirectionor.EAST, Redirectionor.NORTH, Redirectionor.SOUTH};

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void moveTowardsClosestSpace(double pX, double pZ) {
        BlockPos blockpos = new BlockPos(pX, this.getY(), pZ);
        if (this.suffocatesAt(blockpos)) {
            double d0 = pX - (double)blockpos.getX();
            double d1 = pZ - (double)blockpos.getZ();
            Direction direction = null;
            double d2 = Double.MAX_VALUE;
            for(Direction direction1 : adirection) {
                double d3 = direction1.getAxis().choose(d0, 0.0D, d1);
                double d4 = direction1.getAxisDirection() == Direction.AxisDirection.POSITIVE ? 1.0D - d3 : d3;
                if (d4 < d2 && !this.suffocatesAt(blockpos.relative(direction1))) {
                    d2 = d4;
                    direction = direction1;
                }
            }

            if (direction != null) {
                Vec3 vec3 = this.getDeltaMovement();
                if (direction.getAxis() == Direction.Axis.X) {
                    this.setDeltaMovement(0.1D * (double)direction.getStepX(), vec3.y, vec3.z);
                } else {
                    this.setDeltaMovement(vec3.x, vec3.y, 0.1D * (double)direction.getStepZ());
                }
            }
        }
    }
}
