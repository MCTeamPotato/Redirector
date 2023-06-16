package com.teampotato.directionoptimizer.mixin.util.palette;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.util.Direction;
import net.minecraft.util.palette.UpgradeData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(UpgradeData.class)
public abstract class UpgradeDataMixin {
    @Redirect(method = "upgradeSides", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private static Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }

    @Redirect(method = "upgradeInside", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt2() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
