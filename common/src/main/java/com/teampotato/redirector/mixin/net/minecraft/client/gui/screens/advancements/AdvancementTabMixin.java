package com.teampotato.redirector.mixin.net.minecraft.client.gui.screens.advancements;

import com.teampotato.redirector.redirect.ClientValues;
import net.minecraft.client.gui.screens.advancements.AdvancementTab;
import net.minecraft.client.gui.screens.advancements.AdvancementTabType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AdvancementTab.class)
public abstract class AdvancementTabMixin {
    @Redirect(method = "create", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/advancements/AdvancementTabType;values()[Lnet/minecraft/client/gui/screens/advancements/AdvancementTabType;"))
    private static AdvancementTabType[] redirectAdvancementTabTypes() {
        return ClientValues.ADVANCEMENT_TAB_TYPES;
    }
}
