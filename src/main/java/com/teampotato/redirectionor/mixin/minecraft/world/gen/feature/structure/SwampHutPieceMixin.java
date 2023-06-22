package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.structure.SwampHutPiece;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SwampHutPiece.class)
public abstract class SwampHutPieceMixin {
    @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
    private Direction implWest() {
        return Redirectionor.WEST;
    }

    @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
    private Direction implEast() {
        return Redirectionor.EAST;
    }

    @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;OUTER_LEFT:Lnet/minecraft/state/properties/StairsShape;"))
    private StairsShape implOuterLeft() {
        return Redirectionor.OUTER_LEFT;
    }

    @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;OUTER_RIGHT:Lnet/minecraft/state/properties/StairsShape;"))
    private StairsShape implOuterRight() {
        return Redirectionor.OUTER_RIGHT;
    }
}
