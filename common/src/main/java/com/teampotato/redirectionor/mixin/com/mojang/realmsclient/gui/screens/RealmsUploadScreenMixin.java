package com.teampotato.redirectionor.mixin.com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.Unit;
import com.mojang.realmsclient.gui.screens.RealmsUploadScreen;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = RealmsUploadScreen.class, remap = false)
public abstract class RealmsUploadScreenMixin {
    @Unique private static final Unit[] redirectionor$UNITS = Unit.values();
    @Dynamic
    @Redirect(method = {"method_22106", "m_90131_"}, at = @At(value = "INVOKE", target = "Lcom/mojang/realmsclient/Unit;values()[Lcom/mojang/realmsclient/Unit;"))
    private Unit[] redirectUnitValues() {
        return redirectionor$UNITS;
    }
}
