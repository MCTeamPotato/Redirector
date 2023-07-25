package com.teampotato.redirectionor.mixin.world.level.block;

import com.teampotato.redirectionor.references.RotationReferences;
import net.minecraft.world.level.block.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Rotation.class)
public abstract class RotationMixin {
    @Redirect(method = "getRotated", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;COUNTERCLOCKWISE_90:Lnet/minecraft/world/level/block/Rotation;", ordinal = 0))
    private Rotation redirectRotationCOUNTERCLOCKWISE_90() {
        return RotationReferences.COUNTERCLOCKWISE_90;
    }

    @Redirect(method = "getRotated", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;CLOCKWISE_180:Lnet/minecraft/world/level/block/Rotation;", ordinal = 1))
    private Rotation redirectRotationCLOCKWISE_180() {
        return RotationReferences.CLOCKWISE_180;
    }

    @Redirect(method = "getRotated", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;CLOCKWISE_90:Lnet/minecraft/world/level/block/Rotation;", ordinal = 1))
    private Rotation redirectRotationCLOCKWISE_90() {
        return RotationReferences.CLOCKWISE_90;
    }
}
