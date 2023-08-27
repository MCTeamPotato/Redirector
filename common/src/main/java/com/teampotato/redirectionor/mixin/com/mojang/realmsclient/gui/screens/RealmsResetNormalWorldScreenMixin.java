package com.teampotato.redirectionor.mixin.com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.gui.screens.RealmsResetNormalWorldScreen;
import com.mojang.realmsclient.util.LevelType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = RealmsResetNormalWorldScreen.class, remap = false)
public abstract class RealmsResetNormalWorldScreenMixin {
    @Unique private static final LevelType[] LEVEL_TYPES = LevelType.values();
    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lcom/mojang/realmsclient/util/LevelType;values()[Lcom/mojang/realmsclient/util/LevelType;"))
    private LevelType[] redirectLevelTypeValues() {
        return LEVEL_TYPES;
    }
}
