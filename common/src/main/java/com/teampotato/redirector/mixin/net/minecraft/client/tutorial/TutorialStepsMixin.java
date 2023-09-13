package com.teampotato.redirector.mixin.net.minecraft.client.tutorial;

import com.teampotato.redirector.utils.map.ClientMaps;
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
    public static TutorialSteps getByName(String name) {
        return ClientMaps.TUTORIAL_STEPS_NAME_MAP.getOrDefault(name, TutorialSteps.NONE);
    }
}
