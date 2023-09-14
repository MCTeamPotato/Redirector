package com.teampotato.redirector.mixin.net.minecraft.world;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.world.BossEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

public class BossEventMixin {
    @Mixin(BossEvent.BossBarColor.class)
    public abstract static class BossBarColorMixin {
        /**
         * @author Kasualix
         * @reason use faster map impl
         */
        @Overwrite
        public static BossEvent.BossBarColor byName(String name) {
            return CommonMaps.BOSS_BAR_COLOR_NAME_MAP.getOrDefault(name, BossEvent.BossBarColor.WHITE);
        }
    }

    @Mixin(BossEvent.BossBarOverlay.class)
    public abstract static class BossBarOverlayMixin {
        /**
         * @author Kasualix
         * @reason use faster map impl
         */
        @Overwrite
        public static BossEvent.BossBarOverlay byName(String name) {
            return CommonMaps.BOSS_BAR_OVERLAY_NAME_MAP.getOrDefault(name, BossEvent.BossBarOverlay.PROGRESS);
        }
    }
}