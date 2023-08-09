package com.teampotato.redirectionor.mixin.world;

import com.teampotato.redirectionor.common.Maps;
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
        public static BossEvent.BossBarColor byName(String string) {
            BossEvent.BossBarColor bossBarColor = Maps.STRING_BOSS_BAR_COLOR_MAP.get(string);
            if (bossBarColor == null) return BossEvent.BossBarColor.WHITE;
            return bossBarColor;
        }
    }

    @Mixin(BossEvent.BossBarOverlay.class)
    public static abstract class BossBarOverlayMixin {
        /**
         * @author Kasualix
         * @reason use faster map impl
         */
        @Overwrite
        public static BossEvent.BossBarOverlay byName(String string) {
            BossEvent.BossBarOverlay bossBarOverlay = Maps.STRING_BOSS_BAR_OVERLAY_MAP.get(string);
            if (bossBarOverlay == null) return BossEvent.BossBarOverlay.PROGRESS;
            return bossBarOverlay;
        }
    }
}
