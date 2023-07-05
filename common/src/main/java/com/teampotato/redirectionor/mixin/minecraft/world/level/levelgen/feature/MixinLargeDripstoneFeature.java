package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.feature;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.LargeDripstoneFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public abstract class MixinLargeDripstoneFeature {

    @Mixin(LargeDripstoneFeature.class)
    public abstract static class MixinMain {
        @Redirect(method = "placeDebugMarkers", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
        private Direction implUp () {
            return Redirectionor.UP;
        }
    }

    @Mixin(targets = "net.minecraft.world.level.levelgen.feature.LargeDripstoneFeature$LargeDripstone")
    public abstract static class MixinLargeDripstone {
        @Redirect(method = {"moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary", "placeBlocks"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
        private Direction implUp1() {
            return Redirectionor.UP;
        }

        @Redirect(method = {"moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary", "placeBlocks"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
        private Direction implDown() {
            return Redirectionor.DOWN;
        }
    }
}
