package com.teampotato.redirectionor.mixin.minecraft.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.tileentity.BellTileEntityRenderer;
import net.minecraft.tileentity.BellTileEntity;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = BellTileEntityRenderer.class, priority = 10)
public abstract class BellTileEntityRendererMixin {
    @Shadow @Final private ModelRenderer bellBody;
    @Shadow @Final public static RenderMaterial BELL_RESOURCE_LOCATION;

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public void render(BellTileEntity pBlockEntity, float pPartialTicks, MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pCombinedLight, int pCombinedOverlay) {
        float f = (float)pBlockEntity.ticks + pPartialTicks;
        float f1 = 0.0F;
        float f2 = 0.0F;
        if (pBlockEntity.shaking) {
            float f3 = MathHelper.sin(f / (float)Math.PI) / (4.0F + f / 3.0F);
            if (pBlockEntity.clickDirection == Redirectionor.NORTH) {
                f1 = -f3;
            } else if (pBlockEntity.clickDirection == Redirectionor.SOUTH) {
                f1 = f3;
            } else if (pBlockEntity.clickDirection == Redirectionor.EAST) {
                f2 = -f3;
            } else if (pBlockEntity.clickDirection == Redirectionor.WEST) {
                f2 = f3;
            }
        }

        this.bellBody.xRot = f1;
        this.bellBody.zRot = f2;
        this.bellBody.render(pMatrixStack, BELL_RESOURCE_LOCATION.buffer(pBuffer, RenderType::entitySolid), pCombinedLight, pCombinedOverlay);
    }
}
