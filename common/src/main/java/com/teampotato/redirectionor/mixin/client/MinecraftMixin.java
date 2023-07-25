package com.teampotato.redirectionor.mixin.client;

import com.teampotato.redirectionor.references.RenderShapeReferences;
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
}
