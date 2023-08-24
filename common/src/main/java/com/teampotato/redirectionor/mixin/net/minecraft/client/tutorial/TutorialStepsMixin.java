package com.teampotato.redirectionor.mixin.net.minecraft.client.tutorial;

import net.minecraft.client.tutorial.TutorialSteps;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TutorialSteps.class)
public abstract class TutorialStepsMixin {
    @Unique
    private static final TutorialSteps[] TUTORIAL_STEPS = TutorialSteps.values();
    @Redirect(method = "getByName", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/tutorial/TutorialSteps;values()[Lnet/minecraft/client/tutorial/TutorialSteps;"))
    private static TutorialSteps[] redirectTutorialSteps() {
        return TUTORIAL_STEPS;
    }
}
