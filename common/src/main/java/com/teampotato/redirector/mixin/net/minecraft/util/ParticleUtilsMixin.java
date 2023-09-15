package com.teampotato.redirector.mixin.net.minecraft.util;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.core.Direction;
import net.minecraft.util.ParticleUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ParticleUtils.class)
public abstract class ParticleUtilsMixin {
    @Redirect(method = "spawnParticlesOnBlockFaces", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirections() {
        return CommonValues.DIRECTIONS;
    }
}
