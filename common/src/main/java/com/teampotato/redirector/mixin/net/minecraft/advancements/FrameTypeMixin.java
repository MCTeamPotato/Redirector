package com.teampotato.redirector.mixin.net.minecraft.advancements;

import com.teampotato.redirector.utils.map.CommonMaps;
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
    public static FrameType byName(String name) {
        return CommonMaps.FRAME_TYPE_NAME_MAP.get(name);
    }
}