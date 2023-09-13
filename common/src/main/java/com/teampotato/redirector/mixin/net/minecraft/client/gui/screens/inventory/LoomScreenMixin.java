package com.teampotato.redirector.mixin.net.minecraft.client.gui.screens.inventory;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.client.gui.screens.inventory.LoomScreen;
import net.minecraft.world.level.block.entity.BannerPattern;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LoomScreen.class)
public abstract class LoomScreenMixin {
    @Redirect(method = "renderPattern", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/BannerPattern;values()[Lnet/minecraft/world/level/block/entity/BannerPattern;"))
    private BannerPattern[] redirectBannerPatterns() {
        return CommonValues.BANNER_PATTERNS;
    }
}
