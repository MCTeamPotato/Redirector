package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BasaltPillarFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(value = BasaltPillarFeature.class, priority = 10)
public abstract class BasaltPillarFeatureMixin {
    @Shadow protected abstract boolean placeHangOff(IWorld pLevel, Random pRandom, BlockPos pPos);
    @Shadow protected abstract void placeBaseHangOff(IWorld pLevel, Random pRandom, BlockPos pPos);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public boolean place(ISeedReader p_241855_1_, ChunkGenerator p_241855_2_, Random p_241855_3_, BlockPos p_241855_4_, NoFeatureConfig p_241855_5_) {
        if (p_241855_1_.isEmptyBlock(p_241855_4_) && !p_241855_1_.isEmptyBlock(p_241855_4_.above())) {
            BlockPos.Mutable blockpos$mutable = p_241855_4_.mutable();
            BlockPos.Mutable blockpos$mutable1 = p_241855_4_.mutable();
            boolean flag = true;
            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;

            while(p_241855_1_.isEmptyBlock(blockpos$mutable)) {
                if (World.isOutsideBuildHeight(blockpos$mutable)) {
                    return true;
                }

                p_241855_1_.setBlock(blockpos$mutable, Blocks.BASALT.defaultBlockState(), 2);
                flag = flag && this.placeHangOff(p_241855_1_, p_241855_3_, blockpos$mutable1.setWithOffset(blockpos$mutable, Redirectionor.NORTH));
                flag1 = flag1 && this.placeHangOff(p_241855_1_, p_241855_3_, blockpos$mutable1.setWithOffset(blockpos$mutable, Redirectionor.SOUTH));
                flag2 = flag2 && this.placeHangOff(p_241855_1_, p_241855_3_, blockpos$mutable1.setWithOffset(blockpos$mutable, Redirectionor.WEST));
                flag3 = flag3 && this.placeHangOff(p_241855_1_, p_241855_3_, blockpos$mutable1.setWithOffset(blockpos$mutable, Redirectionor.EAST));
                blockpos$mutable.move(Redirectionor.DOWN);
            }

            blockpos$mutable.move(Redirectionor.UP);
            this.placeBaseHangOff(p_241855_1_, p_241855_3_, blockpos$mutable1.setWithOffset(blockpos$mutable, Redirectionor.NORTH));
            this.placeBaseHangOff(p_241855_1_, p_241855_3_, blockpos$mutable1.setWithOffset(blockpos$mutable, Redirectionor.SOUTH));
            this.placeBaseHangOff(p_241855_1_, p_241855_3_, blockpos$mutable1.setWithOffset(blockpos$mutable, Redirectionor.WEST));
            this.placeBaseHangOff(p_241855_1_, p_241855_3_, blockpos$mutable1.setWithOffset(blockpos$mutable, Redirectionor.EAST));
            blockpos$mutable.move(Redirectionor.DOWN);
            BlockPos.Mutable blockpos$mutable2 = new BlockPos.Mutable();

            for(int i = -3; i < 4; ++i) {
                for(int j = -3; j < 4; ++j) {
                    int k = MathHelper.abs(i) * MathHelper.abs(j);
                    if (p_241855_3_.nextInt(10) < 10 - k) {
                        blockpos$mutable2.set(blockpos$mutable.offset(i, 0, j));
                        int l = 3;

                        while(p_241855_1_.isEmptyBlock(blockpos$mutable1.setWithOffset(blockpos$mutable2, Redirectionor.DOWN))) {
                            blockpos$mutable2.move(Redirectionor.DOWN);
                            --l;
                            if (l <= 0) {
                                break;
                            }
                        }

                        if (!p_241855_1_.isEmptyBlock(blockpos$mutable1.setWithOffset(blockpos$mutable2, Redirectionor.DOWN))) {
                            p_241855_1_.setBlock(blockpos$mutable2, Blocks.BASALT.defaultBlockState(), 2);
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
