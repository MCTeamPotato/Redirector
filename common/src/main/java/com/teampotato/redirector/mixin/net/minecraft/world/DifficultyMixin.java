package com.teampotato.redirector.mixin.net.minecraft.world;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.world.Difficulty;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Difficulty.class)
public abstract class DifficultyMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    @Nullable
    public static Difficulty byName(String name) {
        return CommonMaps.DIFFICULTY_NAME_MAP.get(name);
    }
}
