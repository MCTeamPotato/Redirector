package com.teampotato.redirectionor.client;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.tutorial.TutorialSteps;

import java.util.Map;

public final class ClientMaps {
    public static final Map<String, TutorialSteps> STRING_TUTORIAL_STEPS_MAP = new Object2ObjectOpenHashMap<>();

    public static final Map<String, Sound.Type> STRING_TYPE_MAP = new Object2ObjectOpenHashMap<>();
    public static final Map<String, BlockModel.GuiLight> STRING_GUI_LIGHT_MAP = new Object2ObjectOpenHashMap<>();

    static {
        for (BlockModel.GuiLight guiLight : ClientValues.BLOCK_MODEL_GUI_LIGHTS) {
            STRING_GUI_LIGHT_MAP.put(guiLight.name, guiLight);
        }
    }

    static {
        for (Sound.Type type : ClientValues.SOUND_TYPES) {
            STRING_TYPE_MAP.put(type.name, type);
        }
    }

    static {
        for (TutorialSteps tutorialSteps : ClientValues.TUTORIAL_STEPS) {
            STRING_TUTORIAL_STEPS_MAP.put(tutorialSteps.getName(), tutorialSteps);
        }
    }
}
