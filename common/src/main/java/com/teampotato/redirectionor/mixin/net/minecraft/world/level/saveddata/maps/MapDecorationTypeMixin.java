package com.teampotato.redirectionor.mixin.net.minecraft.world.level.saveddata.maps;

import net.minecraft.util.Mth;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

@Mixin(MapDecoration.Type.class)
public abstract class MapDecorationTypeMixin {
    @Unique private static final MapDecoration.Type[] MAP_DECORARION_TYPES = MapDecoration.Type.values();
    @Unique
    private static final int redirectionor$typeLength = MAP_DECORARION_TYPES.length;
    /**
     * @author Kasualix
     * @reason minor cleanup
     */
    @Overwrite
    public static MapDecoration.Type byIcon(byte iconId) {
        return MAP_DECORARION_TYPES[Mth.clamp(iconId, 0, redirectionor$typeLength - 1)];
    }
}
