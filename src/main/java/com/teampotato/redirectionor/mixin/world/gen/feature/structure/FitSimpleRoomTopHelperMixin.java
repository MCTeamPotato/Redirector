package com.teampotato.redirectionor.mixin.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.world.gen.feature.structure.OceanMonumentPieces$FitSimpleRoomTopHelper")
public abstract class FitSimpleRoomTopHelperMixin {
    @Redirect(method = "fits", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp1() {
        return Redirectionor.UP;
    }
}
