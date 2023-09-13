package com.teampotato.redirector.forge.mixin.net.minecraftforge.common.data;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.data.ForgeItemTagsProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ForgeItemTagsProvider.class, remap = false)
public abstract class ForgeItemTagsProviderMixin {
    @Redirect(method = {"addColored", "func_240521_a_Colored"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/DyeColor;values()[Lnet/minecraft/world/item/DyeColor;"))
    private DyeColor[] redirectDyeColors() {
        return CommonValues.DYE_COLORS;
    }
}
