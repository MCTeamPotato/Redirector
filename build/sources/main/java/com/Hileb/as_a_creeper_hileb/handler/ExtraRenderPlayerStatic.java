package com.Hileb.as_a_creeper_hileb.handler;

import com.Hileb.as_a_creeper_hileb.item.ItemSkullBoom;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.util.math.MathHelper;

/**
 * @Project AsACreeper
 * @Author Hileb
 * @Date 2023/8/17 19:05
 **/
public class ExtraRenderPlayerStatic {

    public static int getColorMultiplier(AbstractClientPlayer entitylivingbaseIn, float lightBrightness, float partialTickTime)
    {
        int r=0;
        if (ItemSkullBoom.isPlayerUsingItem(entitylivingbaseIn)){
            float f = entitylivingbaseIn.getItemInUseCount()+partialTickTime;

            if ((int)(f * 10.0F) % 2 == 0)
            {
                r=0;
            }
            else
            {
                int i = (int)(f/30f * 0.2F * 255.0F);
                i = MathHelper.clamp(i, 0, 255);
                r= i << 24 | 822083583;
            }
        }
        return r;
    }
    public static void preRenderCallback(RenderPlayer renderPlayer,AbstractClientPlayer entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(0.9375F, 0.9375F, 0.9375F);
        if (ItemSkullBoom.isPlayerUsingItem(entitylivingbaseIn)){
            float f =ItemSkullBoom.getPlayerFlashIntensity(entitylivingbaseIn,partialTickTime);
            float f1 = 1.0F + MathHelper.sin(f) * f * 0.01F;
            f = MathHelper.clamp(f, 0.0F, 1.0F);
            f = f * f;
            f = f * f;
            float f2 = (1.0F + f * 0.4F) * f1;
            float f3 = (1.0F + f * 0.1F) / f1;
            GlStateManager.scale(f2, f3, f2);
            if (entitylivingbaseIn.world.getTotalWorldTime()%8>=2){
                GlStateManager.color(150*f+100,150*f+100,150*f+100);
            }
        }
    }
}
