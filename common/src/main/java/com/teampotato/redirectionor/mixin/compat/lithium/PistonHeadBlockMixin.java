package com.teampotato.redirectionor.mixin.compat.lithium;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PistonHeadBlock.class)
public abstract class PistonHeadBlockMixin {
    @Redirect(method = "makeShapes", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirection() {
        return Values.DIRECTIONS;
    }
}
