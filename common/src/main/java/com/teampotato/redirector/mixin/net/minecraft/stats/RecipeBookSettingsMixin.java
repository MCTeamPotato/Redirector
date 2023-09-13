package com.teampotato.redirector.mixin.net.minecraft.stats;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.world.inventory.RecipeBookType;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RecipeBookSettings.class)
public abstract class RecipeBookSettingsMixin {
    @Dynamic
    @Redirect(method = {"method_30182", "lambda$new$0", "func_242153_a"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/RecipeBookType;values()[Lnet/minecraft/world/inventory/RecipeBookType;"))
    private static RecipeBookType[] redirectRecipeBookSettingsDynamic() {
        return CommonValues.RECIPE_BOOK_TYPES;
    }

    @Redirect(method = "read(Lnet/minecraft/network/FriendlyByteBuf;)Lnet/minecraft/stats/RecipeBookSettings;", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/RecipeBookType;values()[Lnet/minecraft/world/inventory/RecipeBookType;"))
    private static RecipeBookType[] redirectRecipeBookSettingsStatic() {
        return CommonValues.RECIPE_BOOK_TYPES;
    }

    @Redirect(method = {"write(Lnet/minecraft/network/FriendlyByteBuf;)V", "copy", "replaceFrom"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/RecipeBookType;values()[Lnet/minecraft/world/inventory/RecipeBookType;"))
    private  RecipeBookType[] redirectRecipeBookSettings() {
        return CommonValues.RECIPE_BOOK_TYPES;
    }
}
