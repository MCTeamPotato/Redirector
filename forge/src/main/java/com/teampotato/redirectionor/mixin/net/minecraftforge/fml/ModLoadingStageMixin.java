package com.teampotato.redirectionor.mixin.net.minecraftforge.fml;

import net.minecraftforge.fml.ModLoadingStage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ModLoadingStage.class, remap = false)
public abstract class ModLoadingStageMixin {
    @Unique
    private static final ModLoadingStage[] MOD_LOADING_STAGES = ModLoadingStage.values();

    @Redirect(method = "nextState", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/fml/ModLoadingStage;values()[Lnet/minecraftforge/fml/ModLoadingStage;"))
    private ModLoadingStage[] redirectModLoadingStageValues() {
        return MOD_LOADING_STAGES;
    }
}
