package com.teampotato.redirectionor.mixin.client.multiplayer.chat.report;

import net.minecraft.client.multiplayer.chat.report.ReportReason;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ReportReason.class)
public abstract class ReportReasonMixin {
    @Unique
    private static final ReportReason[] REPORT_REASONS = ReportReason.values();
    @Redirect(method = "getTranslationById", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/chat/report/ReportReason;values()[Lnet/minecraft/client/multiplayer/chat/report/ReportReason;"))
    private static ReportReason[] redirectReportReason() {
        return REPORT_REASONS;
    }
}
