package com.teampotato.redirectionor.mixin.world.level.chunk;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChunkGenerator.class)
public abstract class ChunkGeneratorMixin {
    @Redirect(method = "applyBiomeDecoration", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/GenerationStep$Decoration;values()[Lnet/minecraft/world/level/levelgen/GenerationStep$Decoration;"))
    private GenerationStep.Decoration[] redirectGenerationStepDecoration() {
        return Values.GENERATION_STEP_DECORATIONS;
    }
}
