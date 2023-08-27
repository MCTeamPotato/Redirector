package com.teampotato.redirectionor.mixin.net.minecraft.client.tutorial;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.client.tutorial.TutorialSteps;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

@Mixin(TutorialSteps.class)
public abstract class TutorialStepsMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static TutorialSteps getByName(String name) {
        TutorialSteps tutorialSteps = TUTORIAL_STEPS_NAME_MAP.get(name);
        if (tutorialSteps == null) return TutorialSteps.NONE;
        return tutorialSteps;
    }

    @Unique
    private static final Map<String, TutorialSteps> TUTORIAL_STEPS_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        for (TutorialSteps tutorialSteps : TutorialSteps.values()) {
            TUTORIAL_STEPS_NAME_MAP.put(tutorialSteps.getName(), tutorialSteps);
        }
    }
}
