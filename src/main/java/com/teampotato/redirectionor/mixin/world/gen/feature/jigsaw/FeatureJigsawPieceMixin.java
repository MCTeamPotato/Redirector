package com.teampotato.redirectionor.mixin.world.gen.feature.jigsaw;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.jigsaw.FeatureJigsawPiece;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FeatureJigsawPiece.class)
public abstract class FeatureJigsawPieceMixin {
    @Redirect(method = "getShuffledJigsawBlocks", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}
