package com.teampotato.redirectionor.mixin.net.minecraft.world.item;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

@Mixin(DyeColor.class)
public abstract class DyeColorMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    @Nullable
    @Contract(value="_,!null->!null;_,null->_")
    public static DyeColor byName(String translationKey, @Nullable DyeColor fallback) {
        DyeColor dyeColor = DYE_COLOR_NAME_MAP.get(translationKey);
        if (dyeColor == null) return fallback;
        return dyeColor;
    }

    @Unique
    private static final Map<String, DyeColor> DYE_COLOR_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        for (DyeColor dyeColor : DyeColor.values()) {
            DYE_COLOR_NAME_MAP.put(dyeColor.getName(), dyeColor);
        }
    }
}
