package com.teampotato.redirector.mixin.net.minecraft.client.renderer;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.entity.BannerPattern;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Sheets.class)
public abstract class SheetsMixin {
    @Redirect(method = "getAllMaterials", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/BannerPattern;values()[Lnet/minecraft/world/level/block/entity/BannerPattern;"))
    private static BannerPattern[] redirectBannerPatterns() {
        return CommonValues.BANNER_PATTERNS;
    }
}
