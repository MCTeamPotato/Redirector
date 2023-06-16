package com.teampotato.directionoptimizer.mixin.state;

import com.teampotato.directionoptimizer.DirectionOptimizer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DirectionProperty.class)
public abstract class DirectionPropertyMixin {
    @Redirect(method = "create(Ljava/lang/String;Ljava/util/function/Predicate;)Lnet/minecraft/state/DirectionProperty;", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private static Direction[] implOpt1() {
        return DirectionOptimizer.DIRECTIONS;
    }
}
