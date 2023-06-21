package com.teampotato.redirectionor.mixin.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractFireBlock.class)
public abstract class AbstractFireBlockMixin {
    @Redirect(method = "isPortal", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private static Direction[] implOpt() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "animateTick", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
