package com.teampotato.redirector.mixin.net.minecraft.client.gui;

import com.teampotato.redirector.redirect.CommonValues;
import net.minecraft.client.gui.Gui;
import net.minecraft.network.chat.ChatType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Gui.class)
public abstract class GuiMixin {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/chat/ChatType;values()[Lnet/minecraft/network/chat/ChatType;"))
    private ChatType[] redirectChatTypes() {
        return CommonValues.CHAT_TYPES;
    }
}
