package com.teampotato.redirector.redirect;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.ChatType;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.JigsawBlockEntity;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;

public class CommonValues {
    public static final Direction.Axis[] AXES = Direction.Axis.values();
    public static final SupportType[] SUPPORT_TYPES = SupportType.values();
    public static final Direction[] DIRECTIONS = Direction.values();
    public static final int directionsLength = DIRECTIONS.length;
    public static final SoundSource[] SOUND_SOURCES = SoundSource.values();
    public static final InteractionHand[] INTERACTION_HANDS = InteractionHand.values();
    public static final ChatType[] CHAT_TYPES = ChatType.values();
    public static final Heightmap.Types[] HEIGHT_MAP_TYPES = Heightmap.Types.values();
    public static final MobCategory[] MOB_CATEGORIES = MobCategory.values();
    public static final JigsawBlockEntity.JointType[] JOINT_TYPES = JigsawBlockEntity.JointType.values();
    public static final BannerPattern[] BANNER_PATTERNS = BannerPattern.values();
    public static final DyeColor[] DYE_COLORS = DyeColor.values();
    public static final GameType[] GAME_TYPES = GameType.values();
    public static final Difficulty[] DIFFICULTIES = Difficulty.values();
    public static final ObjectiveCriteria.RenderType[] OBJECTIVE_CRITERIA_RENDER_TYPES = ObjectiveCriteria.RenderType.values();
}
