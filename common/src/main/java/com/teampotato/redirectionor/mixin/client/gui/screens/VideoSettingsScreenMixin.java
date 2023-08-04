package com.teampotato.redirectionor.mixin.client.gui.screens;

import com.teampotato.redirectionor.references.GraphicsStatusReferences;
import net.minecraft.client.GraphicsStatus;
import net.minecraft.client.gui.screens.VideoSettingsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VideoSettingsScreen.class)
public abstract class VideoSettingsScreenMixin {
    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/client/GraphicsStatus;FABULOUS:Lnet/minecraft/client/GraphicsStatus;"))
    private GraphicsStatus redirectGraphicsStatusFABULOUS() {
        return GraphicsStatusReferences.FABULOUS;
    }
}
