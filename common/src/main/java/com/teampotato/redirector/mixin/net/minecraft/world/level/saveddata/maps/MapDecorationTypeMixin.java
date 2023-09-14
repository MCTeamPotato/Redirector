package com.teampotato.redirector.mixin.net.minecraft.world.level.saveddata.maps;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MapDecoration.Type.class)
public abstract class MapDecorationTypeMixin {
    @Redirect(method = "byIcon", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/saveddata/maps/MapDecoration$Type;values()[Lnet/minecraft/world/level/saveddata/maps/MapDecoration$Type;"))
    private static MapDecoration.Type[] redirectMapDecorationTypes() {
        return CommonValues.MAP_DECORATION_TYPES;
    }
}
