package com.teampotato.redirector.mixin.net.minecraft.network.chat;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.network.chat.ChatType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ChatType.class)
public abstract class ChatTypeMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static ChatType getForIndex(byte id) {
        return CommonMaps.CHAT_TYPE_ID_MAP.getOrDefault(id, ChatType.CHAT);
    }
}
