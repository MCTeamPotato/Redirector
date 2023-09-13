package com.teampotato.redirector.forge.mixin.net.minecraftforge.fml.client.gui.screen;

import com.teampotato.redirector.forge.utils.ClientValues;
import net.minecraftforge.fml.client.gui.screen.ModListScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ModListScreen.class, remap = false)
public abstract class ModListScreenMixin {
    @Redirect(method = "resortMods", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/fml/client/gui/screen/ModListScreen$SortType;values()[Lnet/minecraftforge/fml/client/gui/screen/ModListScreen$SortType;"))
    private ModListScreen.SortType[] redirectModListScreenSortTypes() {
        return ClientValues.SORT_TYPES;
    }
}
