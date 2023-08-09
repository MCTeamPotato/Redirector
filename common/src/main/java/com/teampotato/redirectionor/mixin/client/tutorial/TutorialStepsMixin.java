package com.teampotato.redirectionor.mixin.client.tutorial;

import com.teampotato.redirectionor.client.ClientMaps;
import net.minecraft.client.tutorial.TutorialSteps;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(TutorialSteps.class)
public abstract class TutorialStepsMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static TutorialSteps getByName(String string) {
        TutorialSteps tutorialSteps = ClientMaps.STRING_TUTORIAL_STEPS_MAP.get(string);
        if (tutorialSteps == null) return TutorialSteps.NONE;
        return tutorialSteps;
    }
}
