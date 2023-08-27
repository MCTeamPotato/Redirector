package com.teampotato.redirectionor.mixin.net.minecraft.world.level.storage.loot.functions;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(CopyNbtFunction.MergeStrategy.class)
public abstract class CopyNbtFunctionMergeStrategyMixin {
    @Unique private static final CopyNbtFunction.MergeStrategy[] COPY_NAME_FUNCTION_MERGE_STRATEGIES = CopyNbtFunction.MergeStrategy.values();
    @Redirect(method = "getByName", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/loot/functions/CopyNbtFunction$MergeStrategy;values()[Lnet/minecraft/world/level/storage/loot/functions/CopyNbtFunction$MergeStrategy;"))
    private static CopyNbtFunction.MergeStrategy[] redirectCopyNbtFunctionMergeStrategy() {
        return COPY_NAME_FUNCTION_MERGE_STRATEGIES;
    }

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static CopyNbtFunction.MergeStrategy getByName(String name) {
        return MERGE_STRATEGY_NAME_MAP.get(name);
    }

    @Unique
    private static final Map<String, CopyNbtFunction.MergeStrategy> MERGE_STRATEGY_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        MERGE_STRATEGY_NAME_MAP.put("replace", CopyNbtFunction.MergeStrategy.REPLACE);
        MERGE_STRATEGY_NAME_MAP.put("append", CopyNbtFunction.MergeStrategy.APPEND);
        MERGE_STRATEGY_NAME_MAP.put("merge", CopyNbtFunction.MergeStrategy.MERGE);
    }
}
