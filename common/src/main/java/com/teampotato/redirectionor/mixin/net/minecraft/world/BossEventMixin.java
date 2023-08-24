package com.teampotato.redirectionor.mixin.net.minecraft.world;

import net.minecraft.world.BossEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class BossEventMixin {
  private static final BossEvent.BossBarColor[] BOSS_EVENT_BOSS_BAR_COLORS = BossEvent.BossBarColor.values();
  private static final BossEvent.BossBarOverlay[] BOSS_EVENT_BOSS_BAR_OVERLAYS = BossEvent.BossBarOverlay.values();
    @Mixin(BossEvent.BossBarColor.class)
    public abstract static class BossBarColorMixin {
        @Redirect(method = "byName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/BossEvent$BossBarColor;values()[Lnet/minecraft/world/BossEvent$BossBarColor;"))
        private static BossEvent.BossBarColor[] redirectBossEventBossBarColor() {
            return BOSS_EVENT_BOSS_BAR_COLORS;
        }
    }

    @Mixin(BossEvent.BossBarOverlay.class)
    public static abstract class BossBarOverlayMixin {
        @Redirect(method = "byName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/BossEvent$BossBarOverlay;values()[Lnet/minecraft/world/BossEvent$BossBarOverlay;"))
        private static BossEvent.BossBarOverlay[] redirectBossEventBossBarColor() {
            return BOSS_EVENT_BOSS_BAR_OVERLAYS;
        }
    }
}
