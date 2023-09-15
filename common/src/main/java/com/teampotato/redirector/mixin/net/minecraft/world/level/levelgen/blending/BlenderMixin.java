package com.teampotato.redirector.mixin.net.minecraft.world.level.levelgen.blending;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Blender.class)
public abstract class BlenderMixin {
    @Redirect(method = "addAroundOldChunksCarvingMaskFilter", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;values()[Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;"))
    private static GenerationStep.Carving[] redirectGenerationStepCarvings() {
        return CommonValues.GENERATION_STEP_CARVINGS;
    }
}
