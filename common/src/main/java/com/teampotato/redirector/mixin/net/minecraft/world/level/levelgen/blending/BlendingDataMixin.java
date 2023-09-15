package com.teampotato.redirector.mixin.net.minecraft.world.level.levelgen.blending;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.core.Direction8;
import net.minecraft.world.level.levelgen.blending.BlendingData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlendingData.class)
public abstract class BlendingDataMixin {
    @Redirect(method = "sideByGenerationAge", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction8;values()[Lnet/minecraft/core/Direction8;"))
    private static Direction8[] redirectDirection8s() {
        return CommonValues.DIRECTION_8_S;
    }
}
