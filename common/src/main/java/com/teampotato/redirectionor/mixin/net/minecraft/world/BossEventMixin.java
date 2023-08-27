package com.teampotato.redirectionor.mixin.net.minecraft.world;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.BossEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

public class BossEventMixin {
    @Mixin(BossEvent.BossBarColor.class)
    public abstract static class BossBarColorMixin {
        @Unique
        private static final Map<String, BossEvent.BossBarColor> BOSS_BAR_COLOR_NAME_MAP = new Object2ObjectOpenHashMap<>();
        static {
            for (BossEvent.BossBarColor bossBarOverlay : BossEvent.BossBarColor.values()) {
                BOSS_BAR_COLOR_NAME_MAP.put(bossBarOverlay.getName(), bossBarOverlay);
            }
        }
        /**
         * @author Kasualix
         * @reason use faster map impl
         */
        @Overwrite
        public static BossEvent.BossBarColor byName(String name) {
            BossEvent.BossBarColor bossBarColor = BOSS_BAR_COLOR_NAME_MAP.get(name);
            if (bossBarColor == null) return BossEvent.BossBarColor.WHITE;
            return bossBarColor;
        }
    }

    @Mixin(BossEvent.BossBarOverlay.class)
    public static abstract class BossBarOverlayMixin {
        @Unique
        private static final Map<String, BossEvent.BossBarOverlay> BOSS_BAR_OVERLAY_NAME_MAP = new Object2ObjectOpenHashMap<>();
        static {
            for (BossEvent.BossBarOverlay bossBarOverlay : BossEvent.BossBarOverlay.values()) {
                BOSS_BAR_OVERLAY_NAME_MAP.put(bossBarOverlay.getName(), bossBarOverlay);
            }
        }

        /**
         * @author Kasualix
         * @reason use faster map impl
         */
        @Overwrite
        public static BossEvent.BossBarOverlay byName(String name) {
            BossEvent.BossBarOverlay bossBarOverlay = BOSS_BAR_OVERLAY_NAME_MAP.get(name);
            if (bossBarOverlay == null) return BossEvent.BossBarOverlay.PROGRESS;
            return bossBarOverlay;
        }
    }
}
