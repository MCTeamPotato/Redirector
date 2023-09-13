package com.teampotato.redirector.mixin.net.minecraft.world.level.levelgen.feature;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.level.levelgen.feature.MineshaftFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MineshaftFeature.Type.class)
public abstract class MineshaftFeatureTypeMixin {
    @Redirect(method = "byId", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/feature/MineshaftFeature$Type;values()[Lnet/minecraft/world/level/levelgen/feature/MineshaftFeature$Type;"))
    private static MineshaftFeature.Type[] redirectMineshaftFeatureTypes() {
        return CommonValues.MINESHAFT_FEATURE_TYPES;
    }
}
