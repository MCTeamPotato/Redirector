package com.teampotato.redirectionor.mixin.world.level.chunk;

import com.teampotato.redirectionor.references.BlockFixersReferences;
import com.teampotato.redirectionor.references.Direction8References;
import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction8;
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

    @Redirect(method = "<init>(Lnet/minecraft/nbt/CompoundTag;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction8;values()[Lnet/minecraft/core/Direction8;"))
    private Direction8[] redirectDirection8Values() {
        return Direction8References.DIRECTION_8_S;
    }
}
