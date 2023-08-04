package com.teampotato.redirectionor.mixin.world.ticks;

import com.teampotato.redirectionor.references.TickPriorityReferences;
import net.minecraft.world.ticks.TickPriority;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TickPriority.class)
public abstract class TickPriorityMixin {
    @Redirect(method = "byValue", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/ticks/TickPriority;values()[Lnet/minecraft/world/ticks/TickPriority;"))
    private static TickPriority[] redirectTickPriorityValues() {
        return TickPriorityReferences.TICK_PRIORITIES;
    }
}
