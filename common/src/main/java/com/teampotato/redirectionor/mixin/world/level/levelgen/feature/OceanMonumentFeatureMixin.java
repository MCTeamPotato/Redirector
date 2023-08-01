package com.teampotato.redirectionor.mixin.world.level.levelgen.feature;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.OceanMonumentFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class OceanMonumentFeatureMixin {
    @Mixin(OceanMonumentFeature.OceanMonumentStart.class)
    public abstract static class OceanMonumentStartMixin {
        @Redirect(method = "generatePieces(II)V", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Plane;HORIZONTAL:Lnet/minecraft/core/Direction$Plane;"))
        private Direction.Plane redirectPlaneHORIZONTAL() {
            return DirectionReferences.PlaneReferences.HORIZONTAL;
        }
    }
}
