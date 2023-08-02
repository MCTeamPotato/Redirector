package com.teampotato.redirectionor.mixin.world.level.levelgen.structure;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.NetherBridgePieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class NetherBridgePiecesMixin {
    @Mixin(NetherBridgePieces.BridgeCrossing.class)
    public abstract static class BridgeCrossingMixin {
        @Redirect(method = "<init>(Ljava/util/Random;II)V", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Plane;HORIZONTAL:Lnet/minecraft/core/Direction$Plane;"))
        private Direction.Plane redirectPlaneHORIZONTAL() {
            return DirectionReferences.PlaneReferences.HORIZONTAL;
        }
    }
}
