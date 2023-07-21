package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RedStoneWireBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = RedStoneWireBlock.class, priority = 2000)
public abstract class MixinRedStoneWireBlock {
    @Redirect(method = {"updateIndirectNeighbourShapes", "canSurviveOn", "getSignal"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"), require = 0)
    private Direction implUp1() {
        return Redirectionor.UP;
    }

    @Redirect(method = "onPlace", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Plane;VERTICAL:Lnet/minecraft/core/Direction$Plane;"))
    private Direction.Plane onPlace() {
        return Redirectionor.VERTICAL;
    }
}
