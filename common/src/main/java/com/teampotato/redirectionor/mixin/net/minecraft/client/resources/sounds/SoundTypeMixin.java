package com.teampotato.redirectionor.mixin.net.minecraft.client.resources.sounds;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.client.resources.sounds.Sound;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

@Mixin(Sound.Type.class)
public abstract class SoundTypeMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    @Nullable
    public static Sound.Type getByName(String name) {
        return TYPE_NAME_MAP.get(name);
    }

    @Unique
    private static final Map<String, Sound.Type> TYPE_NAME_MAP = new Object2ObjectOpenHashMap<>();
    static {
        TYPE_NAME_MAP.put("file", Sound.Type.FILE);
        TYPE_NAME_MAP.put("event", Sound.Type.SOUND_EVENT);
    }
}
