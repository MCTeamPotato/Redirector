package com.teampotato.redirectionor.mixin.minecraft.world.level.chunk;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.chunk.UpgradeData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(UpgradeData.class)
public abstract class MixinUpgradeData {
    @Redirect(method = "upgradeSides", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] implValues1() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "upgradeInside", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] implValues2() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "upgradeSides", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
    private static Direction implEast() {
        return Redirectionor.EAST;
    }
}
