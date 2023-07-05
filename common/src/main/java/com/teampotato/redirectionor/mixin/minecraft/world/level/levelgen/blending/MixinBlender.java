package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.blending;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.blending.BlendingData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = Blender.class, priority = 10)
public abstract class MixinBlender {
    @Shadow
    private static void generateBorderTick(ChunkAccess p_197041_, BlockPos p_197042_) {}

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public static void generateBorderTicks(WorldGenRegion p_197032_, ChunkAccess p_197033_) {
        ChunkPos chunkpos = p_197033_.getPos();
        boolean flag = p_197033_.isOldNoiseGeneration();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        BlockPos blockpos = new BlockPos(chunkpos.getMinBlockX(), 0, chunkpos.getMinBlockZ());
        BlendingData blendingdata = p_197033_.getBlendingData();
        if (blendingdata != null) {
            int i = blendingdata.getAreaWithOldGeneration().getMinBuildHeight();
            int j = blendingdata.getAreaWithOldGeneration().getMaxBuildHeight() - 1;
            if (flag) {
                for(int k = 0; k < 16; ++k) {
                    for(int l = 0; l < 16; ++l) {
                        generateBorderTick(p_197033_, blockpos$mutableblockpos.setWithOffset(blockpos, k, i - 1, l));
                        generateBorderTick(p_197033_, blockpos$mutableblockpos.setWithOffset(blockpos, k, i, l));
                        generateBorderTick(p_197033_, blockpos$mutableblockpos.setWithOffset(blockpos, k, j, l));
                        generateBorderTick(p_197033_, blockpos$mutableblockpos.setWithOffset(blockpos, k, j + 1, l));
                    }
                }
            }

            for(Direction direction : Redirectionor.HORIZONTAL) {
                if (p_197032_.getChunk(chunkpos.x + direction.getStepX(), chunkpos.z + direction.getStepZ()).isOldNoiseGeneration() != flag) {
                    int i1 = direction == Redirectionor.EAST ? 15 : 0;
                    int j1 = direction == Redirectionor.WEST ? 0 : 15;
                    int k1 = direction == Redirectionor.SOUTH ? 15 : 0;
                    int l1 = direction == Redirectionor.NORTH ? 0 : 15;

                    for(int i2 = i1; i2 <= j1; ++i2) {
                        for(int j2 = k1; j2 <= l1; ++j2) {
                            int k2 = Math.min(j, p_197033_.getHeight(Heightmap.Types.MOTION_BLOCKING, i2, j2)) + 1;

                            for(int l2 = i; l2 < k2; ++l2) {
                                generateBorderTick(p_197033_, blockpos$mutableblockpos.setWithOffset(blockpos, i2, l2, j2));
                            }
                        }
                    }
                }
            }
        }
    }
}
