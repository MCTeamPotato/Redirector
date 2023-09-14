package com.teampotato.redirector.mixin.net.minecraft.world.level.levelgen.feature;

import net.minecraft.world.level.levelgen.feature.MineshaftFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MineshaftFeature.Type.class)
public abstract class MineshaftFeatureTypeMixin {
    @Unique
    private static MineshaftFeature.Type[] MINESHAFT_FEATURE_TYPES = null;

    @Redirect(method = "byId", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/feature/MineshaftFeature$Type;values()[Lnet/minecraft/world/level/levelgen/feature/MineshaftFeature$Type;"))
    private static MineshaftFeature.Type[] redirectMineshaftFeatureTypes() {
        if (MINESHAFT_FEATURE_TYPES == null) MINESHAFT_FEATURE_TYPES = MineshaftFeature.Type.values();;
        return MINESHAFT_FEATURE_TYPES;
    }
}
