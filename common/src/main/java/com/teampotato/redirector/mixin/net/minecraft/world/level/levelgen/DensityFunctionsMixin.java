package com.teampotato.redirector.mixin.net.minecraft.world.level.levelgen;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.level.levelgen.DensityFunctions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DensityFunctions.class)
public abstract class DensityFunctionsMixin {
    @Redirect(method = "bootstrap", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/DensityFunctions$Marker$Type;values()[Lnet/minecraft/world/level/levelgen/DensityFunctions$Marker$Type;"))
    private static DensityFunctions.Marker.Type[] redirectDensityFunctionsMarkerTypes() {
        return CommonValues.DENSITY_FUNCTIONS_MARKER_TYPES;
    }

    @Redirect(method = "bootstrap", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/DensityFunctions$Mapped$Type;values()[Lnet/minecraft/world/level/levelgen/DensityFunctions$Mapped$Type;"))
    private static DensityFunctions.Mapped.Type[] redirectDensityFunctionsMappedTypes() {
        return CommonValues.DENSITY_FUNCTIONS_MAPPED_TYPES;
    }

    @Redirect(method = "bootstrap", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/DensityFunctions$TwoArgumentSimpleFunction$Type;values()[Lnet/minecraft/world/level/levelgen/DensityFunctions$TwoArgumentSimpleFunction$Type;"))
    private static DensityFunctions.TwoArgumentSimpleFunction.Type[] redirectDensityFunctionsTwoArgumentSimpleFunctionTypes() {
        return CommonValues.DENSITY_FUNCTIONS_TWO_ARGUMENT_SIMPLE_FUNCTION_TYPES;
    }
}
