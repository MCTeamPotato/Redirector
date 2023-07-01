package com.teampotato.redirectionor.mixin.world.level.biome;

import com.mojang.datafixers.util.Pair;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

@Mixin(BiomeSource.class)
public abstract class MixinBiomeSource {
    @Shadow public abstract Set<Holder<Biome>> possibleBiomes();

    @Shadow public abstract Holder<Biome> getNoiseBiome(int pX, int pY, int pZ, Climate.Sampler pSampler);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    @Nullable
    public Pair<BlockPos, Holder<Biome>> findClosestBiome3d(BlockPos p_220578_, int p_220579_, int p_220580_, int p_220581_, Predicate<Holder<Biome>> p_220582_, Climate.Sampler p_220583_, LevelReader p_220584_) {
        Set<Holder<Biome>> set = new HashSet<>();
        for (Holder<Biome> biomeHolder : possibleBiomes()) {
            if (p_220582_.test(biomeHolder)) set.add(biomeHolder);
        }
        if (!set.isEmpty()) {
            for (BlockPos.MutableBlockPos blockpos$mutableblockpos : BlockPos.spiralAround(BlockPos.ZERO, Math.floorDiv(p_220579_, p_220580_), Redirectionor.EAST, Redirectionor.SOUTH)) {
                int j = p_220578_.getX() + blockpos$mutableblockpos.getX() * p_220580_;
                int k = p_220578_.getZ() + blockpos$mutableblockpos.getZ() * p_220580_;

                for (int j1 : Mth.outFromOrigin(p_220578_.getY(), p_220584_.getMinBuildHeight() + 1, p_220584_.getMaxBuildHeight(), p_220581_).toArray()) {
                    Holder<Biome> holder = this.getNoiseBiome(QuartPos.fromBlock(j), QuartPos.fromBlock(j1), QuartPos.fromBlock(k), p_220583_);
                    if (set.contains(holder)) return Pair.of(new BlockPos(j, j1, k), holder);
                }
            }

        }
        return null;
    }
}
