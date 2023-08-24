package com.teampotato.redirectionor.mixin.net.minecraft.client.multiplayer.chat.report;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.multiplayer.chat.report.ReportReason;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;

@Mixin(ReportReason.class)
public abstract class ReportReasonMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    @Nullable
    public static Component getTranslationById(int id) {
        ReportReason reportReason = REPORT_REASON_ID_MAP.get(id);
        if (reportReason == null) return null;
        return reportReason.title();
    }

    @Unique
    private static final Map<Integer, ReportReason> REPORT_REASON_ID_MAP = new Int2ObjectOpenHashMap<>();

    static {
        for (ReportReason reportReason : ReportReason.values()) {
            REPORT_REASON_ID_MAP.put(reportReason.id, reportReason);
        }
    }
}
