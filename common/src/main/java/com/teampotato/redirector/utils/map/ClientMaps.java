package com.teampotato.redirector.utils.map;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.tutorial.TutorialSteps;

import java.util.Map;

public class ClientMaps {
    public static final Map<String, BlockModel.GuiLight> GUI_LIGHT_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        GUI_LIGHT_NAME_MAP.put("front", BlockModel.GuiLight.FRONT);
        GUI_LIGHT_NAME_MAP.put("side", BlockModel.GuiLight.SIDE);
    }

    public static final Map<String, TutorialSteps> TUTORIAL_STEPS_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        for (TutorialSteps tutorialSteps : TutorialSteps.values()) {
            TUTORIAL_STEPS_NAME_MAP.put(tutorialSteps.getName(), tutorialSteps);
        }
    }

    public static final Map<String, Sound.Type> SOUND_TYPE_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        SOUND_TYPE_NAME_MAP.put("file", Sound.Type.FILE);
        SOUND_TYPE_NAME_MAP.put("event", Sound.Type.SOUND_EVENT);
    }
}
