package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.CoralClawFeature;
import net.minecraft.world.level.levelgen.feature.CoralFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;
import java.util.stream.Stream;

@Mixin(CoralClawFeature.class)
public abstract class MixinCoralClawFeature extends CoralFeature {
    public MixinCoralClawFeature(Codec<NoneFeatureConfiguration> p_65429_) {
        super(p_65429_);
    }

    @Redirect(method = "placeFeature", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }

    @Redirect(method = "placeFeature", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction$Plane;getRandomDirection(Lnet/minecraft/util/RandomSource;)Lnet/minecraft/core/Direction;"))
    private Direction implHorizontal(Direction.Plane instance, RandomSource random) {
        return Redirectionor.HORIZONTAL.getRandomDirection(random);
    }
}