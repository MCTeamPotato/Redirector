package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(HugeMushroomBlock.class)
public abstract class MixinHugeMushroomBlock {
    @Shadow @Final private static Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION;
    @Shadow @Final public static BooleanProperty NORTH;
    @Shadow @Final public static BooleanProperty SOUTH;
    @Shadow @Final public static BooleanProperty EAST;
    @Shadow @Final public static BooleanProperty WEST;
    @Shadow @Final public static BooleanProperty UP;
    @Shadow @Final public static BooleanProperty DOWN;

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(
                PROPERTY_BY_DIRECTION.get(pRot.rotate(Redirectionor.NORTH)),
                pState.getValue(NORTH)).setValue(PROPERTY_BY_DIRECTION.get(pRot.rotate(Redirectionor.SOUTH)),
                pState.getValue(SOUTH)).setValue(PROPERTY_BY_DIRECTION.get(pRot.rotate(Redirectionor.EAST)),
                pState.getValue(EAST)).setValue(PROPERTY_BY_DIRECTION.get(pRot.rotate(Redirectionor.WEST)),
                pState.getValue(WEST)).setValue(PROPERTY_BY_DIRECTION.get(pRot.rotate(Redirectionor.UP)),
                pState.getValue(UP)).setValue(PROPERTY_BY_DIRECTION.get(pRot.rotate(Redirectionor.DOWN)),
                pState.getValue(DOWN)
        );
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.setValue(
                PROPERTY_BY_DIRECTION.get(pMirror.mirror(Redirectionor.NORTH)),
                pState.getValue(NORTH)).setValue(PROPERTY_BY_DIRECTION.get(pMirror.mirror(Redirectionor.SOUTH)),
                pState.getValue(SOUTH)).setValue(PROPERTY_BY_DIRECTION.get(pMirror.mirror(Redirectionor.EAST)),
                pState.getValue(EAST)).setValue(PROPERTY_BY_DIRECTION.get(pMirror.mirror(Redirectionor.WEST)),
                pState.getValue(WEST)).setValue(PROPERTY_BY_DIRECTION.get(pMirror.mirror(Redirectionor.UP)),
                pState.getValue(UP)).setValue(PROPERTY_BY_DIRECTION.get(pMirror.mirror(Redirectionor.DOWN)),
                pState.getValue(DOWN)
        );
    }
}
