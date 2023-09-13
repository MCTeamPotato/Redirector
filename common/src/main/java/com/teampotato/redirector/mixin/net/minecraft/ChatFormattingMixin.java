package com.teampotato.redirector.mixin.net.minecraft;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.ChatFormatting;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Collection;
import java.util.Locale;

@Mixin(ChatFormatting.class)
public abstract class ChatFormattingMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    @Nullable
    public static ChatFormatting getById(int index) {
        if (index < 0) return ChatFormatting.RESET;
        return CommonMaps.CHAT_FORMATTING_INDEX_MAP.get(index);
    }

    /**
     * @author Kasualix
     * @reason use faster list impl
     */
    @Overwrite
    public static Collection<String> getNames(boolean getColor, boolean getFancyStyling) {
        if (getColor) {
            if (getFancyStyling) {
                return CommonMaps.CHAT_FORMATTING_LIST_WITH_IS_FORMAT_OR_COLOR;
            } else {
                return CommonMaps.CHAT_FORMATTING_LIST_WITH_IS_COLOR;
            }
        } else {
            return CommonMaps.CHAT_FORMATTING_LIST_WITH_IS_FORMAT;
        }
    }

    @Mixin(ChatFormatting.class)
    public static abstract class Client {
        /**
         * @author Kasualix
         * @reason use faster map impl
         */
        @SuppressWarnings("OverwriteModifiers")
        @Overwrite
        @Nullable
        public static ChatFormatting getByCode(char formattingCode) {
            return CommonMaps.CHAT_FORMATTING_CODE_MAP.get(Character.toString(formattingCode).toLowerCase(Locale.ROOT).charAt(0));
        }
    }
}
