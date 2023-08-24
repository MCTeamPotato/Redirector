package com.teampotato.redirectionor.mixin.net.minecraftforge.client.model.geometry;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraftforge.client.model.geometry.UnbakedGeometryHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = UnbakedGeometryHelper.class, remap = false)
public abstract class UnbakedGeometryHelperMixin {
    @Redirect(method = "lambda$createUnbakedItemMaskElements$1", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirectionValues() {
        return Redirectionor.DIRECTIONS;
    }
}
