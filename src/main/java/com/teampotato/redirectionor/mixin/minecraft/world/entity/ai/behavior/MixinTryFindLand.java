package com.teampotato.redirectionor.mixin.minecraft.world.entity.ai.behavior;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.ai.behavior.TryFindLand;
import net.minecraft.world.entity.ai.behavior.TryLaySpawnOnWaterNearLand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({TryFindLand.class, TryLaySpawnOnWaterNearLand.class})
public abstract class MixinTryFindLand {
    @Redirect(method = "start*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
