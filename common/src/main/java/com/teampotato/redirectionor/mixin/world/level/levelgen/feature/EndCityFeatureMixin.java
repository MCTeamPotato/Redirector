package com.teampotato.redirectionor.mixin.world.level.levelgen.feature;

import com.teampotato.redirectionor.references.RotationReferences;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.EndCityFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EndCityFeature.class)
public abstract class EndCityFeatureMixin {
    @Redirect(method = "getYPositionForFeature", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;COUNTERCLOCKWISE_90:Lnet/minecraft/world/level/block/Rotation;"))
    private static Rotation redirectRotationCOUNTERCLOCKWISE_90() {
        return RotationReferences.COUNTERCLOCKWISE_90;
    }

    @Redirect(method = "getYPositionForFeature", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;CLOCKWISE_180:Lnet/minecraft/world/level/block/Rotation;"))
    private static Rotation redirectRotationCLOCKWISE_180() {
        return RotationReferences.CLOCKWISE_180;
    }

    @Redirect(method = "getYPositionForFeature", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;CLOCKWISE_90:Lnet/minecraft/world/level/block/Rotation;"))
    private static Rotation redirectRotationCLOCKWISE_90() {
        return RotationReferences.CLOCKWISE_90;
    }
}
