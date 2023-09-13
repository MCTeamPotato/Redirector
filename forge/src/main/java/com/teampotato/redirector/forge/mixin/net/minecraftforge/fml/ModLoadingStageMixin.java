package com.teampotato.redirector.forge.mixin.net.minecraftforge.fml;

import com.teampotato.redirector.forge.utils.CommonValues;
import net.minecraftforge.fml.ModLoadingStage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ModLoadingStage.class, remap = false)
public abstract class ModLoadingStageMixin {
    @Redirect(method = "nextState", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/fml/ModLoadingStage;values()[Lnet/minecraftforge/fml/ModLoadingStage;"))
    private ModLoadingStage[] redirectModLoadingStages() {
        return CommonValues.MOD_LOADING_STAGES;
    }
}
