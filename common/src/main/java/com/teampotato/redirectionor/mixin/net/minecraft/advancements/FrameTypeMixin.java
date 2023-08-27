package com.teampotato.redirectionor.mixin.net.minecraft.advancements;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.advancements.FrameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

@Mixin(FrameType.class)
public abstract class FrameTypeMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static FrameType byName(String name) {
        return FRAME_TYPE_NAME_MAP.get(name);
    }

    @Unique
    private static final Map<String, FrameType> FRAME_TYPE_NAME_MAP = new Object2ObjectOpenHashMap<>();
    static {
        FRAME_TYPE_NAME_MAP.put("task", FrameType.TASK);
        FRAME_TYPE_NAME_MAP.put("challenge", FrameType.CHALLENGE);
        FRAME_TYPE_NAME_MAP.put("goal", FrameType.GOAL);
    }
}