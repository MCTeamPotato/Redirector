package com.teampotato.redirector.mixin.net.minecraft.client.resources.sounds;

import com.teampotato.redirector.utils.map.ClientMaps;
import net.minecraft.client.resources.sounds.Sound;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Sound.Type.class)
public abstract class SoundTypeMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    @Nullable
    public static Sound.Type getByName(String name) {
        return ClientMaps.SOUND_TYPE_NAME_MAP.get(name);
    }
}
