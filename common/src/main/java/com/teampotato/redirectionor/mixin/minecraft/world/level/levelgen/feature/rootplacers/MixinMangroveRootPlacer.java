package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.feature.rootplacers;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MangroveRootPlacer.class)
public abstract class MixinMangroveRootPlacer {
    @Redirect(method = "placeRoots", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
