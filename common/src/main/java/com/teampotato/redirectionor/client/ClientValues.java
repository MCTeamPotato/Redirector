package com.teampotato.redirectionor.client;

import net.minecraft.client.gui.screens.advancements.AdvancementTabType;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.chat.report.ReportReason;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.tutorial.TutorialSteps;

public final class ClientValues {
    
    public static final ServerData.ServerPackStatus[] SERVER_PACK_STATUSES = ServerData.ServerPackStatus.values();
    
    public static final AdvancementTabType[] ADVANCEMENT_TAB_TYPES = AdvancementTabType.values();
    
    public static final ReportReason[] REPORT_REASONS = ReportReason.values();
    
    public static final BlockModel.GuiLight[] BLOCK_MODEL_GUI_LIGHTS = BlockModel.GuiLight.values();
    
    public static final Sound.Type[] SOUND_TYPES = Sound.Type.values();
    
    public static final TutorialSteps[] TUTORIAL_STEPS = TutorialSteps.values();
}
