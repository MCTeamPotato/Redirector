package com.teampotato.redirectionor.mixin.client.particle;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.particle.DiggingParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(value = ParticleManager.class, priority = 10)
public abstract class ParticleManagerMixin {

    @Shadow protected ClientWorld level;
    @Shadow @Final private Random random;
    @Shadow public abstract void add(Particle pEffect);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public void crack(BlockPos pPos, Direction pSide) {
        BlockState blockstate = this.level.getBlockState(pPos);
        if (blockstate.getRenderShape() != BlockRenderType.INVISIBLE) {
            int i = pPos.getX();
            int j = pPos.getY();
            int k = pPos.getZ();
            AxisAlignedBB axisalignedbb = blockstate.getShape(this.level, pPos).bounds();
            double d0 = (double)i + this.random.nextDouble() * (axisalignedbb.maxX - axisalignedbb.minX - (double)0.2F) + (double)0.1F + axisalignedbb.minX;
            double d1 = (double)j + this.random.nextDouble() * (axisalignedbb.maxY - axisalignedbb.minY - (double)0.2F) + (double)0.1F + axisalignedbb.minY;
            double d2 = (double)k + this.random.nextDouble() * (axisalignedbb.maxZ - axisalignedbb.minZ - (double)0.2F) + (double)0.1F + axisalignedbb.minZ;
            if (pSide == Redirectionor.DOWN) d1 = (double)j + axisalignedbb.minY - (double)0.1F;
            if (pSide == Redirectionor.UP) d1 = (double)j + axisalignedbb.maxY + (double)0.1F;
            if (pSide == Redirectionor.NORTH) d2 = (double)k + axisalignedbb.minZ - (double)0.1F;
            if (pSide == Redirectionor.SOUTH) d2 = (double)k + axisalignedbb.maxZ + (double)0.1F;
            if (pSide == Redirectionor.WEST) d0 = (double)i + axisalignedbb.minX - (double)0.1F;
            if (pSide == Redirectionor.EAST) d0 = (double)i + axisalignedbb.maxX + (double)0.1F;
            this.add((new DiggingParticle(this.level, d0, d1, d2, 0.0D, 0.0D, 0.0D, blockstate)).init(pPos).setPower(0.2F).scale(0.6F));
        }
    }
}
