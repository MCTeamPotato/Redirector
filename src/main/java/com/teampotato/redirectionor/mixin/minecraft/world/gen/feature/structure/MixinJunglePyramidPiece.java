package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.world.gen.feature.structure.JunglePyramidPiece;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(JunglePyramidPiece.class)
public abstract class MixinJunglePyramidPiece {
    @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/AttachFace;WALL:Lnet/minecraft/state/properties/AttachFace;"))
    private AttachFace implWall() {
        return Redirectionor.WALL;
    }
}
