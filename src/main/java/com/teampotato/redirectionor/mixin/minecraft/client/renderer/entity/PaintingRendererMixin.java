package com.teampotato.redirectionor.mixin.minecraft.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.PaintingRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.item.PaintingEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = PaintingRenderer.class, priority = 10)
public abstract class PaintingRendererMixin {

    @Shadow protected abstract void vertex(Matrix4f p_229121_1_, Matrix3f p_229121_2_, IVertexBuilder p_229121_3_, float p_229121_4_, float p_229121_5_, float p_229121_6_, float p_229121_7_, float p_229121_8_, int p_229121_9_, int p_229121_10_, int p_229121_11_, int p_229121_12_);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void renderPainting(MatrixStack p_229122_1_, IVertexBuilder p_229122_2_, PaintingEntity p_229122_3_, int p_229122_4_, int p_229122_5_, TextureAtlasSprite p_229122_6_, TextureAtlasSprite p_229122_7_) {
        MatrixStack.Entry matrixstack$entry = p_229122_1_.last();
        Matrix4f matrix4f = matrixstack$entry.pose();
        Matrix3f matrix3f = matrixstack$entry.normal();
        float f = (float)(-p_229122_4_) / 2.0F;
        float f1 = (float)(-p_229122_5_) / 2.0F;
        float f3 = p_229122_7_.getU0();
        float f4 = p_229122_7_.getU1();
        float f5 = p_229122_7_.getV0();
        float f6 = p_229122_7_.getV1();
        float f7 = p_229122_7_.getU0();
        float f8 = p_229122_7_.getU1();
        float f9 = p_229122_7_.getV0();
        float f10 = p_229122_7_.getV(1.0D);
        float f11 = p_229122_7_.getU0();
        float f12 = p_229122_7_.getU(1.0D);
        float f13 = p_229122_7_.getV0();
        float f14 = p_229122_7_.getV1();
        int i = p_229122_4_ / 16;
        int j = p_229122_5_ / 16;
        double d0 = 16.0D / (double)i;
        double d1 = 16.0D / (double)j;

        for(int k = 0; k < i; ++k) {
            for(int l = 0; l < j; ++l) {
                float f15 = f + (float)((k + 1) * 16);
                float f16 = f + (float)(k * 16);
                float f17 = f1 + (float)((l + 1) * 16);
                float f18 = f1 + (float)(l * 16);
                int i1 = MathHelper.floor(p_229122_3_.getX());
                int j1 = MathHelper.floor(p_229122_3_.getY() + (double)((f17 + f18) / 2.0F / 16.0F));
                int k1 = MathHelper.floor(p_229122_3_.getZ());
                Direction direction = p_229122_3_.getDirection();
                if (direction == Redirectionor.NORTH) i1 = MathHelper.floor(p_229122_3_.getX() + (double)((f15 + f16) / 2.0F / 16.0F));
                if (direction == Redirectionor.WEST) k1 = MathHelper.floor(p_229122_3_.getZ() - (double)((f15 + f16) / 2.0F / 16.0F));
                if (direction == Redirectionor.SOUTH) i1 = MathHelper.floor(p_229122_3_.getX() - (double)((f15 + f16) / 2.0F / 16.0F));
                if (direction == Redirectionor.EAST) k1 = MathHelper.floor(p_229122_3_.getZ() + (double)((f15 + f16) / 2.0F / 16.0F));
                int l1 = WorldRenderer.getLightColor(p_229122_3_.level, new BlockPos(i1, j1, k1));
                float f19 = p_229122_6_.getU(d0 * (double)(i - k));
                float f20 = p_229122_6_.getU(d0 * (double)(i - (k + 1)));
                float f21 = p_229122_6_.getV(d1 * (double)(j - l));
                float f22 = p_229122_6_.getV(d1 * (double)(j - (l + 1)));
                this.vertex(matrix4f, matrix3f, p_229122_2_, f15, f18, f20, f21, -0.5F, 0, 0, -1, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f16, f18, f19, f21, -0.5F, 0, 0, -1, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f16, f17, f19, f22, -0.5F, 0, 0, -1, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f15, f17, f20, f22, -0.5F, 0, 0, -1, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f15, f17, f3, f5, 0.5F, 0, 0, 1, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f16, f17, f4, f5, 0.5F, 0, 0, 1, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f16, f18, f4, f6, 0.5F, 0, 0, 1, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f15, f18, f3, f6, 0.5F, 0, 0, 1, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f15, f17, f7, f9, -0.5F, 0, 1, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f16, f17, f8, f9, -0.5F, 0, 1, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f16, f17, f8, f10, 0.5F, 0, 1, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f15, f17, f7, f10, 0.5F, 0, 1, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f15, f18, f7, f9, 0.5F, 0, -1, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f16, f18, f8, f9, 0.5F, 0, -1, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f16, f18, f8, f10, -0.5F, 0, -1, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f15, f18, f7, f10, -0.5F, 0, -1, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f15, f17, f12, f13, 0.5F, -1, 0, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f15, f18, f12, f14, 0.5F, -1, 0, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f15, f18, f11, f14, -0.5F, -1, 0, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f15, f17, f11, f13, -0.5F, -1, 0, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f16, f17, f12, f13, -0.5F, 1, 0, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f16, f18, f12, f14, -0.5F, 1, 0, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f16, f18, f11, f14, 0.5F, 1, 0, 0, l1);
                this.vertex(matrix4f, matrix3f, p_229122_2_, f16, f17, f11, f13, 0.5F, 1, 0, 0, l1);
            }
        }

    }
}
