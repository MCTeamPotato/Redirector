package com.teampotato.redirectionor.mixin.net.minecraft.world;

import com.teampotato.redirectionor.Redirectionor;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.Difficulty;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(Difficulty.class)
public abstract class DifficultyMixin {
    @Redirect(method = "byName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/Difficulty;values()[Lnet/minecraft/world/Difficulty;"))
    private static Difficulty[] redirectDifficulty() {
        return Redirectionor.DIFFICULTIES;
    }

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
