package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Mirror;
import net.minecraft.world.gen.feature.structure.NetherFossilStructures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class NetherFossilStructuresMixin {
    @Mixin(NetherFossilStructures.Piece.class)
    public abstract static class MixinPiece {

        @Redirect(method = {"loadTemplate"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;NONE:Lnet/minecraft/util/Mirror;"))
        private Mirror implMirrorNone() {
            return Redirectionor.MIRROR_NONE;
        }
    }
}
