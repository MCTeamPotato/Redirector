package com.teampotato.redirectionor.mixin.com.mojang.blaze3d.platform;

import com.mojang.blaze3d.platform.InputConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = InputConstants.class, remap = false)
public class InputConstantsMixin {
    @Unique private static final InputConstants.Type[] redirectionor$TYPES = InputConstants.Type.values();
    @Redirect(method = "getKey(Ljava/lang/String;)Lcom/mojang/blaze3d/platform/InputConstants$Key;", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/InputConstants$Type;values()[Lcom/mojang/blaze3d/platform/InputConstants$Type;"))
    private static InputConstants.Type[] redirectInputConstantsTypeValues() {
        return redirectionor$TYPES;
    }
}
