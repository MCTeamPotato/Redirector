package com.teampotato.redirectionor.references;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.client.GraphicsStatus;

import java.util.Map;

public final class GraphicsStatusReferences {
    public static final GraphicsStatus FAST = GraphicsStatus.FAST;
    public static final GraphicsStatus FANCY = GraphicsStatus.FANCY;
    public static final GraphicsStatus FABULOUS = GraphicsStatus.FABULOUS;

    public static final Map<GraphicsStatus, String> STRING_MAP = new Object2ObjectLinkedOpenHashMap<>();

    static {
        STRING_MAP.put(FAST, "fast");
        STRING_MAP.put(FANCY, "fancy");
        STRING_MAP.put(FABULOUS, "fabulous");
    }
}
