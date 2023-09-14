package com.teampotato.redirector.mixin.net.minecraft.world.level.levelgen.feature;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.RuinedPortalFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RuinedPortalFeature.class)
public abstract class RuinedPortalFeatureMixin {
    @Redirect(method = "pieceGeneratorSupplier", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Rotation;values()[Lnet/minecraft/world/level/block/Rotation;"))
    private static Rotation[] redirectRotations() {
        return CommonValues.ROTATIONS;
    }
}
