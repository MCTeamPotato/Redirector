package com.teampotato.redirectionor.mixin.net.minecraft.world.level.storage.loot;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.storage.loot.LootContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

@Mixin(LootContext.EntityTarget.class)
public abstract class LootContextEntityTargetMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static LootContext.EntityTarget getByName(String name) {
        if (ENTITY_TARGET_NAME_MAP.isEmpty()) {
            ENTITY_TARGET_NAME_MAP.put("this", LootContext.EntityTarget.THIS);
            ENTITY_TARGET_NAME_MAP.put("killer", LootContext.EntityTarget.KILLER);
            ENTITY_TARGET_NAME_MAP.put("direct_killer", LootContext.EntityTarget.DIRECT_KILLER);
            ENTITY_TARGET_NAME_MAP.put("killer_player", LootContext.EntityTarget.KILLER_PLAYER);
        }
        return ENTITY_TARGET_NAME_MAP.get(name);
    }

    @Unique
    private static final Map<String, LootContext.EntityTarget> ENTITY_TARGET_NAME_MAP = new Object2ObjectOpenHashMap<>();
}
