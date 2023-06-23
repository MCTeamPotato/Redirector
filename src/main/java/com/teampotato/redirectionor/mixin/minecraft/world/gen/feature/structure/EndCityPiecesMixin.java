package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class EndCityPiecesMixin {
    @Mixin(targets = "net.minecraft.world.gen.feature.structure.EndCityPieces$CityTemplate")
    public abstract static class CityTemplateMixin {
        @Redirect(method = "handleDataMarker", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
        private Direction implSouth() {
            return Redirectionor.SOUTH;
        }
    }
}
