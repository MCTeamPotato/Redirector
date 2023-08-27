package com.teampotato.redirectionor.mixin.net.minecraft.world.level;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

@Mixin(GameType.class)
public abstract class GameTypeMixin {
    @Unique
    private static final Map<Integer, GameType> GAME_TYPE_ID_MAP = new Int2ObjectOpenHashMap<>();
    @Unique
    private static final Map<String, GameType> GAME_TYPE_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        for (GameType gameType : GameType.values()) {
            GAME_TYPE_ID_MAP.put(gameType.getId(), gameType);
            GAME_TYPE_NAME_MAP.put(gameType.getName(), gameType);
        }
    }

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static GameType byId(int targetId, GameType fallback) {
        GameType gameType = GAME_TYPE_ID_MAP.get(targetId);
        if (gameType == null) return fallback;
        return gameType;
    }

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static GameType byName(String targetName, GameType fallback) {
        GameType gameType = GAME_TYPE_NAME_MAP.get(targetName);
        if (gameType == null) return fallback;
        return gameType;
    }
}
