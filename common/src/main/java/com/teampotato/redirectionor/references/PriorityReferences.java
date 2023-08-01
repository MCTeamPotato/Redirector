package com.teampotato.redirectionor.references;

import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import net.minecraft.world.level.chunk.storage.IOWorker;

public final class PriorityReferences {
    public static final IOWorker.Priority[] PRIORITIES = IOWorker.Priority.values();
    public static final IOWorker.Priority HIGH = IOWorker.Priority.HIGH;
    public static final IOWorker.Priority LOW = IOWorker.Priority.LOW;

    public static final class OrdinalReferences {
        public static final int HIGH_ORDINAL = HIGH.ordinal();
        public static final int LOW_ORDINAL = LOW.ordinal();

        public static final Object2IntLinkedOpenHashMap<IOWorker.Priority> ORDINAL_MAP = new Object2IntLinkedOpenHashMap<>();

        static {
            ORDINAL_MAP.put(HIGH, HIGH_ORDINAL);
            ORDINAL_MAP.put(LOW, LOW_ORDINAL);
        }
    }
}
