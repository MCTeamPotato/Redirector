package com.teampotato.redirectionor.mixin.world.level.levelgen.feature;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.EndPodiumFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EndPodiumFeature.class)
public abstract class EndPodiumFeatureMixin {
    @Redirect(method = "place", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Plane;HORIZONTAL:Lnet/minecraft/core/Direction$Plane;"))
    private Direction.Plane redirectPlaneHORIZONTAL() {
        return DirectionReferences.PlaneReferences.HORIZONTAL;
    }
}
