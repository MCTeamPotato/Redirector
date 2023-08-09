package com.teampotato.redirectionor.mixin.chat;

import com.teampotato.redirectionor.common.Maps;
import com.teampotato.redirectionor.common.Values;
import net.minecraft.ChatFormatting;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Locale;

@Mixin(ChatFormatting.class)
public abstract class ChatFormattingMixin {

    @Redirect(method = "getNames", at = @At(value = "INVOKE", target = "Lnet/minecraft/ChatFormatting;values()[Lnet/minecraft/ChatFormatting;"))
    private static ChatFormatting[] redirectChatFormatting() {
        return Values.CHAT_FORMATTINGS;
    }

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    @Nullable
    public static ChatFormatting getById(int i) {
        if (i < 0) {
            return ChatFormatting.RESET;
        } else {
            return Maps.INTEGER_CHAT_FORMATTING_MAP.get(i);
        }
    }

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    @Nullable
    public static ChatFormatting getByCode(char c) {
        return Maps.CHARACTER_CHAT_FORMATTING_MAP.get(Character.toString(c).toLowerCase(Locale.ROOT).charAt(0));
    }
}