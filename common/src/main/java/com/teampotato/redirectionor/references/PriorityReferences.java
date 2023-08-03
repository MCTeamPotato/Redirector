package com.teampotato.redirectionor.references;

import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import net.minecraft.world.level.chunk.storage.IOWorker;

public final class PriorityReferences {
    public static final IOWorker.Priority[] PRIORITIES = IOWorker.Priority.values();
    public static final IOWorker.Priority FOREGROUND = IOWorker.Priority.FOREGROUND;
    public static final IOWorker.Priority BACKGROUND = IOWorker.Priority.BACKGROUND;
    public static final IOWorker.Priority SHUTDOWN = IOWorker.Priority.SHUTDOWN;

    public static final class OrdinalReferences {
        public static final int FOREGROUND_ORDINAL = FOREGROUND.ordinal();
        public static final int BACKGROUND_ORDINAL = BACKGROUND.ordinal();
        public static final int SHUTDOWN_ORDINAL = SHUTDOWN.ordinal();

        public static final Object2IntLinkedOpenHashMap<IOWorker.Priority> ORDINAL_MAP = new Object2IntLinkedOpenHashMap<>();

        static {
            ORDINAL_MAP.put(FOREGROUND, FOREGROUND_ORDINAL);
            ORDINAL_MAP.put(BACKGROUND, BACKGROUND_ORDINAL);
            ORDINAL_MAP.put(SHUTDOWN, SHUTDOWN_ORDINAL);
        }
    }
}
