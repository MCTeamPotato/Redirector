package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.CoralClawFeature;
import net.minecraft.world.level.levelgen.feature.CoralFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("NullableProblems")
@Mixin(CoralClawFeature.class)
public abstract class MixinCoralClawFeature extends CoralFeature {
    public MixinCoralClawFeature(Codec<NoneFeatureConfiguration> p_65429_) {
        super(p_65429_);
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    protected boolean placeFeature(LevelAccessor p_224959_, RandomSource p_224960_, BlockPos p_224961_, BlockState p_224962_) {
        if (!this.placeCoralBlock(p_224959_, p_224960_, p_224961_, p_224962_)) {
            return false;
        } else {
            Direction direction = Redirectionor.HORIZONTAL.getRandomDirection(p_224960_);
            int i = p_224960_.nextInt(2) + 2;
            List<Direction> list = Util.toShuffledList(Stream.of(direction, direction.getClockWise(), direction.getCounterClockWise()), p_224960_);

            for(Direction direction1 : list.subList(0, i)) {
                BlockPos.MutableBlockPos blockpos$mutableblockpos = p_224961_.mutable();
                int j = p_224960_.nextInt(2) + 1;
                blockpos$mutableblockpos.move(direction1);
                int k;
                Direction direction2;
                if (direction1 == direction) {
                    direction2 = direction;
                    k = p_224960_.nextInt(3) + 2;
                } else {
                    blockpos$mutableblockpos.move(Redirectionor.UP);
                    Direction[] adirection = new Direction[]{direction1, Redirectionor.UP};
                    direction2 = Util.getRandom(adirection, p_224960_);
                    k = p_224960_.nextInt(3) + 3;
                }

                for(int l = 0; l < j && this.placeCoralBlock(p_224959_, p_224960_, blockpos$mutableblockpos, p_224962_); ++l) {
                    blockpos$mutableblockpos.move(direction2);
                }

                blockpos$mutableblockpos.move(direction2.getOpposite());
                blockpos$mutableblockpos.move(Redirectionor.UP);

                for(int i1 = 0; i1 < k; ++i1) {
                    blockpos$mutableblockpos.move(direction);
                    if (!this.placeCoralBlock(p_224959_, p_224960_, blockpos$mutableblockpos, p_224962_)) {
                        break;
                    }

                    if (p_224960_.nextFloat() < 0.25F) {
                        blockpos$mutableblockpos.move(Redirectionor.UP);
                    }
                }
            }

            return true;
        }
    }
}