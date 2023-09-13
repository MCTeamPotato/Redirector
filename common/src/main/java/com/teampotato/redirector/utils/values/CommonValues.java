package com.teampotato.redirector.utils.values;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.ChatType;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.CommandBlockEntity;
import net.minecraft.world.level.block.entity.JigsawBlockEntity;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.levelgen.Heightmap;

public class CommonValues {
    public static final Direction[] DIRECTIONS = Direction.values();
    public static final Direction.Axis[] AXES = Direction.Axis.values();
    public static final InteractionHand[] INTERACTION_HANDS = InteractionHand.values();
    public static final SoundSource[] SOUND_SOURCES = SoundSource.values();
    public static final ChatType[] CHAT_TYPES = ChatType.values();
    public static final Heightmap.Types[] HEIGHT_MAP_TYPES = Heightmap.Types.values();
    public static final MobCategory[] MOB_CATEGORIES = MobCategory.values();
    public static final Difficulty[] DIFFICULTIES = Difficulty.values();
    public static final CommandBlockEntity.Mode[] COMMAND_BLOCK_ENTITY_MODES = CommandBlockEntity.Mode.values();
    public static final JigsawBlockEntity.JointType[] JOINT_TYPES = JigsawBlockEntity.JointType.values();
    public static final BannerPattern[] BANNER_PATTERNS = BannerPattern.values();
    public static final Mirror[] MIRRORS = Mirror.values();
    public static final Boat.Type[] BOAT_TYPES = Boat.Type.values();
    public static final DyeColor[] DYE_COLORS = DyeColor.values();
    public static final GameType[] GAME_TYPES = GameType.values();
    public static final DripstoneThickness[] DRIPSTONE_THICKNESSES = DripstoneThickness.values();
}
