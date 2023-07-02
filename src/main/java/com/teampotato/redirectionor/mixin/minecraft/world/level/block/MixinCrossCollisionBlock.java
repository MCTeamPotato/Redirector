package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CrossCollisionBlock.class)
public abstract class MixinCrossCollisionBlock {
    @Shadow @Final private Object2IntMap<BlockState> stateToIndex;
    @Shadow @Final public static BooleanProperty NORTH;
    @Shadow @Final public static BooleanProperty WEST;
    @Shadow @Final public static BooleanProperty SOUTH;
    @Shadow @Final public static BooleanProperty EAST;
    @Shadow
    private static int indexFor(Direction pFacing) {
        throw new RuntimeException();
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    @SuppressWarnings("deprecation")
    protected int getAABBIndex(BlockState pState) {
        return this.stateToIndex.computeIntIfAbsent(pState, (blockState) -> {
            int i = 0;
            if (blockState.getValue(NORTH)) i |= indexFor(Redirectionor.NORTH);
            if (blockState.getValue(EAST)) i |= indexFor(Redirectionor.EAST);
            if (blockState.getValue(SOUTH)) i |= indexFor(Redirectionor.SOUTH);
            if (blockState.getValue(WEST)) i |= indexFor(Redirectionor.WEST);
            return i;
        });
    }
}
