package com.teampotato.redirectionor.mixin.minecraft.client.entity.player;

import com.mojang.authlib.GameProfile;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ClientPlayerEntity.class, priority = 10)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {
    public ClientPlayerEntityMixin(ClientWorld p_i50991_1_, GameProfile p_i50991_2_) {
        super(p_i50991_1_, p_i50991_2_);
    }

    @Shadow protected abstract boolean suffocatesAt(BlockPos pPos);

    @Redirect(method = "drop", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Unique
    private static final Direction[] redirectionor$directions = new Direction[]{Redirectionor.WEST, Redirectionor.EAST, Redirectionor.NORTH, Redirectionor.SOUTH};

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

            for(Direction direction1 : redirectionor$directions) {
                double d3 = direction1.getAxis().choose(d0, 0.0D, d1);
                double d4 = direction1.getAxisDirection() == Redirectionor.POSITIVE ? 1.0D - d3 : d3;
                if (d4 < d2 && !this.suffocatesAt(blockpos.relative(direction1))) {
                    d2 = d4;
                    direction = direction1;
                }
            }

            if (direction != null) {
                Vector3d vector3d = this.getDeltaMovement();
                if (direction.getAxis() == Redirectionor.X) {
                    this.setDeltaMovement(0.1D * (double)direction.getStepX(), vector3d.y, vector3d.z);
                } else {
                    this.setDeltaMovement(vector3d.x, vector3d.y, 0.1D * (double)direction.getStepZ());
                }
            }

        }
    }
}
