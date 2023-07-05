package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.feature;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.CoralClawFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CoralClawFeature.class)
public abstract class MixinCoralClawFeature {
    @Redirect(method = "placeFeature", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }

    @Redirect(method = "placeFeature", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction$Plane;getRandomDirection(Lnet/minecraft/util/RandomSource;)Lnet/minecraft/core/Direction;"))
    private Direction implHorizontal(Direction.Plane instance, RandomSource random) {
        return Redirectionor.HORIZONTAL.getRandomDirection(random);
    }
}