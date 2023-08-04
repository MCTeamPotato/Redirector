package com.teampotato.redirectionor.mixin.world.level.block;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.ChorusFlowerBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChorusFlowerBlock.class)
public abstract class ChorusFlowerBlockMixin {
    @Redirect(method = {"randomTick", "canSurvive"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Plane;HORIZONTAL:Lnet/minecraft/core/Direction$Plane;"))
    private Direction.Plane redirectPlaneHORIZONTAL() {
        return DirectionReferences.PlaneReferences.HORIZONTAL;
    }

    @Redirect(method = {"allNeighborsEmpty", "growTreeRecursive"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Plane;HORIZONTAL:Lnet/minecraft/core/Direction$Plane;"))
    private static Direction.Plane redirectPlaneHORIZONTALStatic() {
        return DirectionReferences.PlaneReferences.HORIZONTAL;
    }
}
