package com.teampotato.redirectionor.mixin.net.minecraft.chat;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.ChatFormatting;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Mixin(ChatFormatting.class)
public abstract class ChatFormattingMixin {
    @Unique private static final Map<Integer, ChatFormatting> CHAT_FORMATTING_ID_MAP = new Int2ObjectOpenHashMap<>();
    @Unique private static final Map<Character, ChatFormatting> CHAT_FORMATTING_CODE_MAP = new Char2ObjectOpenHashMap<>();

    @Unique private static final List<String> COLORFUL_CHAT_FORMATTINGS = new ObjectArrayList<>();
    @Unique private static final List<String> FANCY_CHAT_FORMATTINGS = new ObjectArrayList<>();
    @Unique private static final List<String> FANCY_AND_COLORFUL_CHAT_FORMATTINGS = new ObjectArrayList<>();


    @Unique private static final ChatFormatting[] CHAT_FORMATTINGS = ChatFormatting.values();

    static {
        for (ChatFormatting chatFormatting : CHAT_FORMATTINGS) {
            if (chatFormatting.isColor()) COLORFUL_CHAT_FORMATTINGS.add(chatFormatting.getName());
            if (chatFormatting.isFormat()) FANCY_CHAT_FORMATTINGS.add(chatFormatting.getName());
            CHAT_FORMATTING_CODE_MAP.put(chatFormatting.getChar(), chatFormatting);
            CHAT_FORMATTING_ID_MAP.put(chatFormatting.getId(), chatFormatting);
        }
        FANCY_AND_COLORFUL_CHAT_FORMATTINGS.addAll(COLORFUL_CHAT_FORMATTINGS);
        FANCY_AND_COLORFUL_CHAT_FORMATTINGS.addAll(FANCY_CHAT_FORMATTINGS);
    }

    /**
     * @author Kasualix
     * @reason cache the lists
     */
    @Overwrite
    public static Collection<String> getNames(boolean getColor, boolean getFancyStyling) {
        if (getColor) {
            if (getFancyStyling) {
                return FANCY_AND_COLORFUL_CHAT_FORMATTINGS;
            } else {
                return COLORFUL_CHAT_FORMATTINGS;
            }
        } else if (getFancyStyling) {
            return FANCY_CHAT_FORMATTINGS;
        }
        return Lists.newArrayList();
    }

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    @Nullable
    public static ChatFormatting getByCode(char formattingCode) {
        return CHAT_FORMATTING_CODE_MAP.get(Character.toString(formattingCode).toLowerCase(Locale.ROOT).charAt(0));
    }


    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    @Nullable
    public static ChatFormatting getById(int index) {
        if (index < 0) {
            return ChatFormatting.RESET;
        } else {
            return CHAT_FORMATTING_ID_MAP.get(index);
        }
    }
}