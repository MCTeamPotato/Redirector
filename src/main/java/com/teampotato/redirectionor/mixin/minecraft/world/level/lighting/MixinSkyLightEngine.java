package com.teampotato.redirectionor.mixin.minecraft.world.level.lighting;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.lighting.SkyLightEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SkyLightEngine.class)
public abstract class MixinSkyLightEngine {
    @Redirect(method = {"checkNeighborsAfterUpdate", "checkNode"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp () {
        return Redirectionor.UP;
    }
}
