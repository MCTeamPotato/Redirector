package com.teampotato.redirectionor.mixin.minecraft.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BellRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BellBlockEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BellRenderer.class)
public abstract class MixinBellRenderer {
    @Shadow @Final public static Material BELL_RESOURCE_LOCATION;

    @Shadow @Final private ModelPart bellBody;

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public void render(BellBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        float f = (float)pBlockEntity.ticks + pPartialTick;
        float f1 = 0.0F;
        float f2 = 0.0F;
        if (pBlockEntity.shaking) {
            float f3 = Mth.sin(f / (float)Math.PI) / (4.0F + f / 3.0F);
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
        this.bellBody.render(pPoseStack, BELL_RESOURCE_LOCATION.buffer(pBufferSource, RenderType::entitySolid), pPackedLight, pPackedOverlay);
    }
}
