package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.google.common.base.Predicates;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EndPortalFrameBlock;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EndPortalFrameBlock.class)
public abstract class MixinEndPortalFrameBlock {
    @Shadow private static BlockPattern portalShape;
    @Shadow @Final public static BooleanProperty HAS_EYE;
    @Shadow @Final public static DirectionProperty FACING;

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public static BlockPattern getOrCreatePortalShape() {
        if (portalShape == null) {
            portalShape = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", ">???<", "?^^^?")
                    .where('?', BlockInWorld.hasState(BlockStatePredicate.ANY))
                    .where('^', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.END_PORTAL_FRAME).where(HAS_EYE, Predicates.equalTo(true)).where(FACING, Predicates.equalTo(Redirectionor.SOUTH))))
                    .where('>', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.END_PORTAL_FRAME).where(HAS_EYE, Predicates.equalTo(true)).where(FACING, Predicates.equalTo(Redirectionor.WEST))))
                    .where('v', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.END_PORTAL_FRAME).where(HAS_EYE, Predicates.equalTo(true)).where(FACING, Predicates.equalTo(Redirectionor.NORTH))))
                    .where('<', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.END_PORTAL_FRAME).where(HAS_EYE, Predicates.equalTo(true)).where(FACING, Predicates.equalTo(Redirectionor.EAST))))
                    .build();
        }

        return portalShape;
    }
}
