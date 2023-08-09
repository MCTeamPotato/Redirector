package com.teampotato.redirectionor.mixin.world.level.storage.loot;

import com.teampotato.redirectionor.common.Maps;
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
    public static LootContext.EntityTarget getByName(String string) {
        return Maps.STRING_ENTITY_TARGET_MAP.get(string);
    }
}
