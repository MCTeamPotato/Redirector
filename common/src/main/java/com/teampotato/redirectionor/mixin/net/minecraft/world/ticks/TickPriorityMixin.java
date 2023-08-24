package com.teampotato.redirectionor.mixin.net.minecraft.world.ticks;

import net.minecraft.world.ticks.TickPriority;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TickPriority.class)
public abstract class TickPriorityMixin {
    @Unique
  private static final TickPriority[] TICK_PRIORITIES = TickPriority.values();
    @Redirect(method = "byValue", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/ticks/TickPriority;values()[Lnet/minecraft/world/ticks/TickPriority;"))
    private static TickPriority[] redirectTickPriority() {
        return TICK_PRIORITIES;
    }
}
