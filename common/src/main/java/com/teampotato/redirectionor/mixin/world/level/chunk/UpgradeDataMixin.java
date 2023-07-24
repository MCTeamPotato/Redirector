package com.teampotato.redirectionor.mixin.world.level.chunk;

import com.teampotato.redirectionor.references.BlockFixersReferences;
import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import net.minecraft.world.level.chunk.UpgradeData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(UpgradeData.class)
public abstract class UpgradeDataMixin {
    @Redirect(method = "upgradeSides", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirectionValuesStatic() {
        return DirectionReferences.DIRECTIONS;
    }

    @Redirect(method = "upgradeInside", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirectionValues() {
        return DirectionReferences.DIRECTIONS;
    }

    @Redirect(method = "updateState", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/chunk/UpgradeData$BlockFixers;DEFAULT:Lnet/minecraft/world/level/chunk/UpgradeData$BlockFixers;"))
    private static UpgradeData.BlockFixers redirectBlockFixersDEFAULT() {
        return BlockFixersReferences.DEFAULT;
    }
}
