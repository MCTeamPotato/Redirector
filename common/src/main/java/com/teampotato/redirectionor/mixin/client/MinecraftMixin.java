package com.teampotato.redirectionor.mixin.client;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.client.GraphicsStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {
    @Redirect(method = "startUseItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/InteractionHand;values()[Lnet/minecraft/world/InteractionHand;"))
    private InteractionHand[] redirectInteractionHand() {
        return Values.INTERACTION_HANDS;
    }

    @Redirect(method = "useFancyGraphics", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/GraphicsStatus;getId()I", ordinal = 1))
    private static int onGetFancyID(GraphicsStatus instance) {
        return 1;
    }

    @Redirect(method = "useShaderTransparency", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/GraphicsStatus;getId()I", ordinal = 1))
    private static int onGetFabulousID(GraphicsStatus instance) {
        return 2;
    }
}
