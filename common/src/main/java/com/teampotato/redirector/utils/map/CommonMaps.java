package com.teampotato.redirector.utils.map;

import com.teampotato.redirector.utils.values.CommonValues;
import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.FrameType;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.entity.JigsawBlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.ticks.TickPriority;

import java.util.List;
import java.util.Map;

public class CommonMaps {
    public static final Map<Integer, TickPriority> TICK_PRIORITY_VALUE_MAP = new Int2ObjectOpenHashMap<>();

    static {
        for (TickPriority tickPriority : TickPriority.values()) {
            TICK_PRIORITY_VALUE_MAP.put(tickPriority.getValue(), tickPriority);
        }
    }
    public static final Map<String, CopyNameFunction.NameSource> NAME_SOURCE_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        NAME_SOURCE_NAME_MAP.put("this", CopyNameFunction.NameSource.THIS);
        NAME_SOURCE_NAME_MAP.put("killer", CopyNameFunction.NameSource.KILLER);
        NAME_SOURCE_NAME_MAP.put("killer_player", CopyNameFunction.NameSource.KILLER_PLAYER);
        NAME_SOURCE_NAME_MAP.put("block_entity", CopyNameFunction.NameSource.BLOCK_ENTITY);
    }

    public static final Map<String, CopyNbtFunction.MergeStrategy> COPY_NBT_FUNCTION_MERGE_STRATEGY_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        COPY_NBT_FUNCTION_MERGE_STRATEGY_NAME_MAP.put("replace", CopyNbtFunction.MergeStrategy.REPLACE);
        COPY_NBT_FUNCTION_MERGE_STRATEGY_NAME_MAP.put("append", CopyNbtFunction.MergeStrategy.APPEND);
        COPY_NBT_FUNCTION_MERGE_STRATEGY_NAME_MAP.put("merge", CopyNbtFunction.MergeStrategy.MERGE);
    }

    public static final Map<String, LootContext.EntityTarget> ENTITY_TARGET_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        ENTITY_TARGET_NAME_MAP.put("this", LootContext.EntityTarget.THIS);
        ENTITY_TARGET_NAME_MAP.put("killer", LootContext.EntityTarget.KILLER);
        ENTITY_TARGET_NAME_MAP.put("direct_killer", LootContext.EntityTarget.DIRECT_KILLER);
        ENTITY_TARGET_NAME_MAP.put("killer_player", LootContext.EntityTarget.KILLER_PLAYER);
    }

    public static final Map<String, JigsawBlockEntity.JointType> JOINT_TYPE_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        JOINT_TYPE_NAME_MAP.put("rollable", JigsawBlockEntity.JointType.ROLLABLE);
        JOINT_TYPE_NAME_MAP.put("aligned", JigsawBlockEntity.JointType.ALIGNED);
    }
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

    public static final Map<String, BossEvent.BossBarColor> BOSS_BAR_COLOR_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        for (BossEvent.BossBarColor bossBarColor : BossEvent.BossBarColor.values()) {
            BOSS_BAR_COLOR_NAME_MAP.put(bossBarColor.getName(), bossBarColor);
        }
    }

    public static final Map<String, BossEvent.BossBarOverlay> BOSS_BAR_OVERLAY_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        for (BossEvent.BossBarOverlay bossBarOverlay : BossEvent.BossBarOverlay.values()) {
            BOSS_BAR_OVERLAY_NAME_MAP.put(bossBarOverlay.getName(), bossBarOverlay);
        }
    }

    public static final Map<String, EquipmentSlot> EQUIPMENT_SLOT_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        for (EquipmentSlot equipmentSlot : CommonValues.EQUIPMENT_SLOTS) {
            EQUIPMENT_SLOT_NAME_MAP.put(equipmentSlot.getName(), equipmentSlot);
        }
    }

    public static final Map<String, MushroomCow.MushroomType> MUSHROOM_TYPE_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        MUSHROOM_TYPE_NAME_MAP.put("red", MushroomCow.MushroomType.RED);
        MUSHROOM_TYPE_NAME_MAP.put("brown", MushroomCow.MushroomType.BROWN);
    }

    public static final Map<String, Boat.Type> BOAT_TYPE_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        for (Boat.Type boatType : com.teampotato.redirector.utils.special.CommonValues.BOAT_TYPES) {
            BOAT_TYPE_NAME_MAP.put(boatType.getName(), boatType);
        }
    }
}
