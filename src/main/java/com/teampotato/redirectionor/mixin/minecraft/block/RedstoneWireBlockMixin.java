package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = RedstoneWireBlock.class, priority = 2000)
public abstract class RedstoneWireBlockMixin {
    @Redirect(method = "onRemove", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "updateIndirectNeighbourShapes", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = {"getSignal", "updateIndirectNeighbourShapes", "canSurviveOn"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"), require = 0)
    private Direction implUp2() {
        return Redirectionor.UP;
    }
}
