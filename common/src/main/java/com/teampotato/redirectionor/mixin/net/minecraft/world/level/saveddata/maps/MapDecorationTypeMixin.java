package com.teampotato.redirectionor.mixin.net.minecraft.world.level.saveddata.maps;

import net.minecraft.world.level.saveddata.maps.MapDecoration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MapDecoration.Type.class)
public abstract class MapDecorationTypeMixin {
    @Unique
  private static final MapDecoration.Type[] MAP_DECORARION_TYPE = MapDecoration.Type.values();
    @Redirect(method = "byIcon", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/saveddata/maps/MapDecoration$Type;values()[Lnet/minecraft/world/level/saveddata/maps/MapDecoration$Type;"))
    private static MapDecoration.Type[] redirectMapDecorationType() {
        return MAP_DECORARION_TYPE;
    }
}
