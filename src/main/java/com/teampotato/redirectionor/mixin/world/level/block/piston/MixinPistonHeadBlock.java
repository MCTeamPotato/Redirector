package com.teampotato.redirectionor.mixin.world.level.block.piston;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PistonHeadBlock.class)
public abstract class MixinPistonHeadBlock {
    @Redirect(method = "makeShapes", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] implValues1() {
        return Redirectionor.DIRECTIONS;
    }
}
