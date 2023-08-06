package com.teampotato.redirectionor.mixin.client.gui;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.gui.Gui;
import net.minecraft.network.chat.ChatType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Gui.class)
public abstract class GuiMixin {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/chat/ChatType;values()[Lnet/minecraft/network/chat/ChatType;"))
    private ChatType[] redirectChatType() {
        return Redirectionor.CHAT_TYPES;
    }
}
