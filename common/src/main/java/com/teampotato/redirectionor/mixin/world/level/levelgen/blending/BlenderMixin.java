package com.teampotato.redirectionor.mixin.world.level.levelgen.blending;

import com.teampotato.redirectionor.references.Direction8References;
import net.minecraft.core.Direction8;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Blender.class)
public abstract class BlenderMixin {
    @Redirect(method = "addAroundOldChunksCarvingMaskFilter", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction8;values()[Lnet/minecraft/core/Direction8;"))
    private static Direction8[] redirectDirection8Values() {
        return Direction8References.DIRECTION_8_S;
    }
}
