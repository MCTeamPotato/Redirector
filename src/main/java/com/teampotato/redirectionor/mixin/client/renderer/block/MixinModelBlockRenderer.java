package com.teampotato.redirectionor.mixin.client.renderer.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import javax.annotation.Nullable;
import java.util.BitSet;

@Mixin(ModelBlockRenderer.class)
public abstract class MixinModelBlockRenderer {
    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void calculateShape(BlockAndTintGetter pLevel, BlockState pState, BlockPos pPos, int[] pVertices, Direction pDirection, @Nullable float[] pShape, BitSet pShapeFlags) {
        float f = 32.0F;
        float f1 = 32.0F;
        float f2 = 32.0F;
        float f3 = -32.0F;
        float f4 = -32.0F;
        float f5 = -32.0F;

        for(int i = 0; i < 4; ++i) {
            float f6 = Float.intBitsToFloat(pVertices[i * 8]);
            float f7 = Float.intBitsToFloat(pVertices[i * 8 + 1]);
            float f8 = Float.intBitsToFloat(pVertices[i * 8 + 2]);
            f = Math.min(f, f6);
            f1 = Math.min(f1, f7);
            f2 = Math.min(f2, f8);
            f3 = Math.max(f3, f6);
            f4 = Math.max(f4, f7);
            f5 = Math.max(f5, f8);
        }

        if (pShape != null) {
            pShape[Redirectionor.WEST_3D_DATA_VALUE] = f;
            pShape[Redirectionor.EAST_3D_DATA_VALUE] = f3;
            pShape[Redirectionor.DOWN_3D_DATA_VALUE] = f1;
            pShape[Redirectionor.UP_3D_DATA_VALUE] = f4;
            pShape[Redirectionor.NORTH_3D_DATA_VALUE] = f2;
            pShape[Redirectionor.SOUTH_3D_DATA_VALUE] = f5;
            int j = Redirectionor.DIRECTIONS.length;
            pShape[Redirectionor.WEST_3D_DATA_VALUE + j] = 1.0F - f;
            pShape[Redirectionor.EAST_3D_DATA_VALUE + j] = 1.0F - f3;
            pShape[Redirectionor.DOWN_3D_DATA_VALUE + j] = 1.0F - f1;
            pShape[Redirectionor.UP_3D_DATA_VALUE + j] = 1.0F - f4;
            pShape[Redirectionor.NORTH_3D_DATA_VALUE + j] = 1.0F - f2;
            pShape[Redirectionor.SOUTH_3D_DATA_VALUE + j] = 1.0F - f5;
        }

        switch (pDirection) {
            case DOWN -> {
                pShapeFlags.set(1, f >= 1.0E-4F || f2 >= 1.0E-4F || f3 <= 0.9999F || f5 <= 0.9999F);
                pShapeFlags.set(0, f1 == f4 && (f1 < 1.0E-4F || pState.isCollisionShapeFullBlock(pLevel, pPos)));
            }
            case UP -> {
                pShapeFlags.set(1, f >= 1.0E-4F || f2 >= 1.0E-4F || f3 <= 0.9999F || f5 <= 0.9999F);
                pShapeFlags.set(0, f1 == f4 && (f4 > 0.9999F || pState.isCollisionShapeFullBlock(pLevel, pPos)));
            }
            case NORTH -> {
                pShapeFlags.set(1, f >= 1.0E-4F || f1 >= 1.0E-4F || f3 <= 0.9999F || f4 <= 0.9999F);
                pShapeFlags.set(0, f2 == f5 && (f2 < 1.0E-4F || pState.isCollisionShapeFullBlock(pLevel, pPos)));
            }
            case SOUTH -> {
                pShapeFlags.set(1, f >= 1.0E-4F || f1 >= 1.0E-4F || f3 <= 0.9999F || f4 <= 0.9999F);
                pShapeFlags.set(0, f2 == f5 && (f5 > 0.9999F || pState.isCollisionShapeFullBlock(pLevel, pPos)));
            }
            case WEST -> {
                pShapeFlags.set(1, f1 >= 1.0E-4F || f2 >= 1.0E-4F || f4 <= 0.9999F || f5 <= 0.9999F);
                pShapeFlags.set(0, f == f3 && (f < 1.0E-4F || pState.isCollisionShapeFullBlock(pLevel, pPos)));
            }
            case EAST -> {
                pShapeFlags.set(1, f1 >= 1.0E-4F || f2 >= 1.0E-4F || f4 <= 0.9999F || f5 <= 0.9999F);
                pShapeFlags.set(0, f == f3 && (f3 > 0.9999F || pState.isCollisionShapeFullBlock(pLevel, pPos)));
            }
        }

    }
}
