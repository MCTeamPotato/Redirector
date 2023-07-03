package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.structure.pools;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.FrontAndTop;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.JigsawBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.pools.FeaturePoolElement;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(FeaturePoolElement.class)
public abstract class MixinFeaturePoolElement {
    @Shadow @Final private CompoundTag defaultJigsawNBT;
    /**
     * @author Kaualix
     * @reason avoid allocation
     */
    @Overwrite
    public List<StructureTemplate.StructureBlockInfo> getShuffledJigsawBlocks(StructureTemplateManager p_227199_, BlockPos p_227200_, Rotation p_227201_, RandomSource p_227202_) {
        return Lists.newArrayList(new StructureTemplate.StructureBlockInfo(
                p_227200_,
                Blocks.JIGSAW.defaultBlockState().setValue(JigsawBlock.ORIENTATION, FrontAndTop.fromFrontAndTop(Direction.DOWN, Direction.SOUTH)),
                this.defaultJigsawNBT
        ));
    }
}
