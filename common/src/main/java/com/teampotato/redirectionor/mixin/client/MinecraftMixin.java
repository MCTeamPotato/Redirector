package com.teampotato.redirectionor.mixin.client;

import com.teampotato.redirectionor.references.RenderShapeReferences;
import net.minecraft.client.GraphicsStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.RenderShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {
    @Redirect(method = "selfTest", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;MODEL:Lnet/minecraft/world/level/block/RenderShape;"))
    private RenderShape redirectRenderShapeMODEL() {
        return RenderShapeReferences.MODEL;
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
