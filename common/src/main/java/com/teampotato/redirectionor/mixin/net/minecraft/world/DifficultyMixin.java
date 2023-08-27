package com.teampotato.redirectionor.mixin.net.minecraft.world;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.Difficulty;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

@Mixin(Difficulty.class)
public abstract class DifficultyMixin {
    @Unique
    private static final Map<String, Difficulty> DIFFICULTY_NAME_MAP = new Object2ObjectOpenHashMap<>();
    static {
        DIFFICULTY_NAME_MAP.put("peaceful", Difficulty.PEACEFUL);
        DIFFICULTY_NAME_MAP.put("easy", Difficulty.EASY);
        DIFFICULTY_NAME_MAP.put("normal", Difficulty.NORMAL);
        DIFFICULTY_NAME_MAP.put("hard", Difficulty.HARD);
    }

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    @Nullable
    public static Difficulty byName(String name) {
        return DIFFICULTY_NAME_MAP.get(name);
    }
}
