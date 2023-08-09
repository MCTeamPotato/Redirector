package com.teampotato.redirectionor.mixin.client.resources.sounds;

import com.teampotato.redirectionor.client.ClientMaps;
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
    public static Sound.Type getByName(String string) {
        return ClientMaps.STRING_TYPE_MAP.get(string);
    }
}
