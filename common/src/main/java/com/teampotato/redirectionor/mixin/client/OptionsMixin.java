package com.teampotato.redirectionor.mixin.client;

import com.teampotato.redirectionor.references.GraphicsStatusReferences;
import net.minecraft.client.GraphicsStatus;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Options.class)
public abstract class OptionsMixin {
    @Redirect(method = "load", at = @At(value = "FIELD", target = "Lnet/minecraft/client/GraphicsStatus;FANCY:Lnet/minecraft/client/GraphicsStatus;"))
    private GraphicsStatus redirectGraphicsStatusFANCY() {
        return GraphicsStatusReferences.FANCY;
    }

    @Redirect(method = "load", at = @At(value = "FIELD", target = "Lnet/minecraft/client/GraphicsStatus;FAST:Lnet/minecraft/client/GraphicsStatus;"))
    private GraphicsStatus redirectGraphicsStatusFAST() {
        return GraphicsStatusReferences.FAST;
    }
}
