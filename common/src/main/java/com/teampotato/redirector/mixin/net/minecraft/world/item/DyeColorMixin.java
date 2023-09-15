package com.teampotato.redirector.mixin.net.minecraft.world.item;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DyeColor.class)
public abstract class DyeColorMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Contract("_,!null->!null;_,null->_")
    @Overwrite
    public static @Nullable DyeColor byName(String translationKey, DyeColor fallback) {
        return CommonMaps.DYE_COLOR_NAME_MAP.getOrDefault(translationKey, fallback);
    }
}