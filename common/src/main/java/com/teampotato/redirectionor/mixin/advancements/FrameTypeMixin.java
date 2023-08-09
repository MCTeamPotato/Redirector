package com.teampotato.redirectionor.mixin.advancements;

import com.teampotato.redirectionor.common.Maps;
import net.minecraft.advancements.FrameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(FrameType.class)
public abstract class FrameTypeMixin {

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static FrameType byName(String string) {
        return Maps.STRING_FRAME_TYPE_MAP.get(string);
    }
}