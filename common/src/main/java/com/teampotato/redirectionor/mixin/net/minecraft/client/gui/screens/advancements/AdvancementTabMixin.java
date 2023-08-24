package com.teampotato.redirectionor.mixin.net.minecraft.client.gui.screens.advancements;

import net.minecraft.client.gui.screens.advancements.AdvancementTab;
import net.minecraft.client.gui.screens.advancements.AdvancementTabType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AdvancementTab.class)
public abstract class AdvancementTabMixin {
    @Unique
    private static final AdvancementTabType[] ADVANCEMENT_TAB_TYPES = AdvancementTabType.values();
    @Redirect(method = "create", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/advancements/AdvancementTabType;values()[Lnet/minecraft/client/gui/screens/advancements/AdvancementTabType;"))
    private static AdvancementTabType[] redirctAdvancementTabType() {
        return ADVANCEMENT_TAB_TYPES;
    }
}
