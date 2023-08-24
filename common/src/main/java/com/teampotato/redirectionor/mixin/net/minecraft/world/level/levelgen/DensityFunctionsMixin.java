package com.teampotato.redirectionor.mixin.net.minecraft.world.level.levelgen;

import net.minecraft.world.level.levelgen.DensityFunctions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DensityFunctions.class)
public abstract class DensityFunctionsMixin {
    @Unique
  private static final DensityFunctions.Marker.Type[] DENSITY_FUNCTIONS_MARKER_TYPES = DensityFunctions.Marker.Type.values();
    @Redirect(method = "bootstrap", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/DensityFunctions$Marker$Type;values()[Lnet/minecraft/world/level/levelgen/DensityFunctions$Marker$Type;"))
    private static DensityFunctions.Marker.Type[] redirectDensityFunctionsMarkerType() {
        return DENSITY_FUNCTIONS_MARKER_TYPES;
    }
}
