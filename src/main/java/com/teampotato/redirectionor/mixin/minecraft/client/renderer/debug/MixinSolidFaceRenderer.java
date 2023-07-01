package com.teampotato.redirectionor.mixin.minecraft.client.renderer.debug;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.debug.SolidFaceRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = SolidFaceRenderer.class, priority = 10)
public abstract class MixinSolidFaceRenderer {
    @Shadow @Final private Minecraft minecraft;

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public void render(PoseStack pPoseStack, MultiBufferSource pBufferSource, double pCamX, double pCamY, double pCamZ) {
        if (this.minecraft.player == null) return;
        BlockGetter blockgetter = this.minecraft.player.level;
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.lineWidth(2.0F);
        RenderSystem.disableTexture();
        RenderSystem.depthMask(false);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        BlockPos blockpos = new BlockPos(pCamX, pCamY, pCamZ);

        for(BlockPos blockpos1 : BlockPos.betweenClosed(blockpos.offset(-6, -6, -6), blockpos.offset(6, 6, 6))) {
            BlockState blockstate = blockgetter.getBlockState(blockpos1);
            if (!blockstate.is(Blocks.AIR)) {
                VoxelShape voxelshape = blockstate.getShape(blockgetter, blockpos1);

                for(AABB aabb : voxelshape.toAabbs()) {
                    AABB aabb1 = aabb.move(blockpos1).inflate(0.002D).move(-pCamX, -pCamY, -pCamZ);
                    double d0 = aabb1.minX;
                    double d1 = aabb1.minY;
                    double d2 = aabb1.minZ;
                    double d3 = aabb1.maxX;
                    double d4 = aabb1.maxY;
                    double d5 = aabb1.maxZ;
                    if (blockstate.isFaceSturdy(blockgetter, blockpos1, Redirectionor.WEST)) {
                        Tesselator tesselator = Tesselator.getInstance();
                        BufferBuilder bufferbuilder = tesselator.getBuilder();
                        bufferbuilder.begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION_COLOR);
                        bufferbuilder.vertex(d0, d1, d2).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder.vertex(d0, d1, d5).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder.vertex(d0, d4, d2).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder.vertex(d0, d4, d5).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        tesselator.end();
                    }

                    if (blockstate.isFaceSturdy(blockgetter, blockpos1, Redirectionor.SOUTH)) {
                        Tesselator tesselator1 = Tesselator.getInstance();
                        BufferBuilder bufferbuilder1 = tesselator1.getBuilder();
                        bufferbuilder1.begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION_COLOR);
                        bufferbuilder1.vertex(d0, d4, d5).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder1.vertex(d0, d1, d5).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder1.vertex(d3, d4, d5).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder1.vertex(d3, d1, d5).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        tesselator1.end();
                    }

                    if (blockstate.isFaceSturdy(blockgetter, blockpos1, Redirectionor.EAST)) {
                        Tesselator tesselator2 = Tesselator.getInstance();
                        BufferBuilder bufferbuilder2 = tesselator2.getBuilder();
                        bufferbuilder2.begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION_COLOR);
                        bufferbuilder2.vertex(d3, d1, d5).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder2.vertex(d3, d1, d2).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder2.vertex(d3, d4, d5).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder2.vertex(d3, d4, d2).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        tesselator2.end();
                    }

                    if (blockstate.isFaceSturdy(blockgetter, blockpos1, Redirectionor.NORTH)) {
                        Tesselator tesselator3 = Tesselator.getInstance();
                        BufferBuilder bufferbuilder3 = tesselator3.getBuilder();
                        bufferbuilder3.begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION_COLOR);
                        bufferbuilder3.vertex(d3, d4, d2).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder3.vertex(d3, d1, d2).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder3.vertex(d0, d4, d2).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder3.vertex(d0, d1, d2).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        tesselator3.end();
                    }

                    if (blockstate.isFaceSturdy(blockgetter, blockpos1, Redirectionor.DOWN)) {
                        Tesselator tesselator4 = Tesselator.getInstance();
                        BufferBuilder bufferbuilder4 = tesselator4.getBuilder();
                        bufferbuilder4.begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION_COLOR);
                        bufferbuilder4.vertex(d0, d1, d2).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder4.vertex(d3, d1, d2).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder4.vertex(d0, d1, d5).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder4.vertex(d3, d1, d5).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        tesselator4.end();
                    }

                    if (blockstate.isFaceSturdy(blockgetter, blockpos1, Redirectionor.UP)) {
                        Tesselator tesselator5 = Tesselator.getInstance();
                        BufferBuilder bufferbuilder5 = tesselator5.getBuilder();
                        bufferbuilder5.begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION_COLOR);
                        bufferbuilder5.vertex(d0, d4, d2).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder5.vertex(d0, d4, d5).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder5.vertex(d3, d4, d2).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        bufferbuilder5.vertex(d3, d4, d5).color(1.0F, 0.0F, 0.0F, 0.5F).endVertex();
                        tesselator5.end();
                    }
                }
            }
        }

        RenderSystem.depthMask(true);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }
}
