package com.teampotato.redirector.mixin.net.minecraft.world.level.levelgen.feature;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TreeFeature.class)
public abstract class TreeFeatureMixin {
    @Redirect(method = "updateLeaves", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirections() {
        return CommonValues.DIRECTIONS;
    }
}
