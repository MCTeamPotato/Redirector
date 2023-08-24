package com.teampotato.redirectionor.mixin.net.minecraft.chat;

import net.minecraft.ChatFormatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChatFormatting.class)
public abstract class ChatFormattingMixin {
    @Unique
    private static final ChatFormatting[] CHAT_FORMATTINGS = ChatFormatting.values();
    @Redirect(method = {"getById", "getByCode", "getNames"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/ChatFormatting;values()[Lnet/minecraft/ChatFormatting;"))
    private static ChatFormatting[] redirectChatFormatting() {
        return CHAT_FORMATTINGS;
    }
}