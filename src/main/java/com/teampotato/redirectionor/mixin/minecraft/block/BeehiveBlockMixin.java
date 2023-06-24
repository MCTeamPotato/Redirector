package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = BeehiveBlock.class, priority = 10)
public abstract class BeehiveBlockMixin {
    @Shadow
    @OnlyIn(Dist.CLIENT)
    protected abstract void spawnFluidParticle(World pParticleData, double pX1, double pX2, double pZ1, double pZ2, double pY);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    @OnlyIn(Dist.CLIENT)
    private void spawnParticle(World pLevel, BlockPos pPos, VoxelShape pShape, double pY) {
        this.spawnFluidParticle(pLevel, (double)pPos.getX() + pShape.min(Redirectionor.X), (double)pPos.getX() + pShape.max(Redirectionor.X), (double)pPos.getZ() + pShape.min(Redirectionor.Z), (double)pPos.getZ() + pShape.max(Redirectionor.Z), pY);
    }
}
