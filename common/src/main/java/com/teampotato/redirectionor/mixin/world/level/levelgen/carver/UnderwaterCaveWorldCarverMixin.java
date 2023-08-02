package com.teampotato.redirectionor.mixin.world.level.levelgen.carver;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.carver.UnderwaterCaveWorldCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(UnderwaterCaveWorldCarver.class)
public abstract class UnderwaterCaveWorldCarverMixin {
    @Redirect(method = "carveBlock(Lnet/minecraft/world/level/levelgen/carver/WorldCarver;Lnet/minecraft/world/level/chunk/ChunkAccess;Ljava/util/BitSet;Ljava/util/Random;Lnet/minecraft/core/BlockPos$MutableBlockPos;IIIIIIII)Z", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Plane;HORIZONTAL:Lnet/minecraft/core/Direction$Plane;"))
    private static Direction.Plane redirectPlaneHORIZONTAL() {
        return DirectionReferences.PlaneReferences.HORIZONTAL;
    }
}
