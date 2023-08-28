package com.teampotato.redirectionor;

import net.minecraft.core.Direction;
import net.minecraft.core.Direction8;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.JigsawBlockEntity;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

public class Redirectionor {
    public static final InteractionHand[] INTERACTION_HANDS = InteractionHand.values();
    public static final SoundSource[] SOUND_SOURCES = SoundSource.values();
    public static final Heightmap.Types[] HEIGHTMAP_TYPES = Heightmap.Types.values();
    public static final MobCategory[] MOB_CATEGORIES = MobCategory.values();
    public static final Difficulty[] DIFFICULTIES = Difficulty.values();
    public static final JigsawBlockEntity.JointType[] JIGSAW_BLOCK_ENTITY_JOINT_TYPES = JigsawBlockEntity.JointType.values();
    public static final Boat.Type[] BOAT_TYPES = Boat.Type.values();
    public static final Direction[] DIRECTIONS = Direction.values();
    public static final DyeColor[] DYE_COLORS = DyeColor.values();
    public static final GameType[] GAME_TYPES = GameType.values();
    public static final EquipmentSlot[] EQUIPMENT_SLOTS = EquipmentSlot.values();
    public static final Rotation[] ROTATIONS = Rotation.values();
    public static final Direction8[] DIRECTION_8_S = Direction8.values();
    public static final GenerationStep.Carving[] GENERATION_STEP_CARVINGS = GenerationStep.Carving.values();
    public static final BlockPathTypes[] BLOCK_PATH_TYPES = BlockPathTypes.values();
}
