package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.feature;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.BasaltPillarFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BasaltPillarFeature.class)
public abstract class MixinBasaltPillarFeature {
    @Shadow protected abstract boolean placeHangOff(LevelAccessor pLevle, RandomSource pRandom, BlockPos pPos);

    @Shadow protected abstract void placeBaseHangOff(LevelAccessor pLevel, RandomSource pRandom, BlockPos pPos);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        BlockPos blockpos = pContext.origin();
        WorldGenLevel worldgenlevel = pContext.level();
        RandomSource randomsource = pContext.random();
        if (worldgenlevel.isEmptyBlock(blockpos) && !worldgenlevel.isEmptyBlock(blockpos.above())) {
            BlockPos.MutableBlockPos blockpos$mutableblockpos = blockpos.mutable();
            BlockPos.MutableBlockPos blockpos$mutableblockpos1 = blockpos.mutable();
            boolean flag = true;
            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;

            while(worldgenlevel.isEmptyBlock(blockpos$mutableblockpos)) {
                if (worldgenlevel.isOutsideBuildHeight(blockpos$mutableblockpos)) {
                    return true;
                }

                worldgenlevel.setBlock(blockpos$mutableblockpos, Blocks.BASALT.defaultBlockState(), 2);
                flag = flag && this.placeHangOff(worldgenlevel, randomsource, blockpos$mutableblockpos1.setWithOffset(blockpos$mutableblockpos, Redirectionor.NORTH));
                flag1 = flag1 && this.placeHangOff(worldgenlevel, randomsource, blockpos$mutableblockpos1.setWithOffset(blockpos$mutableblockpos, Redirectionor.SOUTH));
                flag2 = flag2 && this.placeHangOff(worldgenlevel, randomsource, blockpos$mutableblockpos1.setWithOffset(blockpos$mutableblockpos, Redirectionor.WEST));
                flag3 = flag3 && this.placeHangOff(worldgenlevel, randomsource, blockpos$mutableblockpos1.setWithOffset(blockpos$mutableblockpos, Redirectionor.EAST));
                blockpos$mutableblockpos.move(Redirectionor.DOWN);
            }

            blockpos$mutableblockpos.move(Redirectionor.UP);
            this.placeBaseHangOff(worldgenlevel, randomsource, blockpos$mutableblockpos1.setWithOffset(blockpos$mutableblockpos, Redirectionor.NORTH));
            this.placeBaseHangOff(worldgenlevel, randomsource, blockpos$mutableblockpos1.setWithOffset(blockpos$mutableblockpos, Redirectionor.SOUTH));
            this.placeBaseHangOff(worldgenlevel, randomsource, blockpos$mutableblockpos1.setWithOffset(blockpos$mutableblockpos, Redirectionor.WEST));
            this.placeBaseHangOff(worldgenlevel, randomsource, blockpos$mutableblockpos1.setWithOffset(blockpos$mutableblockpos, Redirectionor.EAST));
            blockpos$mutableblockpos.move(Redirectionor.DOWN);
            BlockPos.MutableBlockPos blockpos$mutableblockpos2 = new BlockPos.MutableBlockPos();

            for(int i = -3; i < 4; ++i) {
                for(int j = -3; j < 4; ++j) {
                    int k = Mth.abs(i) * Mth.abs(j);
                    if (randomsource.nextInt(10) < 10 - k) {
                        blockpos$mutableblockpos2.set(blockpos$mutableblockpos.offset(i, 0, j));
                        int l = 3;

                        while(worldgenlevel.isEmptyBlock(blockpos$mutableblockpos1.setWithOffset(blockpos$mutableblockpos2, Redirectionor.DOWN))) {
                            blockpos$mutableblockpos2.move(Redirectionor.DOWN);
                            --l;
                            if (l <= 0) {
                                break;
                            }
                        }

                        if (!worldgenlevel.isEmptyBlock(blockpos$mutableblockpos1.setWithOffset(blockpos$mutableblockpos2, Redirectionor.DOWN))) {
                            worldgenlevel.setBlock(blockpos$mutableblockpos2, Blocks.BASALT.defaultBlockState(), 2);
                        }
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
