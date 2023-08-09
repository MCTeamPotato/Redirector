package com.teampotato.redirectionor.mixin.world.level.storage.loot.functions;

import com.teampotato.redirectionor.common.Maps;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(CopyNbtFunction.MergeStrategy.class)
public abstract class CopyNbtFunctionMergeStrategyMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static CopyNbtFunction.MergeStrategy getByName(String string) {
        return Maps.STRING_MERGE_STRATEGY_MAP.get(string);
    }
}
