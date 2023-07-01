package com.teampotato.redirectionor.mixin.minecraft.client.particle;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.TerrainParticle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ParticleEngine.class)
public abstract class MixinParticleEngine {
    @Shadow protected ClientLevel level;
    @Shadow @Final private RandomSource random;
    @Shadow public abstract void add(Particle pEffect);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public void crack(BlockPos pPos, Direction pSide) {
        BlockState blockstate = this.level.getBlockState(pPos);
        if (blockstate.getRenderShape() != RenderShape.INVISIBLE) {
            int i = pPos.getX();
            int j = pPos.getY();
            int k = pPos.getZ();
            AABB aabb = blockstate.getShape(this.level, pPos).bounds();
            double d0 = (double)i + this.random.nextDouble() * (aabb.maxX - aabb.minX - (double)0.2F) + (double)0.1F + aabb.minX;
            double d1 = (double)j + this.random.nextDouble() * (aabb.maxY - aabb.minY - (double)0.2F) + (double)0.1F + aabb.minY;
            double d2 = (double)k + this.random.nextDouble() * (aabb.maxZ - aabb.minZ - (double)0.2F) + (double)0.1F + aabb.minZ;
            if (pSide == Redirectionor.DOWN) {
                d1 = (double) j + aabb.minY - (double) 0.1F;
            } else if (pSide == Redirectionor.UP) {
                d1 = (double) j + aabb.maxY + (double) 0.1F;
            } else if (pSide == Redirectionor.NORTH) {
                d2 = (double) k + aabb.minZ - (double) 0.1F;
            } else if (pSide == Redirectionor.SOUTH) {
                d2 = (double) k + aabb.maxZ + (double) 0.1F;
            } else if (pSide == Redirectionor.WEST) {
                d0 = (double) i + aabb.minX - (double) 0.1F;
            } else if (pSide == Redirectionor.EAST) {
                d0 = (double) i + aabb.maxX + (double) 0.1F;
            }
            this.add((new TerrainParticle(this.level, d0, d1, d2, 0.0D, 0.0D, 0.0D, blockstate, pPos).updateSprite(blockstate, pPos)).setPower(0.2F).scale(0.6F));
        }
    }
}
