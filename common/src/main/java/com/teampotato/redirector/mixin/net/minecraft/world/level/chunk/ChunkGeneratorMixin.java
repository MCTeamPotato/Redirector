package com.teampotato.redirector.mixin.net.minecraft.world.level.chunk;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChunkGenerator.class)
public abstract class ChunkGeneratorMixin {
    @Redirect(method = "applyBiomeDecoration", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/GenerationStep$Decoration;values()[Lnet/minecraft/world/level/levelgen/GenerationStep$Decoration;"))
    private GenerationStep.Decoration[] redirectGenerationStepDecorations() {
        return CommonValues.DECORATIONS;
    }
}
