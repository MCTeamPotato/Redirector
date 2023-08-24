package com.Hileb.as_a_creeper_hileb.client;

import com.Hileb.as_a_creeper_hileb.handler.ExtraRenderPlayerStatic;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @Project AsACreeper
 * @Author Hileb
 * @Date 2023/8/17 16:14
 *
 **/
/**{@link net.minecraft.client.renderer.entity.RenderCreeper#}**/
@Mixin(RenderPlayer.class)
public abstract class ExtraRenderPlayer{

    @Inject(method = "getColorMultiplier",at = @At("HEAD"),cancellable = true)
    public void onGetColorMultiplier(AbstractClientPlayer entitylivingbaseIn, float lightBrightness, float partialTickTime, CallbackInfoReturnable<Integer> call)
    {
        int a= ExtraRenderPlayerStatic.getColorMultiplier(entitylivingbaseIn,lightBrightness,partialTickTime);
        if (a!=0){
            call.setReturnValue(a);
        }
    }

    @Inject(method = "preRenderCallback(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V",at =  @At("HEAD"))
    public void preRenderCallback(AbstractClientPlayer entitylivingbaseIn, float partialTickTime, CallbackInfo ci)
    {
        ExtraRenderPlayerStatic.preRenderCallback((RenderPlayer)(Object)this,entitylivingbaseIn,partialTickTime);
    }
}
