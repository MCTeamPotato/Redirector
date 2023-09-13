package com.teampotato.redirector.mixin.com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.Unit;
import com.mojang.realmsclient.gui.screens.RealmsUploadScreen;
import com.teampotato.redirector.utils.values.ClientValues;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RealmsUploadScreen.class)
public abstract class RealmsUploadScreenMixin {
    @Dynamic
    @Redirect(method = {"method_22106", "lambda$upload$4"}, at = @At(value = "INVOKE", target = "Lcom/mojang/realmsclient/Unit;values()[Lcom/mojang/realmsclient/Unit;"))
    private Unit[] redirectUnits() {
        return ClientValues.UNITS;
    }
}
