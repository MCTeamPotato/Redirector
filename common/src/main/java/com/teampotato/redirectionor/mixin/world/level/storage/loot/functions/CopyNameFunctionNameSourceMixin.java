package com.teampotato.redirectionor.mixin.world.level.storage.loot.functions;

import com.teampotato.redirectionor.common.Maps;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(CopyNameFunction.NameSource.class)
public abstract class CopyNameFunctionNameSourceMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static CopyNameFunction.NameSource getByName(String string) {
        return Maps.STRING_NAME_SOURCE_MAP.get(string);
    }
}
