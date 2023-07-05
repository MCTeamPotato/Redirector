package com.teampotato.redirectionor.mixin.minecraft.client.renderer.block;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.block.LiquidBlockRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ForgeHooksClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@SuppressWarnings("UnstableApiUsage")
@Mixin(LiquidBlockRenderer.class)
public abstract class MixinLiquidBlockRenderer {
    @Shadow private static boolean isNeighborSameFluid(FluidState p_203186_, FluidState p_203187_) {throw new RuntimeException();}
    @Shadow public static boolean shouldRenderFace(BlockAndTintGetter p_203167_, BlockPos p_203168_, FluidState p_203169_, BlockState p_203170_, Direction p_203171_, FluidState p_203172_) {throw new RuntimeException();}
    @Shadow private static boolean isFaceOccludedByNeighbor(BlockGetter p_203180_, BlockPos p_203181_, Direction p_203182_, float p_203183_, BlockState p_203184_) {throw new RuntimeException();}
    @Shadow protected abstract float getHeight(BlockAndTintGetter p_203161_, Fluid p_203162_, BlockPos p_203163_, BlockState p_203164_, FluidState p_203165_);
    @Shadow protected abstract float calculateAverageHeight(BlockAndTintGetter p_203150_, Fluid p_203151_, float p_203152_, float p_203153_, float p_203154_, BlockPos p_203155_);
    @Shadow protected abstract int getLightColor(BlockAndTintGetter p_110946_, BlockPos p_110947_);
    @Shadow(remap = false) protected abstract void vertex(VertexConsumer p_110985_, double p_110986_, double p_110987_, double p_110988_, float p_110989_, float p_110990_, float p_110991_, float alpha, float p_110992_, float p_110993_, int p_110994_);
    @Shadow private TextureAtlasSprite waterOverlay;

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public void tesselate(BlockAndTintGetter p_234370_, BlockPos p_234371_, VertexConsumer p_234372_, BlockState p_234373_, FluidState p_234374_) {
        TextureAtlasSprite[] atextureatlassprite = ForgeHooksClient.getFluidSprites(p_234370_, p_234371_, p_234374_);
        int i = net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions.of(p_234374_).getTintColor(p_234374_, p_234370_, p_234371_);
        float alpha = (float)(i >> 24 & 255) / 255.0F;
        float f = (float)(i >> 16 & 255) / 255.0F;
        float f1 = (float)(i >> 8 & 255) / 255.0F;
        float f2 = (float)(i & 255) / 255.0F;
        BlockState blockstate = p_234370_.getBlockState(p_234371_.relative(Redirectionor.DOWN));
        FluidState fluidstate = blockstate.getFluidState();
        BlockState blockstate1 = p_234370_.getBlockState(p_234371_.relative(Redirectionor.UP));
        FluidState fluidstate1 = blockstate1.getFluidState();
        BlockState blockstate2 = p_234370_.getBlockState(p_234371_.relative(Redirectionor.NORTH));
        FluidState fluidstate2 = blockstate2.getFluidState();
        BlockState blockstate3 = p_234370_.getBlockState(p_234371_.relative(Redirectionor.SOUTH));
        FluidState fluidstate3 = blockstate3.getFluidState();
        BlockState blockstate4 = p_234370_.getBlockState(p_234371_.relative(Redirectionor.WEST));
        FluidState fluidstate4 = blockstate4.getFluidState();
        BlockState blockstate5 = p_234370_.getBlockState(p_234371_.relative(Redirectionor.EAST));
        FluidState fluidstate5 = blockstate5.getFluidState();
        boolean flag1 = !isNeighborSameFluid(p_234374_, fluidstate1);
        boolean flag2 = shouldRenderFace(p_234370_, p_234371_, p_234374_, p_234373_, Redirectionor.DOWN, fluidstate) && !isFaceOccludedByNeighbor(p_234370_, p_234371_, Redirectionor.DOWN, 0.8888889F, blockstate);
        boolean flag3 = shouldRenderFace(p_234370_, p_234371_, p_234374_, p_234373_, Redirectionor.NORTH, fluidstate2);
        boolean flag4 = shouldRenderFace(p_234370_, p_234371_, p_234374_, p_234373_, Redirectionor.SOUTH, fluidstate3);
        boolean flag5 = shouldRenderFace(p_234370_, p_234371_, p_234374_, p_234373_, Redirectionor.WEST, fluidstate4);
        boolean flag6 = shouldRenderFace(p_234370_, p_234371_, p_234374_, p_234373_, Redirectionor.EAST, fluidstate5);
        if (flag1 || flag2 || flag6 || flag5 || flag3 || flag4) {
            float f3 = p_234370_.getShade(Redirectionor.DOWN, true);
            float f4 = p_234370_.getShade(Redirectionor.UP, true);
            float f5 = p_234370_.getShade(Redirectionor.NORTH, true);
            float f6 = p_234370_.getShade(Redirectionor.WEST, true);
            Fluid fluid = p_234374_.getType();
            float f11 = this.getHeight(p_234370_, fluid, p_234371_, p_234373_, p_234374_);
            float f7;
            float f8;
            float f9;
            float f10;
            if (f11 >= 1.0F) {
                f7 = 1.0F;
                f8 = 1.0F;
                f9 = 1.0F;
                f10 = 1.0F;
            } else {
                float f12 = this.getHeight(p_234370_, fluid, p_234371_.north(), blockstate2, fluidstate2);
                float f13 = this.getHeight(p_234370_, fluid, p_234371_.south(), blockstate3, fluidstate3);
                float f14 = this.getHeight(p_234370_, fluid, p_234371_.east(), blockstate5, fluidstate5);
                float f15 = this.getHeight(p_234370_, fluid, p_234371_.west(), blockstate4, fluidstate4);
                f7 = this.calculateAverageHeight(p_234370_, fluid, f11, f12, f14, p_234371_.relative(Redirectionor.NORTH).relative(Redirectionor.EAST));
                f8 = this.calculateAverageHeight(p_234370_, fluid, f11, f12, f15, p_234371_.relative(Redirectionor.NORTH).relative(Redirectionor.WEST));
                f9 = this.calculateAverageHeight(p_234370_, fluid, f11, f13, f14, p_234371_.relative(Redirectionor.SOUTH).relative(Redirectionor.EAST));
                f10 = this.calculateAverageHeight(p_234370_, fluid, f11, f13, f15, p_234371_.relative(Redirectionor.SOUTH).relative(Redirectionor.WEST));
            }

            double d1 = p_234371_.getX() & 15;
            double d2 = p_234371_.getY() & 15;
            double d0 = p_234371_.getZ() & 15;
            float f17 = flag2 ? 0.001F : 0.0F;
            if (flag1 && !isFaceOccludedByNeighbor(p_234370_, p_234371_, Redirectionor.UP, Math.min(Math.min(f8, f10), Math.min(f9, f7)), blockstate1)) {
                f8 -= 0.001F;
                f10 -= 0.001F;
                f9 -= 0.001F;
                f7 -= 0.001F;
                Vec3 vec3 = p_234374_.getFlow(p_234370_, p_234371_);
                float f18;
                float f19;
                float f20;
                float f21;
                float f22;
                float f23;
                float f24;
                float f25;
                if (vec3.x == 0.0D && vec3.z == 0.0D) {
                    TextureAtlasSprite textureatlassprite1 = atextureatlassprite[0];
                    f18 = textureatlassprite1.getU(0.0D);
                    f22 = textureatlassprite1.getV(0.0D);
                    f19 = f18;
                    f23 = textureatlassprite1.getV(16.0D);
                    f20 = textureatlassprite1.getU(16.0D);
                    f24 = f23;
                    f21 = f20;
                    f25 = f22;
                } else {
                    TextureAtlasSprite textureatlassprite = atextureatlassprite[1];
                    float f26 = (float) Mth.atan2(vec3.z, vec3.x) - ((float)Math.PI / 2F);
                    float f27 = Mth.sin(f26) * 0.25F;
                    float f28 = Mth.cos(f26) * 0.25F;
                    f18 = textureatlassprite.getU(8.0F + (-f28 - f27) * 16.0F);
                    f22 = textureatlassprite.getV(8.0F + (-f28 + f27) * 16.0F);
                    f19 = textureatlassprite.getU(8.0F + (-f28 + f27) * 16.0F);
                    f23 = textureatlassprite.getV(8.0F + (f28 + f27) * 16.0F);
                    f20 = textureatlassprite.getU(8.0F + (f28 + f27) * 16.0F);
                    f24 = textureatlassprite.getV(8.0F + (f28 - f27) * 16.0F);
                    f21 = textureatlassprite.getU(8.0F + (f28 - f27) * 16.0F);
                    f25 = textureatlassprite.getV(8.0F + (-f28 - f27) * 16.0F);
                }

                float f49 = (f18 + f19 + f20 + f21) / 4.0F;
                float f50 = (f22 + f23 + f24 + f25) / 4.0F;
                float f51 = (float)atextureatlassprite[0].getWidth() / (atextureatlassprite[0].getU1() - atextureatlassprite[0].getU0());
                float f52 = (float)atextureatlassprite[0].getHeight() / (atextureatlassprite[0].getV1() - atextureatlassprite[0].getV0());
                float f53 = 4.0F / Math.max(f52, f51);
                f18 = Mth.lerp(f53, f18, f49);
                f19 = Mth.lerp(f53, f19, f49);
                f20 = Mth.lerp(f53, f20, f49);
                f21 = Mth.lerp(f53, f21, f49);
                f22 = Mth.lerp(f53, f22, f50);
                f23 = Mth.lerp(f53, f23, f50);
                f24 = Mth.lerp(f53, f24, f50);
                f25 = Mth.lerp(f53, f25, f50);
                int j = this.getLightColor(p_234370_, p_234371_);
                float f30 = f4 * f;
                float f31 = f4 * f1;
                float f32 = f4 * f2;

                this.vertex(p_234372_, d1 + 0.0D, d2 + (double)f8, d0 + 0.0D, f30, f31, f32, alpha, f18, f22, j);
                this.vertex(p_234372_, d1 + 0.0D, d2 + (double)f10, d0 + 1.0D, f30, f31, f32, alpha, f19, f23, j);
                this.vertex(p_234372_, d1 + 1.0D, d2 + (double)f9, d0 + 1.0D, f30, f31, f32, alpha, f20, f24, j);
                this.vertex(p_234372_, d1 + 1.0D, d2 + (double)f7, d0 + 0.0D, f30, f31, f32, alpha, f21, f25, j);
                if (p_234374_.shouldRenderBackwardUpFace(p_234370_, p_234371_.above())) {
                    this.vertex(p_234372_, d1 + 0.0D, d2 + (double)f8, d0 + 0.0D, f30, f31, f32, alpha, f18, f22, j);
                    this.vertex(p_234372_, d1 + 1.0D, d2 + (double)f7, d0 + 0.0D, f30, f31, f32, alpha, f21, f25, j);
                    this.vertex(p_234372_, d1 + 1.0D, d2 + (double)f9, d0 + 1.0D, f30, f31, f32, alpha, f20, f24, j);
                    this.vertex(p_234372_, d1 + 0.0D, d2 + (double)f10, d0 + 1.0D, f30, f31, f32, alpha, f19, f23, j);
                }
            }

            if (flag2) {
                float f40 = atextureatlassprite[0].getU0();
                float f41 = atextureatlassprite[0].getU1();
                float f42 = atextureatlassprite[0].getV0();
                float f43 = atextureatlassprite[0].getV1();
                int l = this.getLightColor(p_234370_, p_234371_.below());
                float f46 = f3 * f;
                float f47 = f3 * f1;
                float f48 = f3 * f2;

                this.vertex(p_234372_, d1, d2 + (double)f17, d0 + 1.0D, f46, f47, f48, alpha, f40, f43, l);
                this.vertex(p_234372_, d1, d2 + (double)f17, d0, f46, f47, f48, alpha, f40, f42, l);
                this.vertex(p_234372_, d1 + 1.0D, d2 + (double)f17, d0, f46, f47, f48, alpha, f41, f42, l);
                this.vertex(p_234372_, d1 + 1.0D, d2 + (double)f17, d0 + 1.0D, f46, f47, f48, alpha, f41, f43, l);
            }

            int k = this.getLightColor(p_234370_, p_234371_);

            for(Direction direction : Redirectionor.HORIZONTAL) {
                float f44;
                float f45;
                double d3;
                double d4;
                double d5;
                double d6;
                boolean flag7;
                switch (direction) {
                    case NORTH -> {
                        f44 = f8;
                        f45 = f7;
                        d3 = d1;
                        d5 = d1 + 1.0D;
                        d4 = d0 + (double) 0.001F;
                        d6 = d0 + (double) 0.001F;
                        flag7 = flag3;
                    }
                    case SOUTH -> {
                        f44 = f9;
                        f45 = f10;
                        d3 = d1 + 1.0D;
                        d5 = d1;
                        d4 = d0 + 1.0D - (double) 0.001F;
                        d6 = d0 + 1.0D - (double) 0.001F;
                        flag7 = flag4;
                    }
                    case WEST -> {
                        f44 = f10;
                        f45 = f8;
                        d3 = d1 + (double) 0.001F;
                        d5 = d1 + (double) 0.001F;
                        d4 = d0 + 1.0D;
                        d6 = d0;
                        flag7 = flag5;
                    }
                    default -> {
                        f44 = f7;
                        f45 = f9;
                        d3 = d1 + 1.0D - (double) 0.001F;
                        d5 = d1 + 1.0D - (double) 0.001F;
                        d4 = d0;
                        d6 = d0 + 1.0D;
                        flag7 = flag6;
                    }
                }

                if (flag7 && !isFaceOccludedByNeighbor(p_234370_, p_234371_, direction, Math.max(f44, f45), p_234370_.getBlockState(p_234371_.relative(direction)))) {
                    BlockPos blockpos = p_234371_.relative(direction);
                    TextureAtlasSprite textureatlassprite2 = atextureatlassprite[1];
                    if (atextureatlassprite[2] != null) {
                        if (p_234370_.getBlockState(blockpos).shouldDisplayFluidOverlay(p_234370_, blockpos, p_234374_)) {
                            textureatlassprite2 = atextureatlassprite[2];
                        }
                    }

                    float f54 = textureatlassprite2.getU(0.0D);
                    float f55 = textureatlassprite2.getU(8.0D);
                    float f33 = textureatlassprite2.getV((1.0F - f44) * 16.0F * 0.5F);
                    float f34 = textureatlassprite2.getV((1.0F - f45) * 16.0F * 0.5F);
                    float f35 = textureatlassprite2.getV(8.0D);
                    float f36 = direction.getAxis() == Redirectionor.Z ? f5 : f6;
                    float f37 = f4 * f36 * f;
                    float f38 = f4 * f36 * f1;
                    float f39 = f4 * f36 * f2;

                    this.vertex(p_234372_, d3, d2 + (double)f44, d4, f37, f38, f39, alpha, f54, f33, k);
                    this.vertex(p_234372_, d5, d2 + (double)f45, d6, f37, f38, f39, alpha, f55, f34, k);
                    this.vertex(p_234372_, d5, d2 + (double)f17, d6, f37, f38, f39, alpha, f55, f35, k);
                    this.vertex(p_234372_, d3, d2 + (double)f17, d4, f37, f38, f39, alpha, f54, f35, k);
                    if (textureatlassprite2 != this.waterOverlay) {
                        this.vertex(p_234372_, d3, d2 + (double)f17, d4, f37, f38, f39, alpha, f54, f35, k);
                        this.vertex(p_234372_, d5, d2 + (double)f17, d6, f37, f38, f39, alpha, f55, f35, k);
                        this.vertex(p_234372_, d5, d2 + (double)f45, d6, f37, f38, f39, alpha, f55, f34, k);
                        this.vertex(p_234372_, d3, d2 + (double)f44, d4, f37, f38, f39, alpha, f54, f33, k);
                    }
                }
            }

        }
    }
}
