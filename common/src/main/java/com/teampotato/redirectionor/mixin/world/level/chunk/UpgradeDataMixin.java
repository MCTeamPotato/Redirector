package com.teampotato.redirectionor.mixin.world.level.chunk;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction8;
import net.minecraft.world.level.chunk.UpgradeData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(UpgradeData.class)
public abstract class UpgradeDataMixin {
    @Redirect(method = "<init>(Lnet/minecraft/nbt/CompoundTag;Lnet/minecraft/world/level/LevelHeightAccessor;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction8;values()[Lnet/minecraft/core/Direction8;"))
    private Direction8[] redirectDirection8() {
        return Values.DIRECTION_8_S;
    }

    @Redirect(method = "upgradeSides", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirectionStatic() {
        return Values.DIRECTIONS;
    }

    @Redirect(method = "upgradeInside", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirection() {
        return Values.DIRECTIONS;
    }
}
