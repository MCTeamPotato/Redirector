package com.teampotato.redirectionor.mixin.world.level.levelgen.blending;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Blender.class)
public abstract class BlenderMixin {

    @Redirect(method = "addAroundOldChunksCarvingMaskFilter", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;values()[Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;"))
    private static GenerationStep.Carving[] redirectGenerationStepCarving() {
        return Redirectionor.GENERATION_STEP_CARVINGS;
    }
}
