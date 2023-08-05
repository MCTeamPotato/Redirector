package com.teampotato.redirectionor.mixin.client.tutorial;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.tutorial.TutorialSteps;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TutorialSteps.class)
public abstract class TutorialStepsMixin {
    @Redirect(method = "getByName", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/tutorial/TutorialSteps;values()[Lnet/minecraft/client/tutorial/TutorialSteps;"))
    private static TutorialSteps[] redirectTutorialSteps() {
        return Redirectionor.TUTORIAL_STEPS;
    }
}
