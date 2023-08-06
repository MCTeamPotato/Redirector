package com.teampotato.redirectionor.mixin.world.level.levelgen;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.levelgen.DensityFunctions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DensityFunctions.class)
public abstract class DensityFunctionsMixin {
    @Redirect(method = "bootstrap",at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/DensityFunctions$TwoArgumentSimpleFunction$Type;values()[Lnet/minecraft/world/level/levelgen/DensityFunctions$TwoArgumentSimpleFunction$Type;"))
    private static DensityFunctions.TwoArgumentSimpleFunction.Type[] redirectDensityFunctionsTwoArgumentSimpleFunctionType() {
        return Redirectionor.DENSITY_FUNCTIONS_TWO_ARGUMENT_SIMPLE_FUNCTION_TYPES;
    }

    @Redirect(method = "bootstrap", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/DensityFunctions$Marker$Type;values()[Lnet/minecraft/world/level/levelgen/DensityFunctions$Marker$Type;"))
    private static DensityFunctions.Marker.Type[] redirectDensityFunctionsMarkerType() {
        return Redirectionor.DENSITY_FUNCTIONS_MARKER_TYPES;
    }

    @Redirect(method = "bootstrap", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/DensityFunctions$Mapped$Type;values()[Lnet/minecraft/world/level/levelgen/DensityFunctions$Mapped$Type;"))
    private static DensityFunctions.Mapped.Type[] redirectDensityFunctionsMappedType() {
        return Redirectionor.DENSITY_FUNCTIONS_MAPPED_TYPES;
    }
}
