package com.teampotato.redirectionor.mixin.client.renderer;

import com.teampotato.redirectionor.references.DirectionReferences;
import com.teampotato.redirectionor.references.GraphicsStatusReferences;
import net.minecraft.client.GraphicsStatus;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LevelRenderer.class)
public abstract class LevelRendererMixin {
    @Redirect(method = "initTransparency", at = @At(value = "FIELD", target = "Lnet/minecraft/client/GraphicsStatus;FANCY:Lnet/minecraft/client/GraphicsStatus;"))
    private GraphicsStatus redirectGraphicsStatusFANCY() {
        return GraphicsStatusReferences.FANCY;
    }

    @Redirect(method = "levelEvent", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirectionValues() {
        return DirectionReferences.DIRECTIONS;
    }
}
