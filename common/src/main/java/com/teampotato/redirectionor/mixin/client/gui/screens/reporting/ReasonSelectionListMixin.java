package com.teampotato.redirectionor.mixin.client.gui.screens.reporting;

import com.teampotato.redirectionor.client.ClientValues;
import net.minecraft.client.gui.screens.reporting.ReportReasonSelectionScreen;
import net.minecraft.client.multiplayer.chat.report.ReportReason;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ReportReasonSelectionScreen.ReasonSelectionList.class)
public abstract class ReasonSelectionListMixin {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/chat/report/ReportReason;values()[Lnet/minecraft/client/multiplayer/chat/report/ReportReason;"))
    private ReportReason[] redirectReportReason() {
        return ClientValues.REPORT_REASONS;
    }
}
