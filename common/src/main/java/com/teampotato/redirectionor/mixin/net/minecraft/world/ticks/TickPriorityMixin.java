package com.teampotato.redirectionor.mixin.net.minecraft.world.ticks;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.ticks.TickPriority;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

@Mixin(TickPriority.class)
public abstract class TickPriorityMixin {
    @Unique
    private static final Map<Integer, TickPriority> TICK_PRIORITY_ID_MAP = new Int2ObjectOpenHashMap<>();

    static {
        for (TickPriority tickPriority : TickPriority.values()) {
            TICK_PRIORITY_ID_MAP.put(tickPriority.getValue(), tickPriority);
        }
    }

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static TickPriority byValue(int value) {
        TickPriority tickPriority =  TICK_PRIORITY_ID_MAP.get(value);
        if (tickPriority == null) {
            if (value < TickPriority.EXTREMELY_HIGH.getValue()) {
                return TickPriority.EXTREMELY_HIGH;
            }
            return TickPriority.EXTREMELY_LOW;
        }
        return tickPriority;
    }
}
