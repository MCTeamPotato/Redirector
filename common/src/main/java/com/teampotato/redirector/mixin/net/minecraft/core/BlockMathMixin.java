package com.teampotato.redirector.mixin.net.minecraft.core;

import com.teampotato.redirector.redirect.CommonValues;
import net.minecraft.core.BlockMath;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockMath.class)
public abstract class BlockMathMixin {
    @Dynamic
    @Redirect(method = {"method_23222", "func_229381_a_", "lambda$static$1"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirectionsStatic() {
        return CommonValues.DIRECTIONS;
    }
}
