package com.teampotato.redirectionor.mixin.stats;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.world.inventory.RecipeBookType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RecipeBookSettings.class)
public abstract class RecipeBookSettingsMixin {
    @Redirect(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/RecipeBookType;values()[Lnet/minecraft/world/inventory/RecipeBookType;"))
    private RecipeBookType[] redirectRecipeBookType() {
        return Redirectionor.RECIPE_BOOK_TYPES;
    }
}
