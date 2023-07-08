package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.template;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.template.AxisAlignedLinearPosTest;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AxisAlignedLinearPosTest.class)
public abstract class AxisAlignedLinearPosTestMixin {

    @Redirect(method = "test", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$AxisDirection;POSITIVE:Lnet/minecraft/util/Direction$AxisDirection;"))
    private Direction.AxisDirection implPositive() {
        return Redirectionor.POSITIVE;
    }
}
