package com.teampotato.redirectionor.mixin.data;

import com.google.gson.JsonElement;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.*;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;


@Mixin(value = BlockModelProvider.class, priority = 10)
public abstract class BlockModelProviderMixin {
    @Shadow protected abstract void createSimpleFlatItemModel(Item pFlatItem);
    @Shadow @Final private Consumer<IFinishedBlockState> blockStateOutput;
    @Shadow @Final private BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput;
    @Shadow protected abstract void createSimpleFlatItemModel(Block pFlatBlock);
    @Shadow private static BlockStateVariantBuilder createBooleanModelDispatch(BooleanProperty pProperty, ResourceLocation pTrueModelLocation, ResourceLocation pFalseModelLocation) {
        throw new RuntimeException();
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static BlockStateVariantBuilder createFacingDispatch() {
        return BlockStateVariantBuilder.property(BlockStateProperties.FACING)
                .select(Redirectionor.DOWN, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90))
                .select(Redirectionor.UP, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R270))
                .select(Redirectionor.NORTH, BlockModelDefinition.variant())
                .select(Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R90));
    }


    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private BlockStateVariantBuilder createColumnWithFacing() {
        return BlockStateVariantBuilder.property(BlockStateProperties.FACING)
                .select(Redirectionor.DOWN, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R180))
                .select(Redirectionor.UP, BlockModelDefinition.variant())
                .select(Redirectionor.NORTH, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90))
                .select(Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90).with(BlockModelFields.Y_ROT, Redirectionor.R90));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static BlockStateVariantBuilder createHorizontalFacingDispatch() {
        return BlockStateVariantBuilder.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.NORTH, BlockModelDefinition.variant());
    }


    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static IFinishedBlockState createButton(Block pButtonBlock, ResourceLocation pUnpoweredModelLocation, ResourceLocation pPoweredModelLocation) {
        return FinishedVariantBlockState.multiVariant(pButtonBlock).with(BlockStateVariantBuilder.property(BlockStateProperties.POWERED)
                .select(false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pUnpoweredModelLocation))
                .select(true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pPoweredModelLocation))).with(BlockStateVariantBuilder.properties(BlockStateProperties.ATTACH_FACE, BlockStateProperties.HORIZONTAL_FACING)
                .select(AttachFace.FLOOR, Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R90))
                .select(AttachFace.FLOOR, Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R270))
                .select(AttachFace.FLOOR, Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R180))
                .select(AttachFace.FLOOR, Redirectionor.NORTH, BlockModelDefinition.variant())
                .select(AttachFace.WALL, Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R90).with(BlockModelFields.X_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(AttachFace.WALL, Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R270).with(BlockModelFields.X_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(AttachFace.WALL, Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R180).with(BlockModelFields.X_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(AttachFace.WALL, Redirectionor.NORTH, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(AttachFace.CEILING, Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R270).with(BlockModelFields.X_ROT, Redirectionor.R180))
                .select(AttachFace.CEILING, Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R90).with(BlockModelFields.X_ROT, Redirectionor.R180))
                .select(AttachFace.CEILING, Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R180))
                .select(AttachFace.CEILING, Redirectionor.NORTH, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R180).with(BlockModelFields.X_ROT, Redirectionor.R180)));
    }


    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static BlockStateVariantBuilder.Four<Direction, DoubleBlockHalf, DoorHingeSide, Boolean> configureDoorHalf(BlockStateVariantBuilder.Four<Direction, DoubleBlockHalf, DoorHingeSide, Boolean> pDoorProperties, DoubleBlockHalf pDoorHalf, ResourceLocation pDoorModelLocation, ResourceLocation pDoorRightHingeModelLocation) {
        return pDoorProperties
                .select(Redirectionor.EAST, pDoorHalf, Redirectionor.LEFT, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorModelLocation))
                .select(Redirectionor.SOUTH, pDoorHalf, Redirectionor.LEFT, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.WEST, pDoorHalf, Redirectionor.LEFT, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.NORTH, pDoorHalf, Redirectionor.LEFT, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.EAST, pDoorHalf, Redirectionor.RIGHT, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorRightHingeModelLocation))
                .select(Redirectionor.SOUTH, pDoorHalf, Redirectionor.RIGHT, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorRightHingeModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.WEST, pDoorHalf, Redirectionor.RIGHT, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorRightHingeModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.NORTH, pDoorHalf, Redirectionor.RIGHT, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorRightHingeModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.EAST, pDoorHalf, Redirectionor.LEFT, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorRightHingeModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.SOUTH, pDoorHalf, Redirectionor.LEFT, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorRightHingeModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.WEST, pDoorHalf, Redirectionor.LEFT, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorRightHingeModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.NORTH, pDoorHalf, Redirectionor.LEFT, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorRightHingeModelLocation)).select(Direction.EAST, pDoorHalf, Redirectionor.RIGHT, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.SOUTH, pDoorHalf, Redirectionor.RIGHT, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorModelLocation)).select(Direction.WEST, pDoorHalf, Redirectionor.RIGHT, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.NORTH, pDoorHalf, Redirectionor.RIGHT, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pDoorModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static IFinishedBlockState createStairs(Block pStairsBlock, ResourceLocation pInnerModelLocation, ResourceLocation pStraightModelLocation, ResourceLocation pOuterModelLocation) {
        return FinishedVariantBlockState.multiVariant(pStairsBlock).with(BlockStateVariantBuilder.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.STAIRS_SHAPE)
                .select(Redirectionor.EAST, Redirectionor.BOTTOM, Redirectionor.STRAIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pStraightModelLocation))
                .select(Redirectionor.WEST, Redirectionor.BOTTOM, Redirectionor.STRAIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pStraightModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.SOUTH, Redirectionor.BOTTOM, Redirectionor.STRAIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pStraightModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.NORTH, Redirectionor.BOTTOM, Redirectionor.STRAIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pStraightModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.EAST, Redirectionor.BOTTOM, Redirectionor.OUTER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation))
                .select(Redirectionor.WEST, Redirectionor.BOTTOM, Redirectionor.OUTER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.SOUTH, Redirectionor.BOTTOM, Redirectionor.OUTER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.NORTH, Redirectionor.BOTTOM, Redirectionor.OUTER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.EAST, Redirectionor.BOTTOM, Redirectionor.OUTER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.WEST, Redirectionor.BOTTOM, Redirectionor.OUTER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.SOUTH, Redirectionor.BOTTOM, Redirectionor.OUTER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation))
                .select(Redirectionor.NORTH, Redirectionor.BOTTOM, Redirectionor.OUTER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.EAST, Redirectionor.BOTTOM, Redirectionor.INNER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation))
                .select(Redirectionor.WEST, Redirectionor.BOTTOM, Redirectionor.INNER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.SOUTH, Redirectionor.BOTTOM, Redirectionor.INNER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.NORTH, Redirectionor.BOTTOM, Redirectionor.INNER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.EAST, Redirectionor.BOTTOM, Redirectionor.INNER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.WEST, Redirectionor.BOTTOM, Redirectionor.INNER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.SOUTH, Redirectionor.BOTTOM, Redirectionor.INNER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation))
                .select(Redirectionor.NORTH, Redirectionor.BOTTOM, Redirectionor.INNER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.EAST, Redirectionor.TOP, Redirectionor.STRAIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pStraightModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.WEST, Redirectionor.TOP, Redirectionor.STRAIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pStraightModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.SOUTH, Redirectionor.TOP, Redirectionor.STRAIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pStraightModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.NORTH, Redirectionor.TOP, Redirectionor.STRAIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pStraightModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R270).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.EAST, Redirectionor.TOP, Redirectionor.OUTER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.WEST, Redirectionor.TOP, Redirectionor.OUTER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R270).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.SOUTH, Redirectionor.TOP, Redirectionor.OUTER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.NORTH, Redirectionor.TOP, Redirectionor.OUTER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.EAST, Redirectionor.TOP, Redirectionor.OUTER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.WEST, Redirectionor.TOP, Redirectionor.OUTER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.SOUTH, Redirectionor.TOP, Redirectionor.OUTER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.NORTH, Redirectionor.TOP, Redirectionor.OUTER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOuterModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R270).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.EAST, Redirectionor.TOP, Redirectionor.INNER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.WEST, Redirectionor.TOP, Redirectionor.INNER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R270).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.SOUTH, Redirectionor.TOP, Redirectionor.INNER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.NORTH, Redirectionor.TOP, Redirectionor.INNER_RIGHT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.EAST, Redirectionor.TOP, Redirectionor.INNER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.WEST, Redirectionor.TOP, Redirectionor.INNER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R180).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.SOUTH, Redirectionor.TOP, Redirectionor.INNER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R90).with(BlockModelFields.UV_LOCK, true))
                .select(Redirectionor.NORTH, Redirectionor.TOP, Redirectionor.INNER_LEFT, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pInnerModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R270).with(BlockModelFields.UV_LOCK, true)));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static IFinishedBlockState createOrientableTrapdoor(Block pOrientableTrapdoorBlock, ResourceLocation pTopModelLocation, ResourceLocation pBottomModelLocation, ResourceLocation pOpenModelLocation) {
        return FinishedVariantBlockState.multiVariant(pOrientableTrapdoorBlock).with(BlockStateVariantBuilder.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.OPEN)
                .select(Redirectionor.NORTH, Redirectionor.BOTTOM, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pBottomModelLocation))
                .select(Redirectionor.SOUTH, Redirectionor.BOTTOM, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pBottomModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.EAST, Redirectionor.BOTTOM, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pBottomModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.WEST, Redirectionor.BOTTOM, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pBottomModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.NORTH, Redirectionor.TOP, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pTopModelLocation))
                .select(Redirectionor.SOUTH, Redirectionor.TOP, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pTopModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.EAST, Redirectionor.TOP, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pTopModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.WEST, Redirectionor.TOP, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pTopModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.NORTH, Redirectionor.BOTTOM, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation))
                .select(Redirectionor.SOUTH, Redirectionor.BOTTOM, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.EAST, Redirectionor.BOTTOM, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.WEST, Redirectionor.BOTTOM, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.NORTH, Redirectionor.TOP, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.SOUTH, Redirectionor.TOP, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R0))
                .select(Redirectionor.EAST, Redirectionor.TOP, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.WEST, Redirectionor.TOP, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation).with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R90)));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private static IFinishedBlockState createTrapdoor(Block pTrapdoorBlock, ResourceLocation pTopModelLocation, ResourceLocation pBottomModelLocation, ResourceLocation pOpenModelLocation) {
        return FinishedVariantBlockState.multiVariant(pTrapdoorBlock).with(BlockStateVariantBuilder.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.OPEN)
                .select(Redirectionor.NORTH, Redirectionor.BOTTOM, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pBottomModelLocation))
                .select(Redirectionor.SOUTH, Redirectionor.BOTTOM, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pBottomModelLocation))
                .select(Redirectionor.EAST, Redirectionor.BOTTOM, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pBottomModelLocation))
                .select(Redirectionor.WEST, Redirectionor.BOTTOM, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pBottomModelLocation))
                .select(Redirectionor.NORTH, Redirectionor.TOP, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pTopModelLocation))
                .select(Redirectionor.SOUTH, Redirectionor.TOP, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pTopModelLocation))
                .select(Redirectionor.EAST, Redirectionor.TOP, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pTopModelLocation))
                .select(Redirectionor.WEST, Redirectionor.TOP, false, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pTopModelLocation))
                .select(Redirectionor.NORTH, Redirectionor.BOTTOM, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation))
                .select(Redirectionor.SOUTH, Redirectionor.BOTTOM, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.EAST, Redirectionor.BOTTOM, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.WEST, Redirectionor.BOTTOM, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                .select(Redirectionor.NORTH, Redirectionor.TOP, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation))
                .select(Redirectionor.SOUTH, Redirectionor.TOP, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                .select(Redirectionor.EAST, Redirectionor.TOP, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                .select(Redirectionor.WEST, Redirectionor.TOP, true, BlockModelDefinition.variant().with(BlockModelFields.MODEL, pOpenModelLocation).with(BlockModelFields.Y_ROT, Redirectionor.R270)));
    }


    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void createStems(Block pUnattachedStemBlock, Block pAttachedStemBlock) {
        this.createSimpleFlatItemModel(pUnattachedStemBlock.asItem());
        ModelTextures modeltextures = ModelTextures.stem(pUnattachedStemBlock);
        ModelTextures modeltextures1 = ModelTextures.attachedStem(pUnattachedStemBlock, pAttachedStemBlock);
        ResourceLocation resourcelocation = StockModelShapes.ATTACHED_STEM.create(pAttachedStemBlock, modeltextures1, this.modelOutput);
        this.blockStateOutput.accept(
                FinishedVariantBlockState.multiVariant(pAttachedStemBlock, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation)).with(BlockStateVariantBuilder.property(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Redirectionor.WEST, BlockModelDefinition.variant())
                        .select(Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.NORTH, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R180))));
        this.blockStateOutput.accept(FinishedVariantBlockState.multiVariant(pUnattachedStemBlock).with(BlockStateVariantBuilder.property(BlockStateProperties.AGE_7).generate((p_239881_3_) -> BlockModelDefinition.variant().with(BlockModelFields.MODEL, StockModelShapes.STEMS[p_239881_3_].create(pUnattachedStemBlock, modeltextures, this.modelOutput)))));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void createBell() {
        ResourceLocation resourcelocation = ModelsResourceUtil.getModelLocation(Blocks.BELL, "_floor");
        ResourceLocation resourcelocation1 = ModelsResourceUtil.getModelLocation(Blocks.BELL, "_ceiling");
        ResourceLocation resourcelocation2 = ModelsResourceUtil.getModelLocation(Blocks.BELL, "_wall");
        ResourceLocation resourcelocation3 = ModelsResourceUtil.getModelLocation(Blocks.BELL, "_between_walls");
        this.createSimpleFlatItemModel(Items.BELL);
        this.blockStateOutput.accept(
                FinishedVariantBlockState.multiVariant(Blocks.BELL).with(BlockStateVariantBuilder.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.BELL_ATTACHMENT)
                        .select(Redirectionor.NORTH, BellAttachment.FLOOR, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation))
                        .select(Redirectionor.SOUTH, BellAttachment.FLOOR, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                        .select(Redirectionor.EAST, BellAttachment.FLOOR, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.WEST, BellAttachment.FLOOR, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.NORTH, BellAttachment.CEILING, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation1))
                        .select(Redirectionor.SOUTH, BellAttachment.CEILING, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation1).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                        .select(Redirectionor.EAST, BellAttachment.CEILING, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation1).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.WEST, BellAttachment.CEILING, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation1).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.NORTH, BellAttachment.SINGLE_WALL, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation2).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.SOUTH, BellAttachment.SINGLE_WALL, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation2).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.EAST, BellAttachment.SINGLE_WALL, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation2))
                        .select(Redirectionor.WEST, BellAttachment.SINGLE_WALL, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation2).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                        .select(Redirectionor.SOUTH, BellAttachment.DOUBLE_WALL, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation3).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.NORTH, BellAttachment.DOUBLE_WALL, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation3).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                        .select(Redirectionor.EAST, BellAttachment.DOUBLE_WALL, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation3))
                        .select(Redirectionor.WEST, BellAttachment.DOUBLE_WALL, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation3).with(BlockModelFields.Y_ROT, Redirectionor.R180))));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void createGrindstone() {
        this.blockStateOutput.accept(
                FinishedVariantBlockState.multiVariant(Blocks.GRINDSTONE, BlockModelDefinition.variant().with(BlockModelFields.MODEL, ModelsResourceUtil.getModelLocation(Blocks.GRINDSTONE))).with(BlockStateVariantBuilder.properties(BlockStateProperties.ATTACH_FACE, BlockStateProperties.HORIZONTAL_FACING)
                        .select(AttachFace.FLOOR, Redirectionor.NORTH, BlockModelDefinition.variant())
                        .select(AttachFace.FLOOR, Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R90))
                        .select(AttachFace.FLOOR, Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R180))
                        .select(AttachFace.FLOOR, Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R270))
                        .select(AttachFace.WALL, Redirectionor.NORTH, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90))
                        .select(AttachFace.WALL, Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                        .select(AttachFace.WALL, Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                        .select(AttachFace.WALL, Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                        .select(AttachFace.CEILING, Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R180))
                        .select(AttachFace.CEILING, Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                        .select(AttachFace.CEILING, Redirectionor.NORTH, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                        .select(AttachFace.CEILING, Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R270))));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void createDispenserBlock(Block pDispenserBlock) {
        ModelTextures modeltextures = (new ModelTextures()).put(StockTextureAliases.TOP, ModelTextures.getBlockTexture(Blocks.FURNACE, "_top")).put(StockTextureAliases.SIDE, ModelTextures.getBlockTexture(Blocks.FURNACE, "_side")).put(StockTextureAliases.FRONT, ModelTextures.getBlockTexture(pDispenserBlock, "_front"));
        ModelTextures modeltextures1 = (new ModelTextures()).put(StockTextureAliases.SIDE, ModelTextures.getBlockTexture(Blocks.FURNACE, "_top")).put(StockTextureAliases.FRONT, ModelTextures.getBlockTexture(pDispenserBlock, "_front_vertical"));
        ResourceLocation resourcelocation = StockModelShapes.CUBE_ORIENTABLE.create(pDispenserBlock, modeltextures, this.modelOutput);
        ResourceLocation resourcelocation1 = StockModelShapes.CUBE_ORIENTABLE_VERTICAL.create(pDispenserBlock, modeltextures1, this.modelOutput);
        this.blockStateOutput.accept(
                FinishedVariantBlockState.multiVariant(pDispenserBlock).with(BlockStateVariantBuilder.property(BlockStateProperties.FACING)
                        .select(Redirectionor.DOWN, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation1).with(BlockModelFields.X_ROT, Redirectionor.R180))
                        .select(Redirectionor.UP, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation1)).select(Direction.NORTH, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation))
                        .select(Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                        .select(Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation).with(BlockModelFields.Y_ROT, Redirectionor.R270))));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void createHopper() {
        ResourceLocation resourcelocation = ModelsResourceUtil.getModelLocation(Blocks.HOPPER);
        ResourceLocation resourcelocation1 = ModelsResourceUtil.getModelLocation(Blocks.HOPPER, "_side");
        this.createSimpleFlatItemModel(Items.HOPPER);
        this.blockStateOutput.accept(
                FinishedVariantBlockState.multiVariant(Blocks.HOPPER).with(BlockStateVariantBuilder.property(BlockStateProperties.FACING_HOPPER)
                        .select(Redirectionor.DOWN, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation))
                        .select(Redirectionor.NORTH, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation1))
                        .select(Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation1).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                        .select(Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation1).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                        .select(Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.MODEL, resourcelocation1).with(BlockModelFields.Y_ROT, Redirectionor.R270))));
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void createLever() {
        ResourceLocation resourcelocation = ModelsResourceUtil.getModelLocation(Blocks.LEVER);
        ResourceLocation resourcelocation1 = ModelsResourceUtil.getModelLocation(Blocks.LEVER, "_on");
        this.createSimpleFlatItemModel(Blocks.LEVER);
        this.blockStateOutput.accept(
                FinishedVariantBlockState.multiVariant(Blocks.LEVER).with(createBooleanModelDispatch(BlockStateProperties.POWERED, resourcelocation, resourcelocation1)).with(BlockStateVariantBuilder.properties(BlockStateProperties.ATTACH_FACE, BlockStateProperties.HORIZONTAL_FACING)
                        .select(AttachFace.CEILING, Redirectionor.NORTH, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                        .select(AttachFace.CEILING, Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R270))
                        .select(AttachFace.CEILING, Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R180))
                        .select(AttachFace.CEILING, Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R180).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                        .select(AttachFace.FLOOR, Redirectionor.NORTH, BlockModelDefinition.variant()).select(AttachFace.FLOOR, Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R90))
                        .select(AttachFace.FLOOR, Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R180))
                        .select(AttachFace.FLOOR, Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.Y_ROT, Redirectionor.R270))
                        .select(AttachFace.WALL, Redirectionor.NORTH, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90))
                        .select(AttachFace.WALL, Redirectionor.EAST, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90).with(BlockModelFields.Y_ROT, Redirectionor.R90))
                        .select(AttachFace.WALL, Redirectionor.SOUTH, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90).with(BlockModelFields.Y_ROT, Redirectionor.R180))
                        .select(AttachFace.WALL, Redirectionor.WEST, BlockModelDefinition.variant().with(BlockModelFields.X_ROT, Redirectionor.R90).with(BlockModelFields.Y_ROT, Redirectionor.R270))));
    }
}
