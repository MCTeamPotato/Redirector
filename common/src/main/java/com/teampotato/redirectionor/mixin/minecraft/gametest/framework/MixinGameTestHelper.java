package com.teampotato.redirectionor.mixin.minecraft.gametest.framework;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.gametest.framework.GameTestHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameTestHelper.class)
public abstract class MixinGameTestHelper {
    @Redirect(method = "useBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/player/Player;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }
}
