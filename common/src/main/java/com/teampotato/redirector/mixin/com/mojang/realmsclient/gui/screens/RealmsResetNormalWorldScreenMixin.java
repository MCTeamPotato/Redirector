package com.teampotato.redirector.mixin.com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.gui.screens.RealmsResetNormalWorldScreen;
import com.mojang.realmsclient.util.LevelType;
import com.teampotato.redirector.utils.values.ClientValues;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RealmsResetNormalWorldScreen.class)
public abstract class RealmsResetNormalWorldScreenMixin {
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lcom/mojang/realmsclient/util/LevelType;values()[Lcom/mojang/realmsclient/util/LevelType;"))
    private LevelType[] redirectLevelTypes() {
        return ClientValues.LEVEL_TYPES;
    }
}
