package com.teampotato.redirectionor.mixin.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.LeavesBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LeavesBlock.class)
public abstract class LeavesBlockMixin {
    @Redirect(method = "updateDistance", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirection() {
        return Redirectionor.DIRECTIONS;
    }
}
