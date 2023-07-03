package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.structure.templatesystem;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Clearable;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.BitSetDiscreteVoxelShape;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;

import java.util.Iterator;
import java.util.List;

@Mixin(StructureTemplate.class)
public abstract class MixinStructureTemplate {
    @Shadow protected abstract void addEntitiesToWorld(ServerLevelAccessor pServerLevel, BlockPos p_74525_, StructurePlaceSettings placementIn);
    @Shadow @Final private List<StructureTemplate.Palette> palettes;
    @Shadow @Final private List<StructureTemplate.StructureEntityInfo> entityInfoList;
    @Shadow private Vec3i size;
    @Shadow public static List<StructureTemplate.StructureBlockInfo> processBlockInfos(LevelAccessor pLevel, BlockPos p_74519_, BlockPos p_74520_, StructurePlaceSettings pSettings, List<StructureTemplate.StructureBlockInfo> pBlockInfos, @Nullable StructureTemplate template) {
        throw new RuntimeException();
    }
    @Shadow public static void updateShapeAtEdge(LevelAccessor pLevel, int p_74512_, DiscreteVoxelShape pShape, int pX, int pY, int pZ) {
        throw new RuntimeException();
    }

    @Unique
    private static final Direction[] A_DIRECTIONS = new Direction[]{Redirectionor.UP, Redirectionor.NORTH, Redirectionor.EAST, Redirectionor.SOUTH, Redirectionor.WEST};

