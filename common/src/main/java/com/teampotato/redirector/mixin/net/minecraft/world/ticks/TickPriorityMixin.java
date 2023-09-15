package com.teampotato.redirector.mixin.net.minecraft.world.ticks;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.world.ticks.TickPriority;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(TickPriority.class)
public abstract class TickPriorityMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static TickPriority byValue(int priority) {
        TickPriority tickPriority = CommonMaps.TICK_PRIORITY_VALUE_MAP.get(priority);
        if (tickPriority == null) {
            if (priority < TickPriority.EXTREMELY_HIGH.getValue()) return TickPriority.EXTREMELY_HIGH;
            return TickPriority.EXTREMELY_LOW;
        }
        return tickPriority;
    }
}
