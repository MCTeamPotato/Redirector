package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.WallSide;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(WallBlock.class)
public abstract class MixinWallBlock {
    @Shadow protected abstract boolean connectsTo(BlockState pState, boolean pSideSolid, Direction pDirection);
    @Shadow protected abstract BlockState updateShape(LevelReader pLevel, BlockState pState, BlockPos pPos, BlockState pNeighbour, boolean pNorthConnection, boolean pEastConnection, boolean pSouthConnection, boolean pWestConnection);
    @Shadow
    private static boolean isConnected(BlockState pState, Property<WallSide> pHeightProperty) {
        throw new RuntimeException();
    }

    @Shadow @Final public static EnumProperty<WallSide> NORTH_WALL;
    @Shadow @Final public static EnumProperty<WallSide> EAST_WALL;
    @Shadow @Final public static EnumProperty<WallSide> SOUTH_WALL;
    @Shadow @Final public static EnumProperty<WallSide> WEST_WALL;

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private BlockState sideUpdate(LevelReader pLevel, BlockPos pFirstPos, BlockState pFirstState, BlockPos pSecondPos, BlockState pSecondState, Direction pDir) {
        Direction direction = pDir.getOpposite();
        BlockPos blockpos = pFirstPos.above();
        return this.updateShape(
                pLevel,
                pFirstState,
                blockpos,
                pLevel.getBlockState(blockpos),
                pDir == Redirectionor.NORTH ? this.connectsTo(pSecondState, pSecondState.isFaceSturdy(pLevel, pSecondPos, direction), direction) : isConnected(pFirstState, NORTH_WALL),
                pDir == Redirectionor.EAST ? this.connectsTo(pSecondState, pSecondState.isFaceSturdy(pLevel, pSecondPos, direction), direction) : isConnected(pFirstState, EAST_WALL),
                pDir == Redirectionor.SOUTH ? this.connectsTo(pSecondState, pSecondState.isFaceSturdy(pLevel, pSecondPos, direction), direction) : isConnected(pFirstState, SOUTH_WALL),
                pDir == Redirectionor.WEST ? this.connectsTo(pSecondState, pSecondState.isFaceSturdy(pLevel, pSecondPos, direction), direction) : isConnected(pFirstState, WEST_WALL)
        );
    }
}
