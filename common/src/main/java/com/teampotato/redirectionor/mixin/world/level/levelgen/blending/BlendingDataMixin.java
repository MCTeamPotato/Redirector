package com.teampotato.redirectionor.mixin.world.level.levelgen.blending;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.core.Direction8;
import net.minecraft.world.level.levelgen.blending.BlendingData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlendingData.class)
public abstract class BlendingDataMixin {
    @Redirect(method = "sideByGenerationAge", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction8;values()[Lnet/minecraft/core/Direction8;"))
    private static Direction8[] redirectDirection8() {
        return Values.DIRECTION_8_S;
    }
}
