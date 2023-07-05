package com.teampotato.redirectionor.mixin.minecraft.data.models;

import com.google.gson.JsonElement;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Mixin(value = BlockModelGenerators.class, priority = 10)
public abstract class MixinBlockModelGenerators {
    @Shadow protected abstract void createSimpleFlatItemModel(Block pFlatBlock);
    @Shadow abstract void createSimpleFlatItemModel(Item pFlatItem);
    @Shadow @Final Consumer<BlockStateGenerator> blockStateOutput;
    @Shadow @Final BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput;
    @Shadow
    private static PropertyDispatch createBooleanModelDispatch(BooleanProperty pProperty, ResourceLocation pTrueModelLocation, ResourceLocation pFalseModelLocation) {
        throw new RuntimeException();
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static PropertyDispatch createHorizontalFacingDispatch() {
        return PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Redirectionor.EAST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.WEST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.NORTH, Variant.variant());
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static PropertyDispatch createHorizontalFacingDispatchAlt() {
        return PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Redirectionor.SOUTH, Variant.variant())
                .select(Redirectionor.WEST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.NORTH, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.EAST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R270));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static PropertyDispatch createTorchHorizontalDispatch() {
        return PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Redirectionor.EAST, Variant.variant())
                .select(Redirectionor.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.WEST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.NORTH, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R270));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static PropertyDispatch createFacingDispatch() {
        return PropertyDispatch.property(BlockStateProperties.FACING)
                .select(Redirectionor.DOWN, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R90))
                .select(Redirectionor.UP, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R270))
                .select(Redirectionor.NORTH, Variant.variant()).select(Direction.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.WEST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.EAST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R90));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    static BlockStateGenerator createButton(Block pButtonBlock, ResourceLocation pUnpoweredModelLocation, ResourceLocation pPoweredModelLocation) {
        return MultiVariantGenerator.multiVariant(pButtonBlock).with(PropertyDispatch.property(BlockStateProperties.POWERED)
                .select(false, Variant.variant().with(VariantProperties.MODEL, pUnpoweredModelLocation))
                .select(true, Variant.variant().with(VariantProperties.MODEL, pPoweredModelLocation))).with(PropertyDispatch.properties(BlockStateProperties.ATTACH_FACE, BlockStateProperties.HORIZONTAL_FACING)
                .select(  Redirectionor.FLOOR_FACE, Redirectionor.EAST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R90))
                .select(  Redirectionor.FLOOR_FACE, Redirectionor.WEST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R270))
                .select(  Redirectionor.FLOOR_FACE, Redirectionor.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(  Redirectionor.FLOOR_FACE, Redirectionor.NORTH, Variant.variant())
                .select(   Redirectionor.WALL_FACE, Redirectionor.EAST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R90).with(VariantProperties.X_ROT, Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                .select(   Redirectionor.WALL_FACE, Redirectionor.WEST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R270).with(VariantProperties.X_ROT, Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                .select(   Redirectionor.WALL_FACE, Redirectionor.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R180).with(VariantProperties.X_ROT, Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                .select(   Redirectionor.WALL_FACE, Redirectionor.NORTH, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                .select(Redirectionor.CEILING_FACE, Redirectionor.EAST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R270).with(VariantProperties.X_ROT, Redirectionor.R180))
                .select(Redirectionor.CEILING_FACE, Redirectionor.WEST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R90).with(VariantProperties.X_ROT, Redirectionor.R180))
                .select(Redirectionor.CEILING_FACE, Redirectionor.SOUTH, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R180))
                .select(Redirectionor.CEILING_FACE, Redirectionor.NORTH, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R180).with(VariantProperties.X_ROT, Redirectionor.R180)));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static PropertyDispatch.C4<Direction, DoubleBlockHalf, DoorHingeSide, Boolean> configureDoorHalf(PropertyDispatch.C4<Direction, DoubleBlockHalf, DoorHingeSide, Boolean> p_236305_, DoubleBlockHalf p_236306_, ResourceLocation p_236307_, ResourceLocation p_236308_, ResourceLocation p_236309_, ResourceLocation p_236310_) {
        return p_236305_
                .select(Redirectionor.EAST, p_236306_, Redirectionor.LEFT, false, Variant.variant().with(VariantProperties.MODEL, p_236307_))
                .select(Redirectionor.SOUTH, p_236306_, Redirectionor.LEFT, false, Variant.variant().with(VariantProperties.MODEL, p_236307_).with(VariantProperties.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.WEST, p_236306_, Redirectionor.LEFT, false, Variant.variant().with(VariantProperties.MODEL, p_236307_).with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.NORTH, p_236306_, Redirectionor.LEFT, false, Variant.variant().with(VariantProperties.MODEL, p_236307_).with(VariantProperties.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.EAST, p_236306_, Redirectionor.RIGHT, false, Variant.variant().with(VariantProperties.MODEL, p_236309_))
                .select(Redirectionor.SOUTH, p_236306_, Redirectionor.RIGHT, false, Variant.variant().with(VariantProperties.MODEL, p_236309_).with(VariantProperties.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.WEST, p_236306_, Redirectionor.RIGHT, false, Variant.variant().with(VariantProperties.MODEL, p_236309_).with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.NORTH, p_236306_, Redirectionor.RIGHT, false, Variant.variant().with(VariantProperties.MODEL, p_236309_).with(VariantProperties.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.EAST, p_236306_, Redirectionor.LEFT, true, Variant.variant().with(VariantProperties.MODEL, p_236308_).with(VariantProperties.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.SOUTH, p_236306_, Redirectionor.LEFT, true, Variant.variant().with(VariantProperties.MODEL, p_236308_).with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.WEST, p_236306_, Redirectionor.LEFT, true, Variant.variant().with(VariantProperties.MODEL, p_236308_).with(VariantProperties.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.NORTH, p_236306_, Redirectionor.LEFT, true, Variant.variant().with(VariantProperties.MODEL, p_236308_))
                .select(Redirectionor.EAST, p_236306_, Redirectionor.RIGHT, true, Variant.variant().with(VariantProperties.MODEL, p_236310_).with(VariantProperties.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.SOUTH, p_236306_, Redirectionor.RIGHT, true, Variant.variant().with(VariantProperties.MODEL, p_236310_))
                .select(Redirectionor.WEST, p_236306_, Redirectionor.RIGHT, true, Variant.variant().with(VariantProperties.MODEL, p_236310_).with(VariantProperties.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.NORTH, p_236306_, Redirectionor.RIGHT, true, Variant.variant().with(VariantProperties.MODEL, p_236310_).with(VariantProperties.Y_ROT, Redirectionor.R180));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    static BlockStateGenerator createStairs(Block pStairsBlock, ResourceLocation pInnerModelLocation, ResourceLocation pStraightModelLocation, ResourceLocation pOuterModelLocation) {
        return MultiVariantGenerator.multiVariant(pStairsBlock)
                .with(PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.STAIRS_SHAPE)
                        .select(Redirectionor.EAST, Redirectionor.BOTTOM, Redirectionor.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, pStraightModelLocation))
                        .select(Redirectionor.WEST, Redirectionor.BOTTOM, Redirectionor.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, pStraightModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.SOUTH, Redirectionor.BOTTOM,Redirectionor.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, pStraightModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.NORTH,Redirectionor.BOTTOM, Redirectionor.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, pStraightModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R270).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.EAST, Redirectionor.BOTTOM, Redirectionor.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation))
                        .select(Redirectionor.WEST, Redirectionor.BOTTOM, Redirectionor.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.SOUTH,Redirectionor.BOTTOM, Redirectionor.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.NORTH,Redirectionor.BOTTOM, Redirectionor.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R270).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.EAST, Redirectionor.BOTTOM, Redirectionor.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.Y_ROT,  Redirectionor.R270).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.WEST, Redirectionor.BOTTOM, Redirectionor.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.Y_ROT,  Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.SOUTH,Redirectionor.BOTTOM, Redirectionor.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation))
                        .select(Redirectionor.NORTH,Redirectionor.BOTTOM, Redirectionor.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.Y_ROT,  Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.EAST, Redirectionor.BOTTOM, Redirectionor.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation))
                        .select(Redirectionor.WEST, Redirectionor.BOTTOM, Redirectionor.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.SOUTH,Redirectionor.BOTTOM, Redirectionor.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.NORTH,Redirectionor.BOTTOM, Redirectionor.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R270).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.EAST, Redirectionor.BOTTOM, Redirectionor.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.Y_ROT,  Redirectionor.R270).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.WEST, Redirectionor.BOTTOM, Redirectionor.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.Y_ROT,  Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.SOUTH,Redirectionor.BOTTOM, Redirectionor.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation))
                        .select(Redirectionor.NORTH,Redirectionor.BOTTOM, Redirectionor.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.Y_ROT,  Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.EAST, Redirectionor.TOP, Redirectionor.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, pStraightModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.WEST, Redirectionor.TOP, Redirectionor.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, pStraightModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.SOUTH,Redirectionor.TOP, Redirectionor.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, pStraightModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.NORTH,Redirectionor.TOP, Redirectionor.STRAIGHT, Variant.variant().with(VariantProperties.MODEL, pStraightModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R270).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.EAST, Redirectionor.TOP, Redirectionor.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.WEST, Redirectionor.TOP, Redirectionor.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R270).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.SOUTH,Redirectionor.TOP, Redirectionor.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.NORTH,Redirectionor.TOP, Redirectionor.OUTER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.EAST, Redirectionor.TOP, Redirectionor.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.X_ROT,  Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.WEST, Redirectionor.TOP, Redirectionor.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.X_ROT,  Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.SOUTH,Redirectionor.TOP, Redirectionor.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.X_ROT,  Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.NORTH,Redirectionor.TOP, Redirectionor.OUTER_LEFT, Variant.variant().with(VariantProperties.MODEL, pOuterModelLocation).with(VariantProperties.X_ROT,  Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R270).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.EAST, Redirectionor.TOP, Redirectionor.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.WEST, Redirectionor.TOP, Redirectionor.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R270).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.SOUTH,Redirectionor.TOP, Redirectionor.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.NORTH,Redirectionor.TOP, Redirectionor.INNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.EAST, Redirectionor.TOP, Redirectionor.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.X_ROT,  Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.WEST, Redirectionor.TOP, Redirectionor.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.X_ROT,  Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R180).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.SOUTH,Redirectionor.TOP, Redirectionor.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.X_ROT,  Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R90).with(VariantProperties.UV_LOCK, true))
                        .select(Redirectionor.NORTH,Redirectionor.TOP, Redirectionor.INNER_LEFT, Variant.variant().with(VariantProperties.MODEL, pInnerModelLocation).with(VariantProperties.X_ROT,  Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R270).with(VariantProperties.UV_LOCK, true)));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static BlockStateGenerator createOrientableTrapdoor(Block pOrientableTrapdoorBlock, ResourceLocation pTopModelLocation, ResourceLocation pBottomModelLocation, ResourceLocation pOpenModelLocation) {
        return MultiVariantGenerator
                .multiVariant(pOrientableTrapdoorBlock)
                .with(PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.OPEN)
                        .select(Redirectionor.NORTH, Redirectionor.BOTTOM, false, Variant.variant().with(VariantProperties.MODEL, pBottomModelLocation))
                        .select(Redirectionor.SOUTH, Redirectionor.BOTTOM, false, Variant.variant().with(VariantProperties.MODEL, pBottomModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R180))
                        .select(Redirectionor.EAST,  Redirectionor.BOTTOM, false, Variant.variant().with(VariantProperties.MODEL, pBottomModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.WEST,  Redirectionor.BOTTOM, false, Variant.variant().with(VariantProperties.MODEL, pBottomModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.NORTH, Redirectionor.TOP, false, Variant.variant().with(VariantProperties.MODEL, pTopModelLocation))
                        .select(Redirectionor.SOUTH, Redirectionor.TOP, false, Variant.variant().with(VariantProperties.MODEL, pTopModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R180))
                        .select(Redirectionor.EAST,  Redirectionor.TOP, false, Variant.variant().with(VariantProperties.MODEL, pTopModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.WEST,  Redirectionor.TOP, false, Variant.variant().with(VariantProperties.MODEL, pTopModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.NORTH, Redirectionor.BOTTOM, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation))
                        .select(Redirectionor.SOUTH, Redirectionor.BOTTOM, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R180))
                        .select(Redirectionor.EAST,  Redirectionor.BOTTOM, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.WEST,  Redirectionor.BOTTOM, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.NORTH, Redirectionor.TOP, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R180))
                        .select(Redirectionor.SOUTH, Redirectionor.TOP, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R0))
                        .select(Redirectionor.EAST,  Redirectionor.TOP, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.WEST,  Redirectionor.TOP, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation).with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R90)));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static BlockStateGenerator createTrapdoor(Block pTrapdoorBlock, ResourceLocation pTopModelLocation, ResourceLocation pBottomModelLocation, ResourceLocation pOpenModelLocation) {
        return MultiVariantGenerator
                .multiVariant(pTrapdoorBlock)
                .with(PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.OPEN)
                        .select(Redirectionor.NORTH, Redirectionor.BOTTOM, false, Variant.variant().with(VariantProperties.MODEL, pBottomModelLocation))
                        .select(Redirectionor.SOUTH, Redirectionor.BOTTOM, false, Variant.variant().with(VariantProperties.MODEL, pBottomModelLocation))
                        .select(Redirectionor.EAST,  Redirectionor.BOTTOM, false, Variant.variant().with(VariantProperties.MODEL, pBottomModelLocation))
                        .select(Redirectionor.WEST,  Redirectionor.BOTTOM, false, Variant.variant().with(VariantProperties.MODEL, pBottomModelLocation))
                        .select(Redirectionor.NORTH, Redirectionor.TOP, false, Variant.variant().with(VariantProperties.MODEL, pTopModelLocation))
                        .select(Redirectionor.SOUTH, Redirectionor.TOP, false, Variant.variant().with(VariantProperties.MODEL, pTopModelLocation))
                        .select(Redirectionor.EAST,  Redirectionor.TOP, false, Variant.variant().with(VariantProperties.MODEL, pTopModelLocation))
                        .select(Redirectionor.WEST,  Redirectionor.TOP, false, Variant.variant().with(VariantProperties.MODEL, pTopModelLocation))
                        .select(Redirectionor.NORTH, Redirectionor.BOTTOM, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation))
                        .select(Redirectionor.SOUTH, Redirectionor.BOTTOM, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R180))
                        .select(Redirectionor.EAST,  Redirectionor.BOTTOM, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.WEST,  Redirectionor.BOTTOM, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.NORTH, Redirectionor.TOP, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation))
                        .select(Redirectionor.SOUTH, Redirectionor.TOP, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R180))
                        .select(Redirectionor.EAST,  Redirectionor.TOP, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.WEST,  Redirectionor.TOP, true, Variant.variant().with(VariantProperties.MODEL, pOpenModelLocation).with(VariantProperties.Y_ROT, Redirectionor.R270)));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void createStems(Block pUnattachedStemBlock, Block pAttachedStemBlock) {
        this.createSimpleFlatItemModel(pUnattachedStemBlock.asItem());
        this.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(pAttachedStemBlock, Variant.variant().with(VariantProperties.MODEL, ModelTemplates.ATTACHED_STEM.create(pAttachedStemBlock, TextureMapping.attachedStem(pUnattachedStemBlock, pAttachedStemBlock), this.modelOutput))).with(PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Redirectionor.WEST, Variant.variant())
                        .select(Redirectionor.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.NORTH, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.EAST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R180))));
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(pUnattachedStemBlock).with(PropertyDispatch.property(BlockStateProperties.AGE_7).generate((p_176108_) -> Variant.variant().with(VariantProperties.MODEL, ModelTemplates.STEMS[p_176108_].create(pUnattachedStemBlock, TextureMapping.stem(pUnattachedStemBlock), this.modelOutput)))));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private PropertyDispatch createColumnWithFacing() {
        return PropertyDispatch.property(BlockStateProperties.FACING)
                .select(Redirectionor.DOWN, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R180))
                .select(Redirectionor.UP, Variant.variant())
                .select(Redirectionor.NORTH, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R90))
                .select(Redirectionor.SOUTH, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R90).with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.WEST, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R90).with(VariantProperties.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.EAST, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R90).with(VariantProperties.Y_ROT, Redirectionor.R90));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void createBell() {
        ResourceLocation resourcelocation = ModelLocationUtils.getModelLocation(Blocks.BELL, "_floor");
        ResourceLocation resourcelocation1 = ModelLocationUtils.getModelLocation(Blocks.BELL, "_ceiling");
        ResourceLocation resourcelocation2 = ModelLocationUtils.getModelLocation(Blocks.BELL, "_wall");
        ResourceLocation resourcelocation3 = ModelLocationUtils.getModelLocation(Blocks.BELL, "_between_walls");
        this.createSimpleFlatItemModel(Items.BELL);
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(Blocks.BELL).with(PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.BELL_ATTACHMENT)
                        .select(Redirectionor.NORTH,       Redirectionor.FLOOR_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation))
                        .select(Redirectionor.SOUTH,       Redirectionor.FLOOR_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation).with(VariantProperties.Y_ROT,  Redirectionor.R180))
                        .select(Redirectionor.EAST,        Redirectionor.FLOOR_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation).with(VariantProperties.Y_ROT,  Redirectionor.R90))
                        .select(Redirectionor.WEST,        Redirectionor.FLOOR_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation).with(VariantProperties.Y_ROT,  Redirectionor.R270))
                        .select(Redirectionor.NORTH,     Redirectionor.CEILING_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation1))
                        .select(Redirectionor.SOUTH,     Redirectionor.CEILING_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation1).with(VariantProperties.Y_ROT, Redirectionor.R180))
                        .select(Redirectionor.EAST,      Redirectionor.CEILING_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation1).with(VariantProperties.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.WEST,      Redirectionor.CEILING_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation1).with(VariantProperties.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.NORTH, Redirectionor.SINGLE_WALL_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation2).with(VariantProperties.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.SOUTH, Redirectionor.SINGLE_WALL_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation2).with(VariantProperties.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.EAST,  Redirectionor.SINGLE_WALL_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation2))
                        .select(Redirectionor.WEST,  Redirectionor.SINGLE_WALL_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation2).with(VariantProperties.Y_ROT, Redirectionor.R180))
                        .select(Redirectionor.SOUTH, Redirectionor.DOUBLE_WALL_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation3).with(VariantProperties.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.NORTH, Redirectionor.DOUBLE_WALL_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation3).with(VariantProperties.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.EAST,  Redirectionor.DOUBLE_WALL_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation3))
                        .select(Redirectionor.WEST,  Redirectionor.DOUBLE_WALL_TYPE, Variant.variant().with(VariantProperties.MODEL, resourcelocation3).with(VariantProperties.Y_ROT, Redirectionor.R180))));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void createGrindstone() {
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(Blocks.GRINDSTONE, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(Blocks.GRINDSTONE))).with(PropertyDispatch.properties(BlockStateProperties.ATTACH_FACE, BlockStateProperties.HORIZONTAL_FACING)
                .select(  Redirectionor.FLOOR_FACE, Redirectionor.NORTH, Variant.variant())
                .select(  Redirectionor.FLOOR_FACE, Redirectionor.EAST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R90))
                .select(  Redirectionor.FLOOR_FACE, Redirectionor.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(  Redirectionor.FLOOR_FACE, Redirectionor.WEST, Variant.variant().with(VariantProperties.Y_ROT,  Redirectionor.R270))
                .select(   Redirectionor.WALL_FACE, Redirectionor.NORTH, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R90))
                .select(   Redirectionor.WALL_FACE, Redirectionor.EAST, Variant.variant().with(VariantProperties.X_ROT,  Redirectionor.R90).with(VariantProperties.Y_ROT,  Redirectionor.R90))
                .select(   Redirectionor.WALL_FACE, Redirectionor.SOUTH, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R90).with(VariantProperties.Y_ROT,  Redirectionor.R180))
                .select(   Redirectionor.WALL_FACE, Redirectionor.WEST, Variant.variant().with(VariantProperties.X_ROT,  Redirectionor.R90).with(VariantProperties.Y_ROT,  Redirectionor.R270))
                .select(Redirectionor.CEILING_FACE, Redirectionor.SOUTH, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R180))
                .select(Redirectionor.CEILING_FACE, Redirectionor.WEST, Variant.variant().with(VariantProperties.X_ROT,  Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.CEILING_FACE, Redirectionor.NORTH, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.CEILING_FACE, Redirectionor.EAST, Variant.variant().with(VariantProperties.X_ROT,  Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R270))));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void createDispenserBlock(Block pDispenserBlock) {
        ResourceLocation resourcelocation = ModelTemplates.CUBE_ORIENTABLE.create(pDispenserBlock, (new TextureMapping()).put(TextureSlot.TOP, TextureMapping.getBlockTexture(Blocks.FURNACE, "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(Blocks.FURNACE, "_side")).put(TextureSlot.FRONT, TextureMapping.getBlockTexture(pDispenserBlock, "_front")), this.modelOutput);
        ResourceLocation resourcelocation1 = ModelTemplates.CUBE_ORIENTABLE_VERTICAL.create(pDispenserBlock, (new TextureMapping()).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(Blocks.FURNACE, "_top")).put(TextureSlot.FRONT, TextureMapping.getBlockTexture(pDispenserBlock, "_front_vertical")), this.modelOutput);

        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(pDispenserBlock).with(PropertyDispatch.property(BlockStateProperties.FACING)
                .select(Redirectionor.DOWN, Variant.variant().with(VariantProperties.MODEL, resourcelocation1).with(VariantProperties.X_ROT, Redirectionor.R180))
                .select(Redirectionor.UP, Variant.variant().with(VariantProperties.MODEL, resourcelocation1))
                .select(Redirectionor.NORTH, Variant.variant().with(VariantProperties.MODEL, resourcelocation))
                .select(Redirectionor.EAST, Variant.variant().with(VariantProperties.MODEL, resourcelocation).with(VariantProperties.Y_ROT,  Redirectionor.R90))
                .select(Redirectionor.SOUTH, Variant.variant().with(VariantProperties.MODEL, resourcelocation).with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.WEST, Variant.variant().with(VariantProperties.MODEL, resourcelocation).with(VariantProperties.Y_ROT,  Redirectionor.R270))));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void createHopper() {
        ResourceLocation resourcelocation = ModelLocationUtils.getModelLocation(Blocks.HOPPER, "_side");
        this.createSimpleFlatItemModel(Items.HOPPER);
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(Blocks.HOPPER).with(PropertyDispatch.property(BlockStateProperties.FACING_HOPPER)
                .select(Redirectionor.DOWN, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(Blocks.HOPPER)))
                .select(Redirectionor.NORTH, Variant.variant().with(VariantProperties.MODEL, resourcelocation))
                .select(Redirectionor.EAST, Variant.variant().with(VariantProperties.MODEL, resourcelocation).with(VariantProperties.Y_ROT,  Redirectionor.R90))
                .select(Redirectionor.SOUTH, Variant.variant().with(VariantProperties.MODEL, resourcelocation).with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.WEST, Variant.variant().with(VariantProperties.MODEL, resourcelocation).with(VariantProperties.Y_ROT,  Redirectionor.R270))));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void createLever() {
        this.createSimpleFlatItemModel(Blocks.LEVER);
        this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(Blocks.LEVER).with(createBooleanModelDispatch(BlockStateProperties.POWERED, ModelLocationUtils.getModelLocation(Blocks.LEVER), ModelLocationUtils.getModelLocation(Blocks.LEVER, "_on"))).with(PropertyDispatch.properties(BlockStateProperties.ATTACH_FACE, BlockStateProperties.HORIZONTAL_FACING)
                .select(Redirectionor.CEILING_FACE, Redirectionor.NORTH, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.CEILING_FACE, Redirectionor.EAST, Variant.variant().with(VariantProperties.X_ROT,  Redirectionor.R180).with(VariantProperties.Y_ROT,  Redirectionor.R270))
                .select(Redirectionor.CEILING_FACE, Redirectionor.SOUTH, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R180))
                .select(Redirectionor.CEILING_FACE, Redirectionor.WEST, Variant.variant().with(VariantProperties.X_ROT,  Redirectionor.R180).with(VariantProperties.Y_ROT, Redirectionor.R90))
                .select(  Redirectionor.FLOOR_FACE, Redirectionor.NORTH, Variant.variant())
                .select(  Redirectionor.FLOOR_FACE, Redirectionor.EAST, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R90))
                .select(  Redirectionor.FLOOR_FACE, Redirectionor.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(  Redirectionor.FLOOR_FACE, Redirectionor.WEST, Variant.variant().with(VariantProperties.Y_ROT,  Redirectionor.R270))
                .select(   Redirectionor.WALL_FACE, Redirectionor.NORTH, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R90))
                .select(   Redirectionor.WALL_FACE, Redirectionor.EAST, Variant.variant().with(VariantProperties.X_ROT,  Redirectionor.R90).with(VariantProperties.Y_ROT,  Redirectionor.R90))
                .select(   Redirectionor.WALL_FACE, Redirectionor.SOUTH, Variant.variant().with(VariantProperties.X_ROT, Redirectionor.R90).with(VariantProperties.Y_ROT, Redirectionor.R180))
                .select(   Redirectionor.WALL_FACE, Redirectionor.WEST, Variant.variant().with(VariantProperties.X_ROT,  Redirectionor.R90).with(VariantProperties.Y_ROT,  Redirectionor.R270))));
    }
}
