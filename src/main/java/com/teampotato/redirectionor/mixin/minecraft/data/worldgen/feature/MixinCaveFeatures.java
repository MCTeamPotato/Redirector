package com.teampotato.redirectionor.mixin.minecraft.data.worldgen.feature;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SmallDripleafBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.List;

@Mixin(CaveFeatures.class)
public abstract class MixinCaveFeatures {
    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static Holder<PlacedFeature> makeDripleaf(Direction pFacingDirection) {
        return PlacementUtils.inlinePlaced(Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(BlockColumnConfiguration.layer(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(UniformInt.of(0, 4), 2).add(ConstantInt.of(0), 1).build()), BlockStateProvider.simple(Blocks.BIG_DRIPLEAF_STEM.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pFacingDirection))), BlockColumnConfiguration.layer(ConstantInt.of(1), BlockStateProvider.simple(Blocks.BIG_DRIPLEAF.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pFacingDirection)))), Redirectionor.UP, BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, true));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static Holder<PlacedFeature> makeSmallDripleaf() {
        return PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.FACING, Redirectionor.EAST), 1)
                .add(Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.FACING, Redirectionor.WEST), 1)
                .add(Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.FACING, Redirectionor.NORTH), 1)
                .add(Blocks.SMALL_DRIPLEAF.defaultBlockState().setValue(SmallDripleafBlock.FACING, Redirectionor.SOUTH), 1))));
    }
}
