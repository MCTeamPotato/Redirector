package com.teampotato.redirectionor.mixin.minecraft.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.teampotato.redirectionor.Redirectionor;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.block.*;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.tileentity.ChestTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.DualBrightnessCallback;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = ChestTileEntityRenderer.class, priority = 10)
public abstract class ChestTileEntityRendererMixin<T extends TileEntity & IChestLid> extends TileEntityRenderer<T> {
    @Shadow(remap = false) protected abstract RenderMaterial getMaterial(T tileEntity, ChestType chestType);
    @Shadow @Final private ModelRenderer doubleRightLid;
    @Shadow @Final private ModelRenderer doubleRightLock;
    @Shadow @Final private ModelRenderer doubleRightBottom;
    @Shadow @Final private ModelRenderer doubleLeftBottom;
    @Shadow @Final private ModelRenderer doubleLeftLock;
    @Shadow @Final private ModelRenderer doubleLeftLid;
    @Shadow @Final private ModelRenderer lid;
    @Shadow @Final private ModelRenderer lock;
    @Shadow @Final private ModelRenderer bottom;
    @Shadow protected abstract void render(MatrixStack pMatrixStack, IVertexBuilder pBuffer, ModelRenderer pChestLid, ModelRenderer pChestLatch, ModelRenderer pChestBottom, float pLidAngle, int pCombinedLight, int pCombinedOverlay);
    public ChestTileEntityRendererMixin(TileEntityRendererDispatcher p_i226006_1_) {
        super(p_i226006_1_);
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     * why can't it find target method...
     */
    @Overwrite(remap = false)
    public void render(T pBlockEntity, float pPartialTicks, MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pCombinedLight, int pCombinedOverlay) {
        World world = pBlockEntity.getLevel();
        boolean flag = world != null;
        BlockState blockstate = flag ? pBlockEntity.getBlockState() : Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Redirectionor.SOUTH);
        ChestType chesttype = blockstate.hasProperty(ChestBlock.TYPE) ? blockstate.getValue(ChestBlock.TYPE) : ChestType.SINGLE;
        Block block = blockstate.getBlock();
        if (block instanceof AbstractChestBlock) {
            pMatrixStack.pushPose();
            float f = blockstate.getValue(ChestBlock.FACING).toYRot();
            pMatrixStack.translate(0.5D, 0.5D, 0.5D);
            pMatrixStack.mulPose(Vector3f.YP.rotationDegrees(-f));
            pMatrixStack.translate(-0.5D, -0.5D, -0.5D);
            TileEntityMerger.ICallbackWrapper<? extends ChestTileEntity> icallbackwrapper;
            if (flag) {
                icallbackwrapper = ((AbstractChestBlock<?>)block).combine(blockstate, world, pBlockEntity.getBlockPos(), true);
            } else {
                icallbackwrapper = TileEntityMerger.ICallback::acceptNone;
            }

            float f1 = icallbackwrapper.<Float2FloatFunction>apply(ChestBlock.opennessCombiner(pBlockEntity)).get(pPartialTicks);
            f1 = 1.0F - f1;
            f1 = 1.0F - f1 * f1 * f1;
            int i = icallbackwrapper.<Int2IntFunction>apply(new DualBrightnessCallback<>()).applyAsInt(pCombinedLight);
            IVertexBuilder ivertexbuilder = this.getMaterial(pBlockEntity, chesttype).buffer(pBuffer, RenderType::entityCutout);
            if (chesttype != ChestType.SINGLE) {
                if (chesttype == ChestType.LEFT) {
                    this.render(pMatrixStack, ivertexbuilder, this.doubleRightLid, this.doubleRightLock, this.doubleRightBottom, f1, i, pCombinedOverlay);
                } else {
                    this.render(pMatrixStack, ivertexbuilder, this.doubleLeftLid, this.doubleLeftLock, this.doubleLeftBottom, f1, i, pCombinedOverlay);
                }
            } else {
                this.render(pMatrixStack, ivertexbuilder, this.lid, this.lock, this.bottom, f1, i, pCombinedOverlay);
            }

            pMatrixStack.popPose();
        }
    }
}
