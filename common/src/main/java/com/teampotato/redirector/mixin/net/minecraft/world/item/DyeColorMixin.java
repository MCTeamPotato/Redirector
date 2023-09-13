package com.teampotato.redirector.mixin.net.minecraft.world.item;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DyeColor.class)
public abstract class DyeColorMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static DyeColor byName(String translationKey, DyeColor fallback) {
        return CommonMaps.DYE_COLOR_NAME_MAP.getOrDefault(translationKey, fallback);
    }
}
