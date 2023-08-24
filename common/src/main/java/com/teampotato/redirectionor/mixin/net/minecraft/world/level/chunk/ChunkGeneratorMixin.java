package com.teampotato.redirectionor.mixin.net.minecraft.world.level.chunk;

import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChunkGenerator.class)
public abstract class ChunkGeneratorMixin {
    @Unique
    static final GenerationStep.Decoration[] GENERATION_STEP_DECORATIONS = GenerationStep.Decoration.values();
    @Redirect(method = "applyBiomeDecoration", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/GenerationStep$Decoration;values()[Lnet/minecraft/world/level/levelgen/GenerationStep$Decoration;"))
    private GenerationStep.Decoration[] redirectGenerationStepDecoration() {
        return GENERATION_STEP_DECORATIONS;
    }
}
