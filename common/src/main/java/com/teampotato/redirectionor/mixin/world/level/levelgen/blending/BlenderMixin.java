package com.teampotato.redirectionor.mixin.world.level.levelgen.blending;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.core.Direction8;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Blender.class)
public abstract class BlenderMixin {
    @Redirect(method = "addAroundOldChunksCarvingMaskFilter", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction8;values()[Lnet/minecraft/core/Direction8;"))
    private static Direction8[] redirectDirection8() {
        return Values.DIRECTION_8_S;
    }

    @Redirect(method = "addAroundOldChunksCarvingMaskFilter", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;values()[Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;"))
    private static GenerationStep.Carving[] redirectGenerationStepCarving() {
        return Values.GENERATION_STEP_CARVINGS;
    }
}
