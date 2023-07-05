package com.teampotato.redirectionor.mixin.minecraft.client.renderer;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import javax.annotation.Nullable;
import java.util.BitSet;

@Mixin(value = BlockModelRenderer.class, priority = 10)
public abstract class BlockModelRendererMixin {

    @Redirect(method = {"renderModelSmooth", "renderModelFlat"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt() {
        return Redirectionor.DIRECTIONS;
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void calculateShape(IBlockDisplayReader pBlockReader, BlockState pState, BlockPos pPos, int[] pVertexData, Direction pFace, @Nullable float[] pQuadBounds, BitSet pBoundsFlags) {
        float f = 32.0F;
        float f1 = 32.0F;
        float f2 = 32.0F;
        float f3 = -32.0F;
        float f4 = -32.0F;
        float f5 = -32.0F;

        for(int i = 0; i < 4; ++i) {
            float f6 = Float.intBitsToFloat(pVertexData[i * 8]);
            float f7 = Float.intBitsToFloat(pVertexData[i * 8 + 1]);
            float f8 = Float.intBitsToFloat(pVertexData[i * 8 + 2]);
            f = Math.min(f, f6);
            f1 = Math.min(f1, f7);
            f2 = Math.min(f2, f8);
            f3 = Math.max(f3, f6);
            f4 = Math.max(f4, f7);
            f5 = Math.max(f5, f8);
        }

        if (pQuadBounds != null) {
            pQuadBounds[Redirectionor.WEST_3D_DATA_VALUE] = f;
            pQuadBounds[Redirectionor.EAST_3D_DATA_VALUE] = f3;
            pQuadBounds[Redirectionor.DOWN_3D_DATA_VALUE] = f1;
            pQuadBounds[Redirectionor.UP_3D_DATA_VALUE] = f4;
            pQuadBounds[Redirectionor.NORTH_3D_DATA_VALUE] = f2;
            pQuadBounds[Redirectionor.SOUTH_3D_DATA_VALUE] = f5;
            int j = Redirectionor.DIRECTIONS_LENGTH;
            pQuadBounds[Redirectionor.WEST_3D_DATA_VALUE + j] = 1.0F - f;
            pQuadBounds[Redirectionor.EAST_3D_DATA_VALUE + j] = 1.0F - f3;
            pQuadBounds[Redirectionor.DOWN_3D_DATA_VALUE + j] = 1.0F - f1;
            pQuadBounds[Redirectionor.UP_3D_DATA_VALUE + j] = 1.0F - f4;
            pQuadBounds[Redirectionor.NORTH_3D_DATA_VALUE + j] = 1.0F - f2;
            pQuadBounds[Redirectionor.SOUTH_3D_DATA_VALUE + j] = 1.0F - f5;
        }

        switch(pFace) {
            case DOWN:
                pBoundsFlags.set(1, f >= 1.0E-4F || f2 >= 1.0E-4F || f3 <= 0.9999F || f5 <= 0.9999F);
                pBoundsFlags.set(0, f1 == f4 && (f1 < 1.0E-4F || pState.isCollisionShapeFullBlock(pBlockReader, pPos)));
                break;
            case UP:
                pBoundsFlags.set(1, f >= 1.0E-4F || f2 >= 1.0E-4F || f3 <= 0.9999F || f5 <= 0.9999F);
                pBoundsFlags.set(0, f1 == f4 && (f4 > 0.9999F || pState.isCollisionShapeFullBlock(pBlockReader, pPos)));
                break;
            case NORTH:
                pBoundsFlags.set(1, f >= 1.0E-4F || f1 >= 1.0E-4F || f3 <= 0.9999F || f4 <= 0.9999F);
                pBoundsFlags.set(0, f2 == f5 && (f2 < 1.0E-4F || pState.isCollisionShapeFullBlock(pBlockReader, pPos)));
                break;
            case SOUTH:
                pBoundsFlags.set(1, f >= 1.0E-4F || f1 >= 1.0E-4F || f3 <= 0.9999F || f4 <= 0.9999F);
                pBoundsFlags.set(0, f2 == f5 && (f5 > 0.9999F || pState.isCollisionShapeFullBlock(pBlockReader, pPos)));
                break;
            case WEST:
                pBoundsFlags.set(1, f1 >= 1.0E-4F || f2 >= 1.0E-4F || f4 <= 0.9999F || f5 <= 0.9999F);
                pBoundsFlags.set(0, f == f3 && (f < 1.0E-4F || pState.isCollisionShapeFullBlock(pBlockReader, pPos)));
                break;
            case EAST:
                pBoundsFlags.set(1, f1 >= 1.0E-4F || f2 >= 1.0E-4F || f4 <= 0.9999F || f5 <= 0.9999F);
                pBoundsFlags.set(0, f == f3 && (f3 > 0.9999F || pState.isCollisionShapeFullBlock(pBlockReader, pPos)));
        }
    }
}
