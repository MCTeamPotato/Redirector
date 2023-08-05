package com.teampotato.redirectionor.mixin.client.multiplayer.chat.report;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.multiplayer.chat.report.ReportReason;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ReportReason.class)
public abstract class ReportReasonMixin {
    @Redirect(method = "getTranslationById", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/chat/report/ReportReason;values()[Lnet/minecraft/client/multiplayer/chat/report/ReportReason;"))
    private static ReportReason[] redirectReportReason() {
        return Redirectionor.REPORT_REASONS;
    }
}
