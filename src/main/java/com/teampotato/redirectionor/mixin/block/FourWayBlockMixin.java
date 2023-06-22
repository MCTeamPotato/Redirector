package com.teampotato.redirectionor.mixin.block;

import com.teampotato.redirectionor.Redirectionor;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.block.BlockState;
import net.minecraft.block.FourWayBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = FourWayBlock.class, priority = 10)
public abstract class FourWayBlockMixin {
    @Shadow @Final private Object2IntMap<BlockState> stateToIndex;
    @Shadow @Final public static BooleanProperty NORTH;
    @Shadow
    private static int indexFor(Direction pFacing) {
        return 0;
    }
    @Shadow @Final public static BooleanProperty EAST;
    @Shadow @Final public static BooleanProperty SOUTH;
    @Shadow @Final public static BooleanProperty WEST;

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
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
