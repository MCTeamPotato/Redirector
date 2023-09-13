package com.teampotato.redirector.mixin.net.minecraft.world.level.chunk.storage;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.level.chunk.storage.ChunkSerializer;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChunkSerializer.class)
public abstract class ChunkSerializerMixin {
    @Redirect(method = "write", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;values()[Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;"))
    private static GenerationStep.Carving[] redirectGenerationStepCarving() {
        return CommonValues.GENERATION_STEP_CARVINGS;
    }
}
