package com.teampotato.redirector.mixin.net.minecraft.world.level.block.entity;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.world.level.block.entity.BannerPattern;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BannerPattern.class)
public abstract class BannerPatternMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    @Nullable
    public static BannerPattern byHash(String hash) {
        return CommonMaps.BANNER_PATTERN_HASH_NAME_MAP.get(hash);
    }

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    @Nullable
    public static BannerPattern byFilename(String string) {
        return CommonMaps.BANNER_PATTERN_FILE_NAME_MAP.get(string);
    }
}
