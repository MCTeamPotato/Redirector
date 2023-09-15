package com.teampotato.redirector.mixin.net.minecraft.world.level.storage.loot;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.world.level.storage.loot.LootContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(LootContext.EntityTarget.class)
public abstract class LootContextEntityTargetMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static LootContext.EntityTarget getByName(String name) {
        return CommonMaps.ENTITY_TARGET_NAME_MAP.get(name);
    }
}
