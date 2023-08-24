package com.teampotato.redirectionor.mixin.net.minecraftforge.client.gui.overlay;

import net.minecraftforge.client.gui.overlay.GuiOverlayManager;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = GuiOverlayManager.class, remap = false)
public abstract class GuiOverlayManagerMixin {
    @Unique
    private static final VanillaGuiOverlay[] VANILLA_GUI_OVERLAYS = VanillaGuiOverlay.values();
    @Redirect(method = {"preRegisterVanillaOverlays", "assignVanillaOverlayTypes"}, at = @At(value = "INVOKE", target = "Lnet/minecraftforge/client/gui/overlay/VanillaGuiOverlay;values()[Lnet/minecraftforge/client/gui/overlay/VanillaGuiOverlay;"))
    private static VanillaGuiOverlay[] redirectVanillaGuiOverlayValues() {
        return VANILLA_GUI_OVERLAYS;
    }
}
