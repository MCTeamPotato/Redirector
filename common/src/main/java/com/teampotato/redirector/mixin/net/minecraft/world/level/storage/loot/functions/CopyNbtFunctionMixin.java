package com.teampotato.redirector.mixin.net.minecraft.world.level.storage.loot.functions;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

public class CopyNbtFunctionMixin {
    @Mixin(CopyNbtFunction.MergeStrategy.class)
    public abstract static class MergeStrategyMixin {
        /**
         * @author Kasualix
         * @reason use faster map impl
         */
        @Overwrite
        public static CopyNbtFunction.MergeStrategy getByName(String name) {
            return CommonMaps.COPY_NBT_FUNCTION_MERGE_STRATEGY_NAME_MAP.get(name);
        }
    }


    @Mixin(CopyNameFunction.NameSource.class)
    public abstract static class NameSourceMixin {
        /**
         * @author Kasualix
         * @reason use faster map impl
         */
        @Overwrite
        public static CopyNameFunction.NameSource getByName(String name) {
            return CommonMaps.NAME_SOURCE_NAME_MAP.get(name);
        }
    }
}
