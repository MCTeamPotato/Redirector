package com.teampotato.redirector.mixin.net.minecraft.world.level.biome;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Biome.class)
public abstract class BiomeMixin {
    @Redirect(method = "generate", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/GenerationStep$Decoration;values()[Lnet/minecraft/world/level/levelgen/GenerationStep$Decoration;"))
    private GenerationStep.Decoration[] redirectGenerationStepDecorations() {
        return CommonValues.GENERATION_STEP_DECORATIONS;
    }
}
