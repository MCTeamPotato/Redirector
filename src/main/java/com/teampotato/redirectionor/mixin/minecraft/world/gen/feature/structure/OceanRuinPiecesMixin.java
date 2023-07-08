package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Mirror;
import net.minecraft.world.gen.feature.structure.OceanRuinPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class OceanRuinPiecesMixin {
    @Mixin(OceanRuinPieces.class)
    public abstract static class MixinMain {
        @Redirect(method = {"addClusterRuins"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;NONE:Lnet/minecraft/util/Mirror;"))
        private static Mirror implMirrorNone() {
            return Redirectionor.MIRROR_NONE;
        }
    }

    @Mixin(OceanRuinPieces.Piece.class)
    public abstract static class MixinPiece {
        @Redirect(method = {"loadTemplate", "postProcess"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;NONE:Lnet/minecraft/util/Mirror;"))
        private static Mirror implMirrorNone() {
            return Redirectionor.MIRROR_NONE;
        }
    }
}
