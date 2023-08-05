package com.teampotato.redirectionor.mixin.world.ticks;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.ticks.TickPriority;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TickPriority.class)
public abstract class TickPriorityMixin {
    @Redirect(method = "byValue", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/ticks/TickPriority;values()[Lnet/minecraft/world/ticks/TickPriority;"))
    private static TickPriority[] redirectTickPriority() {
        return Redirectionor.TICK_PRIORITIES;
    }
}
