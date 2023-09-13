package com.teampotato.redirector.mixin.net.minecraft.world.level;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GameType.class)
public abstract class GameTypeMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static GameType byId(int targetId, GameType fallback) {
        return CommonMaps.GAME_TYPE_ID_MAP.getOrDefault(targetId, fallback);
    }

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static GameType byName(String targetName, GameType fallback) {
        return CommonMaps.GAME_TYPE_NAME_MAP.getOrDefault(targetName, fallback);
    }
}
