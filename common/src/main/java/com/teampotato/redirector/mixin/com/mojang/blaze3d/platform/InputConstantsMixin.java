package com.teampotato.redirector.mixin.com.mojang.blaze3d.platform;

import com.mojang.blaze3d.platform.InputConstants;
import com.teampotato.redirector.utils.values.ClientValues;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(InputConstants.class)
public abstract class InputConstantsMixin {
    @Redirect(method = "getKey(Ljava/lang/String;)Lcom/mojang/blaze3d/platform/InputConstants$Key;", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/InputConstants$Type;values()[Lcom/mojang/blaze3d/platform/InputConstants$Type;"))
    private static InputConstants.Type[] redirectInputConstantsTypes() {
        return ClientValues.INPUT_CONSTANTS_TYPES;
    }
}
