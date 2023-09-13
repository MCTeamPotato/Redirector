package com.teampotato.redirector.mixin.net.minecraft.world.inventory;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.inventory.LoomMenu;
import net.minecraft.world.level.block.entity.BannerPattern;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LoomMenu.class)
public abstract class LoomMenuMixin {
    @Redirect(method = "setupResultSlot", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/BannerPattern;values()[Lnet/minecraft/world/level/block/entity/BannerPattern;"))
    private BannerPattern[] redirectBannerPatterns() {
        return CommonValues.BANNER_PATTERNS;
    }
}
