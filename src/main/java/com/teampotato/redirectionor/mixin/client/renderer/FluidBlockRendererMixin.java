package com.teampotato.redirectionor.mixin.client.renderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.FluidBlockRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@SuppressWarnings({"SameReturnValue", "SameParameterValue"})
@Mixin(value = FluidBlockRenderer.class, priority = 10)
public abstract class FluidBlockRendererMixin {
    @Shadow
    private static boolean isNeighborSameFluid(IBlockReader pLevel, BlockPos pPos, Direction pSide, FluidState pState) {
        return false;
    }

    @Shadow public static boolean shouldRenderFace(IBlockDisplayReader p_239281_0_, BlockPos p_239281_1_, FluidState p_239281_2_, BlockState p_239281_3_, Direction p_239281_4_) {
        return false;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    @Shadow
    private static boolean isFaceOccludedByNeighbor(IBlockReader p_239283_0_, BlockPos p_239283_1_, Direction p_239283_2_, float p_239283_3_) {
        return false;
    }

    @Shadow protected abstract float getWaterHeight(IBlockReader pReader, BlockPos pPos, Fluid pFluid);

    @Shadow protected abstract int getLightColor(IBlockDisplayReader pLightReader, BlockPos pPos);

    @Shadow(remap = false) protected abstract void vertexVanilla(IVertexBuilder vertexBuilderIn, double x, double y, double z, float red, float green, float blue, float alpha, float u, float v, int packedLight);

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public boolean tesselate(IBlockDisplayReader pLightReader, BlockPos pPos, IVertexBuilder pVertexBuilder, FluidState pFluidState) {
        TextureAtlasSprite[] atextureatlassprite = net.minecraftforge.client.ForgeHooksClient.getFluidSprites(pLightReader, pPos, pFluidState);
        BlockState blockstate = pLightReader.getBlockState(pPos);
        int i = pFluidState.getType().getAttributes().getColor(pLightReader, pPos);
        float alpha = (float)(i >> 24 & 255) / 255.0F;
        float f = (float)(i >> 16 & 255) / 255.0F;
        float f1 = (float)(i >> 8 & 255) / 255.0F;
        float f2 = (float)(i & 255) / 255.0F;
        boolean flag1 = !isNeighborSameFluid(pLightReader, pPos, Redirectionor.UP, pFluidState);
        boolean flag2 = shouldRenderFace(pLightReader, pPos, pFluidState, blockstate, Redirectionor.DOWN) && !isFaceOccludedByNeighbor(pLightReader, pPos, Redirectionor.DOWN, 0.8888889F);
        boolean flag3 = shouldRenderFace(pLightReader, pPos, pFluidState, blockstate, Redirectionor.NORTH);
        boolean flag4 = shouldRenderFace(pLightReader, pPos, pFluidState, blockstate, Redirectionor.SOUTH);
        boolean flag5 = shouldRenderFace(pLightReader, pPos, pFluidState, blockstate, Redirectionor.WEST);
        boolean flag6 = shouldRenderFace(pLightReader, pPos, pFluidState, blockstate, Redirectionor.EAST);
        if (!flag1 && !flag2 && !flag6 && !flag5 && !flag3 && !flag4) {
            return false;
        } else {
            boolean flag7 = false;
            float f3 = pLightReader.getShade(Redirectionor.DOWN, true);
            float f4 = pLightReader.getShade(Redirectionor.UP, true);
            float f5 = pLightReader.getShade(Redirectionor.NORTH, true);
            float f6 = pLightReader.getShade(Redirectionor.WEST, true);
            float f7 = this.getWaterHeight(pLightReader, pPos, pFluidState.getType());
            float f8 = this.getWaterHeight(pLightReader, pPos.south(), pFluidState.getType());
            float f9 = this.getWaterHeight(pLightReader, pPos.east().south(), pFluidState.getType());
            float f10 = this.getWaterHeight(pLightReader, pPos.east(), pFluidState.getType());
            double d0 = pPos.getX() & 15;
            double d1 = pPos.getY() & 15;
            double d2 = pPos.getZ() & 15;
            float f12 = flag2 ? 0.001F : 0.0F;
            if (flag1 && !isFaceOccludedByNeighbor(pLightReader, pPos, Redirectionor.UP, Math.min(Math.min(f7, f8), Math.min(f9, f10)))) {
                flag7 = true;
                f7 -= 0.001F;
                f8 -= 0.001F;
                f9 -= 0.001F;
                f10 -= 0.001F;
                Vector3d vector3d = pFluidState.getFlow(pLightReader, pPos);
                float f13;
                float f14;
                float f15;
                float f16;
                float f17;
                float f18;
                float f19;
                float f20;
                if (vector3d.x == 0.0D && vector3d.z == 0.0D) {
                    TextureAtlasSprite textureatlassprite1 = atextureatlassprite[0];
                    f13 = textureatlassprite1.getU(0.0D);
                    f17 = textureatlassprite1.getV(0.0D);
                    f14 = f13;
                    f18 = textureatlassprite1.getV(16.0D);
                    f15 = textureatlassprite1.getU(16.0D);
                    f19 = f18;
                    f16 = f15;
                    f20 = f17;
                } else {
                    TextureAtlasSprite textureatlassprite = atextureatlassprite[1];
                    float f21 = (float) MathHelper.atan2(vector3d.z, vector3d.x) - ((float)Math.PI / 2F);
                    float f22 = MathHelper.sin(f21) * 0.25F;
                    float f23 = MathHelper.cos(f21) * 0.25F;
                    f13 = textureatlassprite.getU(8.0F + (-f23 - f22) * 16.0F);
                    f17 = textureatlassprite.getV(8.0F + (-f23 + f22) * 16.0F);
                    f14 = textureatlassprite.getU(8.0F + (-f23 + f22) * 16.0F);
                    f18 = textureatlassprite.getV(8.0F + (f23 + f22) * 16.0F);
                    f15 = textureatlassprite.getU(8.0F + (f23 + f22) * 16.0F);
                    f19 = textureatlassprite.getV(8.0F + (f23 - f22) * 16.0F);
                    f16 = textureatlassprite.getU(8.0F + (f23 - f22) * 16.0F);
                    f20 = textureatlassprite.getV(8.0F + (-f23 - f22) * 16.0F);
                }

                float f43 = (f13 + f14 + f15 + f16) / 4.0F;
                float f44 = (f17 + f18 + f19 + f20) / 4.0F;
                float f45 = (float)atextureatlassprite[0].getWidth() / (atextureatlassprite[0].getU1() - atextureatlassprite[0].getU0());
                float f46 = (float)atextureatlassprite[0].getHeight() / (atextureatlassprite[0].getV1() - atextureatlassprite[0].getV0());
                float f47 = 4.0F / Math.max(f46, f45);
                f13 = MathHelper.lerp(f47, f13, f43);
                f14 = MathHelper.lerp(f47, f14, f43);
                f15 = MathHelper.lerp(f47, f15, f43);
                f16 = MathHelper.lerp(f47, f16, f43);
                f17 = MathHelper.lerp(f47, f17, f44);
                f18 = MathHelper.lerp(f47, f18, f44);
                f19 = MathHelper.lerp(f47, f19, f44);
                f20 = MathHelper.lerp(f47, f20, f44);
                int j = this.getLightColor(pLightReader, pPos);
                float f25 = f4 * f;
                float f26 = f4 * f1;
                float f27 = f4 * f2;
                this.vertexVanilla(pVertexBuilder, d0 + 0.0D, d1 + (double)f7, d2 + 0.0D, f25, f26, f27, alpha, f13, f17, j);
                this.vertexVanilla(pVertexBuilder, d0 + 0.0D, d1 + (double)f8, d2 + 1.0D, f25, f26, f27, alpha, f14, f18, j);
                this.vertexVanilla(pVertexBuilder, d0 + 1.0D, d1 + (double)f9, d2 + 1.0D, f25, f26, f27, alpha, f15, f19, j);
                this.vertexVanilla(pVertexBuilder, d0 + 1.0D, d1 + (double)f10, d2 + 0.0D, f25, f26, f27, alpha, f16, f20, j);
                if (pFluidState.shouldRenderBackwardUpFace(pLightReader, pPos.above())) {
                    this.vertexVanilla(pVertexBuilder, d0 + 0.0D, d1 + (double)f7, d2 + 0.0D, f25, f26, f27, alpha, f13, f17, j);
                    this.vertexVanilla(pVertexBuilder, d0 + 1.0D, d1 + (double)f10, d2 + 0.0D, f25, f26, f27, alpha, f16, f20, j);
                    this.vertexVanilla(pVertexBuilder, d0 + 1.0D, d1 + (double)f9, d2 + 1.0D, f25, f26, f27, alpha, f15, f19, j);
                    this.vertexVanilla(pVertexBuilder, d0 + 0.0D, d1 + (double)f8, d2 + 1.0D, f25, f26, f27, alpha, f14, f18, j);
                }
            }

            if (flag2) {
                float f34 = atextureatlassprite[0].getU0();
                float f35 = atextureatlassprite[0].getU1();
                float f37 = atextureatlassprite[0].getV0();
                float f39 = atextureatlassprite[0].getV1();
                int i1 = this.getLightColor(pLightReader, pPos.below());
                float f40 = f3 * f;
                float f41 = f3 * f1;
                float f42 = f3 * f2;
                this.vertexVanilla(pVertexBuilder, d0, d1 + (double)f12, d2 + 1.0D, f40, f41, f42, alpha, f34, f39, i1);
                this.vertexVanilla(pVertexBuilder, d0, d1 + (double)f12, d2, f40, f41, f42, alpha, f34, f37, i1);
                this.vertexVanilla(pVertexBuilder, d0 + 1.0D, d1 + (double)f12, d2, f40, f41, f42, alpha, f35, f37, i1);
                this.vertexVanilla(pVertexBuilder, d0 + 1.0D, d1 + (double)f12, d2 + 1.0D, f40, f41, f42, alpha, f35, f39, i1);
                flag7 = true;
            }

            for(int l = 0; l < 4; ++l) {
                float f36;
                float f38;
                double d3;
                double d4;
                double d5;
                double d6;
                Direction direction;
                boolean flag8;
                if (l == 0) {
                    f36 = f7;
                    f38 = f10;
                    d3 = d0;
                    d5 = d0 + 1.0D;
                    d4 = d2 + (double)0.001F;
                    d6 = d2 + (double)0.001F;
                    direction = Redirectionor.NORTH;
                    flag8 = flag3;
                } else if (l == 1) {
                    f36 = f9;
                    f38 = f8;
                    d3 = d0 + 1.0D;
                    d5 = d0;
                    d4 = d2 + 1.0D - (double)0.001F;
                    d6 = d2 + 1.0D - (double)0.001F;
                    direction = Redirectionor.SOUTH;
                    flag8 = flag4;
                } else if (l == 2) {
                    f36 = f8;
                    f38 = f7;
                    d3 = d0 + (double)0.001F;
                    d5 = d0 + (double)0.001F;
                    d4 = d2 + 1.0D;
                    d6 = d2;
                    direction = Redirectionor.WEST;
                    flag8 = flag5;
                } else {
                    f36 = f10;
                    f38 = f9;
                    d3 = d0 + 1.0D - (double)0.001F;
                    d5 = d0 + 1.0D - (double)0.001F;
                    d4 = d2;
                    d6 = d2 + 1.0D;
                    direction = Redirectionor.EAST;
                    flag8 = flag6;
                }

                if (flag8 && !isFaceOccludedByNeighbor(pLightReader, pPos, direction, Math.max(f36, f38))) {
                    flag7 = true;
                    BlockPos blockpos = pPos.relative(direction);
                    TextureAtlasSprite textureatlassprite2 = atextureatlassprite[1];
                    if (atextureatlassprite[2] != null) {
                        if (pLightReader.getBlockState(blockpos).shouldDisplayFluidOverlay(pLightReader, blockpos, pFluidState)) {
                            textureatlassprite2 = atextureatlassprite[2];
                        }
                    }

                    float f48 = textureatlassprite2.getU(0.0D);
                    float f49 = textureatlassprite2.getU(8.0D);
                    float f50 = textureatlassprite2.getV((1.0F - f36) * 16.0F * 0.5F);
                    float f28 = textureatlassprite2.getV((1.0F - f38) * 16.0F * 0.5F);
                    float f29 = textureatlassprite2.getV(8.0D);
                    int k = this.getLightColor(pLightReader, blockpos);
                    float f30 = l < 2 ? f5 : f6;
                    float f31 = f4 * f30 * f;
                    float f32 = f4 * f30 * f1;
                    float f33 = f4 * f30 * f2;
                    this.vertexVanilla(pVertexBuilder, d3, d1 + (double)f36, d4, f31, f32, f33, alpha, f48, f50, k);
                    this.vertexVanilla(pVertexBuilder, d5, d1 + (double)f38, d6, f31, f32, f33, alpha, f49, f28, k);
                    this.vertexVanilla(pVertexBuilder, d5, d1 + (double)f12, d6, f31, f32, f33, alpha, f49, f29, k);
                    this.vertexVanilla(pVertexBuilder, d3, d1 + (double)f12, d4, f31, f32, f33, alpha, f48, f29, k);
                    if (textureatlassprite2 != atextureatlassprite[2]) {
                        this.vertexVanilla(pVertexBuilder, d3, d1 + (double)f12, d4, f31, f32, f33, alpha, f48, f29, k);
                        this.vertexVanilla(pVertexBuilder, d5, d1 + (double)f12, d6, f31, f32, f33, alpha, f49, f29, k);
                        this.vertexVanilla(pVertexBuilder, d5, d1 + (double)f38, d6, f31, f32, f33, alpha, f49, f28, k);
                        this.vertexVanilla(pVertexBuilder, d3, d1 + (double)f36, d4, f31, f32, f33, alpha, f48, f50, k);
                    }
                }
            }

            return flag7;
        }
    }
}
