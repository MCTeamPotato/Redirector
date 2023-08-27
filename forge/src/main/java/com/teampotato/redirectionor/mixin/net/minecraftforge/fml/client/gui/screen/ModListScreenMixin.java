package com.teampotato.redirectionor.mixin.net.minecraftforge.fml.client.gui.screen;

import net.minecraftforge.fml.client.gui.screen.ModListScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ModListScreen.class, remap = false)
public abstract class ModListScreenMixin {
    @Unique
    private static final ModListScreen.SortType[] SORT_TYPES = ModListScreen.SortType.values();
    @Redirect(method = "resortMods", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/fml/client/gui/screen/ModListScreen$SortType;values()[Lnet/minecraftforge/fml/client/gui/screen/ModListScreen$SortType;"))
    private ModListScreen.SortType[] redirectSortTypeValues() {
        return SORT_TYPES;
    }
}
