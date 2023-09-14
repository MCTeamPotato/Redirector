package com.teampotato.redirector.forge.mixin.net.minecraftforge.common;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.common.ForgeHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ForgeHooks.class, remap = false)
public abstract class ForgeHooksMixin {
    @Redirect(method = "refreshBannerPatternData", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/BannerPattern;values()[Lnet/minecraft/world/level/block/entity/BannerPattern;"))
    private static BannerPattern[] redirectBannerPatterns() {
        return CommonValues.BANNER_PATTERNS;
    }

    @Redirect(method = "readTypedPackFormats", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/packs/PackType;values()[Lnet/minecraft/server/packs/PackType;"))
    private static PackType[] redirectPackTypes() {
        return CommonValues.PACK_TYPES;
    }
}
