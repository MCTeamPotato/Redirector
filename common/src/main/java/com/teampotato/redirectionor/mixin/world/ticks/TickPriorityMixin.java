package com.teampotato.redirectionor.mixin.world.ticks;

import com.teampotato.redirectionor.common.Maps;
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
    public static TickPriority byValue(int i) {
        TickPriority tickPriority = Maps.INTEGER_TICK_PRIORITY_MAP.get(i);
        if (tickPriority == null) {
            if (i < -3) {
                return TickPriority.EXTREMELY_HIGH;
            } else {
                return TickPriority.EXTREMELY_LOW;
            }
        }
        return tickPriority;
    }
}
