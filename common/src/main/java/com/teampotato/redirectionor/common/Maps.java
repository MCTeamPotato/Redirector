package com.teampotato.redirectionor.common;

import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.FrameType;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.block.entity.JigsawBlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.ticks.TickPriority;

import java.util.Map;

public final class Maps {
    public static final Map<String, FrameType> STRING_FRAME_TYPE_MAP = new Object2ObjectOpenHashMap<>();
    public static final Map<Integer, ChatFormatting> INTEGER_CHAT_FORMATTING_MAP = new Int2ObjectOpenHashMap<>();
    public static final Map<Character, ChatFormatting> CHARACTER_CHAT_FORMATTING_MAP = new Char2ObjectOpenHashMap<>();
    
    public static final Map<String, BossEvent.BossBarColor> STRING_BOSS_BAR_COLOR_MAP = new Object2ObjectOpenHashMap<>();
    
    public static final Map<String, BossEvent.BossBarOverlay> STRING_BOSS_BAR_OVERLAY_MAP = new Object2ObjectOpenHashMap<>();
    
    public static final Map<String, EquipmentSlot> STRING_EQUIPMENT_SLOT_MAP = new Object2ObjectOpenHashMap<>();
    
    public static final Map<EquipmentSlot.Type, EquipmentSlot> TYPE_EQUIPMENT_SLOT_MAP = new Object2ObjectOpenHashMap<>();
    
    public static final Map<String, JigsawBlockEntity.JointType> STRING_JOINT_TYPE_MAP = new Object2ObjectOpenHashMap<>();
    
    public static final Map<String, LootContext.EntityTarget> STRING_ENTITY_TARGET_MAP = new Object2ObjectOpenHashMap<>();
    
    public static final Map<String, CopyNameFunction.NameSource> STRING_NAME_SOURCE_MAP = new Object2ObjectOpenHashMap<>();
    
    public static final Map<String, CopyNbtFunction.MergeStrategy> STRING_MERGE_STRATEGY_MAP = new Object2ObjectOpenHashMap<>();
    
    public static final Map<Integer, TickPriority> INTEGER_TICK_PRIORITY_MAP = new Int2ObjectOpenHashMap<>();

    static {
        for (FrameType frameType : Values.FRAME_TYPES) {
            STRING_FRAME_TYPE_MAP.put(frameType.getName(), frameType);
        }
    }

    static {
        for (ChatFormatting chatFormatting : Values.CHAT_FORMATTINGS) {
            INTEGER_CHAT_FORMATTING_MAP.put(chatFormatting.getId(), chatFormatting);
            CHARACTER_CHAT_FORMATTING_MAP.put(chatFormatting.getChar(), chatFormatting);
        }
    }

    static {
        for (BossEvent.BossBarColor bossBarColor : Values.BOSS_EVENT_BOSS_BAR_COLORS) {
            STRING_BOSS_BAR_COLOR_MAP.put(bossBarColor.getName(), bossBarColor);
        }
    }

    static {
        for (BossEvent.BossBarOverlay bossBarOverlay : Values.BOSS_EVENT_BOSS_BAR_OVERLAYS) {
            STRING_BOSS_BAR_OVERLAY_MAP.put(bossBarOverlay.getName(), bossBarOverlay);
        }
    }

    static {
        for (EquipmentSlot equipmentSlot : Values.EQUIPMENT_SLOTS) {
            STRING_EQUIPMENT_SLOT_MAP.put(equipmentSlot.getName(), equipmentSlot);
        }
    }

    static {
        for (EquipmentSlot equipmentSlot : Values.EQUIPMENT_SLOTS) {
            TYPE_EQUIPMENT_SLOT_MAP.put(equipmentSlot.getType(), equipmentSlot);
        }
    }

    static {
        for (JigsawBlockEntity.JointType jointType : Values.JIGSAW_BLOCK_ENTITY_JOINT_TYPES) {
            STRING_JOINT_TYPE_MAP.put(jointType.getSerializedName(), jointType);
        }
    }

    static {
        for (LootContext.EntityTarget entityTarget : Values.LOOT_CONTEXT_ENTITY_TARGETS) {
            STRING_ENTITY_TARGET_MAP.put(entityTarget.name, entityTarget);
        }
    }

    static {
        for (CopyNameFunction.NameSource nameSource : Values.COPY_NAME_FUNCTION_NAME_SOURCES) {
            STRING_NAME_SOURCE_MAP.put(nameSource.name, nameSource);
        }
    }

    static {
        for (CopyNbtFunction.MergeStrategy mergeStrategy : Values.COPY_NAME_FUNCTION_MERGE_STRATEGIES) {
            STRING_MERGE_STRATEGY_MAP.put(mergeStrategy.name, mergeStrategy);
        }
    }

    static {
        for (TickPriority tickPriority : Values.TICK_PRIORITIES) {
            INTEGER_TICK_PRIORITY_MAP.put(tickPriority.getValue(), tickPriority);
        }
    }
}
