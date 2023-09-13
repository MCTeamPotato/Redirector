package com.teampotato.redirector.utils.map;

import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.FrameType;

import java.util.List;
import java.util.Map;

public class CommonMaps {
    public static final Map<Integer, ChatFormatting> CHAT_FORMATTING_INDEX_MAP = new Int2ObjectOpenHashMap<>();
    public static final Map<Character, ChatFormatting> CHAT_FORMATTING_CODE_MAP = new Char2ObjectOpenHashMap<>();
    public static final List<String> CHAT_FORMATTING_LIST_WITH_IS_COLOR = new ObjectArrayList<>();
    public static final List<String> CHAT_FORMATTING_LIST_WITH_IS_FORMAT = new ObjectArrayList<>();
    public static final List<String> CHAT_FORMATTING_LIST_WITH_IS_FORMAT_OR_COLOR = new ObjectArrayList<>();

    static {
        for (ChatFormatting chatFormatting : ChatFormatting.values()) {
            String name = chatFormatting.getName();
            CHAT_FORMATTING_INDEX_MAP.put(chatFormatting.getId(), chatFormatting);
            CHAT_FORMATTING_CODE_MAP.put(chatFormatting.getChar(), chatFormatting);
            if (chatFormatting.isColor()) CHAT_FORMATTING_LIST_WITH_IS_COLOR.add(name);
            if (chatFormatting.isFormat()) CHAT_FORMATTING_LIST_WITH_IS_FORMAT.add(name);
            if (chatFormatting.isFormat() || chatFormatting.isColor()) CHAT_FORMATTING_LIST_WITH_IS_FORMAT_OR_COLOR.add(name);
        }
    }

    public static final Map<String, FrameType> FRAME_TYPE_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        for (FrameType frameType : FrameType.values()) {
            FRAME_TYPE_NAME_MAP.put(frameType.getName(), frameType);
        }
    }
}
