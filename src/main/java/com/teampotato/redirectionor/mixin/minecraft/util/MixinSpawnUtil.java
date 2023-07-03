package com.teampotato.redirectionor.mixin.minecraft.util;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.util.SpawnUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpawnUtil.class)
public abstract class MixinSpawnUtil {
    @Redirect(method = "moveToPossibleSpawnPosition", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private static Direction implUp() {
        return Redirectionor.UP;
    }
}
