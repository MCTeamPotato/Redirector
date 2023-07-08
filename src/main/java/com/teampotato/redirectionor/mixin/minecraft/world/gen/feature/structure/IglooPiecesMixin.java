package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Mirror;
import net.minecraft.world.gen.feature.structure.IglooPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(IglooPieces.Piece.class)
public abstract class IglooPiecesMixin {
    @Redirect(method = {"loadTemplate", "postProcess"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;NONE:Lnet/minecraft/util/Mirror;"))
    private Mirror implMirrorNone() {
        return Redirectionor.MIRROR_NONE;
    }
}