    /**
     * @author Kaualix
     * @reason avoid allocation
     */
    @Overwrite
    public boolean placeInWorld(ServerLevelAccessor pServerLevel, BlockPos pPos, BlockPos p_230331_, StructurePlaceSettings pSettings, RandomSource pRandom, int pFlags) {
        if (this.palettes.isEmpty()) {
            return false;
        } else {
            List<StructureTemplate.StructureBlockInfo> list = pSettings.getRandomPalette(this.palettes, pPos).blocks();
            if ((!list.isEmpty() || !pSettings.isIgnoreEntities() && !this.entityInfoList.isEmpty()) && this.size.getX() >= 1 && this.size.getY() >= 1 && this.size.getZ() >= 1) {
                BoundingBox boundingbox = pSettings.getBoundingBox();
                List<BlockPos> list1 = Lists.newArrayListWithCapacity(pSettings.shouldKeepLiquids() ? list.size() : 0);
                List<BlockPos> list2 = Lists.newArrayListWithCapacity(pSettings.shouldKeepLiquids() ? list.size() : 0);
                List<Pair<BlockPos, CompoundTag>> list3 = Lists.newArrayListWithCapacity(list.size());
                int i = Integer.MAX_VALUE;
                int j = Integer.MAX_VALUE;
                int k = Integer.MAX_VALUE;
                int l = Integer.MIN_VALUE;
                int i1 = Integer.MIN_VALUE;
                int j1 = Integer.MIN_VALUE;

                for(StructureTemplate.StructureBlockInfo structuretemplate$structureblockinfo : processBlockInfos(pServerLevel, pPos, p_230331_, pSettings, list, (StructureTemplate) (Object)this)) {
                    BlockPos blockpos = structuretemplate$structureblockinfo.pos;
                    if (boundingbox == null || boundingbox.isInside(blockpos)) {
                        FluidState fluidstate = pSettings.shouldKeepLiquids() ? pServerLevel.getFluidState(blockpos) : null;
                        BlockState blockstate = structuretemplate$structureblockinfo.state.mirror(pSettings.getMirror()).rotate(pSettings.getRotation());
                        if (structuretemplate$structureblockinfo.nbt != null) {
                            BlockEntity blockentity = pServerLevel.getBlockEntity(blockpos);
                            Clearable.tryClear(blockentity);
                            pServerLevel.setBlock(blockpos, Blocks.BARRIER.defaultBlockState(), 20);
                        }

                        if (pServerLevel.setBlock(blockpos, blockstate, pFlags)) {
                            i = Math.min(i, blockpos.getX());
                            j = Math.min(j, blockpos.getY());
                            k = Math.min(k, blockpos.getZ());
                            l = Math.max(l, blockpos.getX());
                            i1 = Math.max(i1, blockpos.getY());
                            j1 = Math.max(j1, blockpos.getZ());
                            list3.add(Pair.of(blockpos, structuretemplate$structureblockinfo.nbt));
                            if (structuretemplate$structureblockinfo.nbt != null) {
                                BlockEntity blockentity1 = pServerLevel.getBlockEntity(blockpos);
                                if (blockentity1 != null) {
                                    if (blockentity1 instanceof RandomizableContainerBlockEntity) {
                                        structuretemplate$structureblockinfo.nbt.putLong("LootTableSeed", pRandom.nextLong());
                                    }

                                    blockentity1.load(structuretemplate$structureblockinfo.nbt);
                                }
                            }

                            if (fluidstate != null) {
                                if (blockstate.getFluidState().isSource()) {
                                    list2.add(blockpos);
                                } else if (blockstate.getBlock() instanceof LiquidBlockContainer) {
                                    ((LiquidBlockContainer)blockstate.getBlock()).placeLiquid(pServerLevel, blockpos, blockstate, fluidstate);
                                    if (!fluidstate.isSource()) {
                                        list1.add(blockpos);
                                    }
                                }
                            }
                        }
                    }
                }

                boolean flag = true;
                while(flag && !list1.isEmpty()) {
                    flag = false;
                    Iterator<BlockPos> iterator = list1.iterator();

                    while(iterator.hasNext()) {
                        BlockPos blockpos3 = iterator.next();
                        FluidState fluidstate2 = pServerLevel.getFluidState(blockpos3);

                        for(int i2 = 0; i2 < A_DIRECTIONS.length && !fluidstate2.isSource(); ++i2) {
                            BlockPos blockpos1 = blockpos3.relative(A_DIRECTIONS[i2]);
                            FluidState fluidstate1 = pServerLevel.getFluidState(blockpos1);
                            if (fluidstate1.isSource() && !list2.contains(blockpos1)) {
                                fluidstate2 = fluidstate1;
                            }
                        }

                        if (fluidstate2.isSource()) {
                            BlockState blockstate1 = pServerLevel.getBlockState(blockpos3);
                            Block block = blockstate1.getBlock();
                            if (block instanceof LiquidBlockContainer) {
                                ((LiquidBlockContainer)block).placeLiquid(pServerLevel, blockpos3, blockstate1, fluidstate2);
                                flag = true;
                                iterator.remove();
                            }
                        }
                    }
                }

                if (i <= l) {
                    if (!pSettings.getKnownShape()) {
                        DiscreteVoxelShape discretevoxelshape = new BitSetDiscreteVoxelShape(l - i + 1, i1 - j + 1, j1 - k + 1);

                        for(Pair<BlockPos, CompoundTag> pair1 : list3) {
                            BlockPos blockpos2 = pair1.getFirst();
                            discretevoxelshape.fill(blockpos2.getX() - i, blockpos2.getY() - j, blockpos2.getZ() - k);
                        }

                        updateShapeAtEdge(pServerLevel, pFlags, discretevoxelshape, i, j, k);
                    }

                    for(Pair<BlockPos, CompoundTag> pair : list3) {
                        BlockPos blockpos4 = pair.getFirst();
                        if (!pSettings.getKnownShape()) {
                            BlockState blockstate2 = pServerLevel.getBlockState(blockpos4);
                            BlockState blockstate3 = Block.updateFromNeighbourShapes(blockstate2, pServerLevel, blockpos4);
                            if (blockstate2 != blockstate3) {
                                pServerLevel.setBlock(blockpos4, blockstate3, pFlags & -2 | 16);
                            }

                            pServerLevel.blockUpdated(blockpos4, blockstate3.getBlock());
                        }

                        if (pair.getSecond() != null) {
                            BlockEntity blockentity2 = pServerLevel.getBlockEntity(blockpos4);
                            if (blockentity2 != null) {
                                blockentity2.setChanged();
                            }
                        }
                    }
                }

                if (!pSettings.isIgnoreEntities()) {
                    this.addEntitiesToWorld(pServerLevel, pPos, pSettings);
                }

                return true;
            } else {
                return false;
            }
        }
    }
}
