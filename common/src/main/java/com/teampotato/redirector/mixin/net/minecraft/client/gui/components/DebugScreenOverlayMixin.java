package com.teampotato.redirector.mixin.net.minecraft.client.gui.components;

import com.teampotato.redirector.redirect.CommonValues;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.levelgen.Heightmap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DebugScreenOverlay.class)
public abstract class DebugScreenOverlayMixin {
    @Redirect(method = "getGameInformation", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/Heightmap$Types;values()[Lnet/minecraft/world/level/levelgen/Heightmap$Types;"))
    private Heightmap.Types[] redirectHeightmapTypes() {
        return CommonValues.HEIGHT_MAP_TYPES;
    }

    @Redirect(method = "getGameInformation", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/MobCategory;values()[Lnet/minecraft/world/entity/MobCategory;"))
    private MobCategory[] redirectMobCategories() {
        return CommonValues.MOB_CATEGORIES;
    }
}
