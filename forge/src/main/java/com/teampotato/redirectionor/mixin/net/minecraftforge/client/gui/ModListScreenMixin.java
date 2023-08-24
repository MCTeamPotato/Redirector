package com.teampotato.redirectionor.mixin.net.minecraftforge.client.gui;

import net.minecraftforge.client.gui.ModListScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ModListScreen.class, remap = false)
public abstract class ModListScreenMixin {
    @Unique
  private static final ModListScreen.SortType[] SORT_TYPES = ModListScreen.SortType.values();
    @Redirect(method = "resortMods", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/client/gui/ModListScreen$SortType;values()[Lnet/minecraftforge/client/gui/ModListScreen$SortType;"))
    private ModListScreen.SortType[] redirectModListScreenSortType() {
        return SORT_TYPES;
    }
}
