package com.teampotato.redirectionor.mixin.net.minecraft.world.level.storage.loot.functions;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

@Mixin(CopyNameFunction.NameSource.class)
public abstract class CopyNameFunctionNameSourceMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static CopyNameFunction.NameSource getByName(String name) {
        return NAME_SOURCE_NAME_MAP.get(name);
    }

    @Unique
    private static final Map<String, CopyNameFunction.NameSource> NAME_SOURCE_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        NAME_SOURCE_NAME_MAP.put("this", CopyNameFunction.NameSource.THIS);
        NAME_SOURCE_NAME_MAP.put("killer", CopyNameFunction.NameSource.KILLER);
        NAME_SOURCE_NAME_MAP.put("killer_player", CopyNameFunction.NameSource.KILLER_PLAYER);
        NAME_SOURCE_NAME_MAP.put("block_entity", CopyNameFunction.NameSource.BLOCK_ENTITY);
    }
}
