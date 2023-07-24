package com.teampotato.redirectionor.mixin.data.models;

import com.teampotato.redirectionor.references.DirectionR;
import com.teampotato.redirectionor.references.VariantPropertiesRotationR;
import com.teampotato.redirectionor.references.properties.*;
import net.minecraft.core.Direction;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.world.level.block.state.properties.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockModelGenerators.class)
public abstract class BlockModelGeneratorsMixin {
    @Redirect(method = "createButton", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/AttachFace;FLOOR:Lnet/minecraft/world/level/block/state/properties/AttachFace;"))
    private static AttachFace redirectAttachFaceFLOORStatic() {
        return AttachFaceR.FLOOR;
    }

    @Redirect(method = {"createGrindstone", "createLever"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/AttachFace;FLOOR:Lnet/minecraft/world/level/block/state/properties/AttachFace;"))
    private AttachFace redirectAttachFaceFLOOR() {
        return AttachFaceR.FLOOR;
    }

    @Redirect(method = "createButton", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/AttachFace;WALL:Lnet/minecraft/world/level/block/state/properties/AttachFace;"))
    private static AttachFace redirectAttachFaceWALLStatic() {
        return AttachFaceR.WALL;
    }

    @Redirect(method = {"createGrindstone", "createLever"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/AttachFace;WALL:Lnet/minecraft/world/level/block/state/properties/AttachFace;"))
    private AttachFace redirectAttachFaceWALL() {
        return AttachFaceR.WALL;
    }

    @Redirect(method = "createButton", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/AttachFace;CEILING:Lnet/minecraft/world/level/block/state/properties/AttachFace;"))
    private static AttachFace redirectAttachFaceStatic() {
        return AttachFaceR.CEILING;
    }

    @Redirect(method = {"createGrindstone", "createLever"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/AttachFace;CEILING:Lnet/minecraft/world/level/block/state/properties/AttachFace;"))
    private AttachFace redirectAttachFaceCEILING() {
        return AttachFaceR.CEILING;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
    private Direction redirectDirectionEAST() {
        return DirectionR.EAST;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private Direction redirectDirectionSOUTH() {
        return DirectionR.SOUTH;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
    private Direction redirectDirectionNORTH() {
        return DirectionR.NORTH;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;WEST:Lnet/minecraft/core/Direction;"))
    private Direction redirectDirectionWEST() {
        return DirectionR.WEST;
    }

    @Redirect(method = "createFacingDispatch", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private static Direction redirectDirectionUPStatic() {
        return DirectionR.UP;
    }

    @Redirect(method = {"createColumnWithFacing", "createDispenserBlock"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction redirectDirectionUP() {
        return DirectionR.UP;
    }

    @Redirect(method = "createFacingDispatch", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private static Direction redirectDirectionDOWNStatic() {
        return DirectionR.DOWN;
    }

    @Redirect(method = {"createColumnWithFacing", "createDispenserBlock", "createHopper"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private Direction redirectDirectionDOWN() {
        return DirectionR.DOWN;
    }

    @Redirect(method = {"createRotatedPillar", "createRotatedPillarWithHorizontalVariant(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Axis;X:Lnet/minecraft/core/Direction$Axis;"))
    private static Direction.Axis redirectAxisXStatic() {
        return DirectionR.AxisR.X;
    }

    @Redirect(method = "createNetherPortalBlock", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Axis;X:Lnet/minecraft/core/Direction$Axis;"))
    private Direction.Axis redirectAxisX() {
        return DirectionR.AxisR.X;
    }

    @Redirect(method = {"createRotatedPillar", "createRotatedPillarWithHorizontalVariant(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Axis;Y:Lnet/minecraft/core/Direction$Axis;"))
    private static Direction.Axis redirectAxisY() {
        return DirectionR.AxisR.Y;
    }

    @Redirect(method = {"createRotatedPillar"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Axis;Z:Lnet/minecraft/core/Direction$Axis;"))
    private static Direction.Axis redirectAxisZStatic() {
        return DirectionR.AxisR.Z;
    }

    @Redirect(method = {"createNetherPortalBlock"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Axis;Z:Lnet/minecraft/core/Direction$Axis;"))
    private Direction.Axis redirectAxisZ() {
        return DirectionR.AxisR.Z;
    }

    @Redirect(method = "createBamboo", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BambooLeaves;SMALL:Lnet/minecraft/world/level/block/state/properties/BambooLeaves;"))
    private BambooLeaves redirectBambooLeavesSMALL() {
        return BambooLeavesR.SMALL;
    }

    @Redirect(method = "createBamboo", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BambooLeaves;LARGE:Lnet/minecraft/world/level/block/state/properties/BambooLeaves;"))
    private BambooLeaves redirectBambooLeavesLARGE() {
        return BambooLeavesR.LARGE;
    }

    @Redirect(method = "createBell", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BellAttachType;FLOOR:Lnet/minecraft/world/level/block/state/properties/BellAttachType;"))
    private BellAttachType redirectBellAttachTypeFLOOR() {
        return BellAttachTypeR.FLOOR;
    }

    @Redirect(method = "createBell", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BellAttachType;CEILING:Lnet/minecraft/world/level/block/state/properties/BellAttachType;"))
    private BellAttachType redirectBellAttachTypeCEILING() {
        return BellAttachTypeR.CEILING;
    }

    @Redirect(method = "createBell", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BellAttachType;SINGLE_WALL:Lnet/minecraft/world/level/block/state/properties/BellAttachType;"))
    private BellAttachType redirectBellAttachTypeSINGLE_WALL() {
        return BellAttachTypeR.SINGLE_WALL;
    }

    @Redirect(method = "createBell", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BellAttachType;DOUBLE_WALL:Lnet/minecraft/world/level/block/state/properties/BellAttachType;"))
    private BellAttachType redirectBellAttachTypeDOUBLE_WALL() {
        return BellAttachTypeR.DOUBLE_WALL;
    }

    @Redirect(method = "createComparator", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/ComparatorMode;COMPARE:Lnet/minecraft/world/level/block/state/properties/ComparatorMode;"))
    private ComparatorMode redirectComparatorModeCOMPARE() {
        return ComparatorModeR.COMPARE;
    }

    @Redirect(method = "createComparator", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/ComparatorMode;SUBTRACT:Lnet/minecraft/world/level/block/state/properties/ComparatorMode;"))
    private ComparatorMode redirectComparatorModeSUBTRACT() {
        return ComparatorModeR.SUBTRACT;
    }

    @Redirect(method = "configureDoorHalf", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/DoorHingeSide;LEFT:Lnet/minecraft/world/level/block/state/properties/DoorHingeSide;"))
    private static DoorHingeSide redirectDoorHingeSideLEFT() {
        return DoorHingeSideR.LEFT;
    }

    @Redirect(method = "configureDoorHalf", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/DoorHingeSide;RIGHT:Lnet/minecraft/world/level/block/state/properties/DoorHingeSide;"))
    private static DoorHingeSide redirectDoorHingeSideRIGHT() {
        return DoorHingeSideR.RIGHT;
    }

    @Redirect(method = "createDoor(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;UPPER:Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;"))
    private static DoubleBlockHalf redirectDoubleBlockHalfUPPERStatic() {
        return DoubleBlockHalfR.UPPER;
    }

    @Redirect(method = "createDoor(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;LOWER:Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;"))
    private static DoubleBlockHalf redirectDoubleBlockHalfLOWERStatic() {
        return DoubleBlockHalfR.LOWER;
    }

    @Redirect(method = "createDoubleBlock", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;UPPER:Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;"))
    private DoubleBlockHalf redirectDoubleBlockHalfUPPER() {
        return DoubleBlockHalfR.UPPER;
    }

    @Redirect(method = "createDoubleBlock", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;LOWER:Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;"))
    private DoubleBlockHalf redirectDoubleBlockHalfLOWER() {
        return DoubleBlockHalfR.LOWER;
    }

    @Redirect(method = {"createStairs", "createOrientableTrapdoor(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;", "createTrapdoor(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/Half;TOP:Lnet/minecraft/world/level/block/state/properties/Half;"))
    private static Half redirectHalfTOP() {
        return HalfR.TOP;
    }

    @Redirect(method = {"createStairs", "createOrientableTrapdoor(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;", "createTrapdoor(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/Half;BOTTOM:Lnet/minecraft/world/level/block/state/properties/Half;"))
    private static Half redirectHalfBOTTOM() {
        return HalfR.BOTTOM;
    }

    @Redirect(method = "createPistonHeads", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/PistonType;DEFAULT:Lnet/minecraft/world/level/block/state/properties/PistonType;"))
    private PistonType redirectPistonTypeDEFAULT() {
        return PistonTypeR.DEFAULT;
    }

    @Redirect(method = "createPistonHeads", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/PistonType;STICKY:Lnet/minecraft/world/level/block/state/properties/PistonType;"))
    private PistonType redirectPistonTypeSTICKY() {
        return PistonTypeR.STICKY;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;NORTH_SOUTH:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeNORTH_SOUTH() {
        return RailShapeR.NORTH_SOUTH;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;EAST_WEST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeEAST_WEST() {
        return RailShapeR.EAST_WEST;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;ASCENDING_EAST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeASCENDING_EAST() {
        return RailShapeR.ASCENDING_EAST;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;ASCENDING_WEST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeASCENDING_WEST() {
        return RailShapeR.ASCENDING_WEST;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;ASCENDING_NORTH:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeASCENDING_NORTH() {
        return RailShapeR.ASCENDING_NORTH;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;ASCENDING_SOUTH:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeASCENDING_SOUTH() {
        return RailShapeR.ASCENDING_SOUTH;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;SOUTH_EAST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeSOUTH_EAST() {
        return RailShapeR.SOUTH_EAST;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;SOUTH_WEST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeSOUTH_WEST() {
        return RailShapeR.SOUTH_WEST;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;NORTH_WEST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeNORTH_WEST() {
        return RailShapeR.NORTH_WEST;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;NORTH_EAST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeNORTH_EAST() {
        return RailShapeR.NORTH_EAST;
    }

    @Redirect(method = "createRedstoneWire", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RedstoneSide;UP:Lnet/minecraft/world/level/block/state/properties/RedstoneSide;"))
    private RedstoneSide redirectRedstoneSideUP() {
        return RedstoneSideR.UP;
    }

    @Redirect(method = "createRedstoneWire", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RedstoneSide;SIDE:Lnet/minecraft/world/level/block/state/properties/RedstoneSide;"))
    private RedstoneSide redirectRedstoneSideSIDE() {
        return RedstoneSideR.SIDE;
    }

    @Redirect(method = "createRedstoneWire", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RedstoneSide;NONE:Lnet/minecraft/world/level/block/state/properties/RedstoneSide;"))
    private RedstoneSide redirectRedstoneSideNONE() {
        return RedstoneSideR.NONE;
    }

    @Redirect(method = "createSlab", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/SlabType;TOP:Lnet/minecraft/world/level/block/state/properties/SlabType;"))
    private static SlabType redirectSlabTypeTOP() {
        return SlabTypeR.TOP;
    }

    @Redirect(method = "createSlab", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/SlabType;BOTTOM:Lnet/minecraft/world/level/block/state/properties/SlabType;"))
    private static SlabType redirectSlabTypeBOTTOM() {
        return SlabTypeR.BOTTOM;
    }

    @Redirect(method = "createSlab", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/SlabType;DOUBLE:Lnet/minecraft/world/level/block/state/properties/SlabType;"))
    private static SlabType redirectSlabTypeDOUBLE() {
        return SlabTypeR.DOUBLE;
    }

    @Redirect(method = "createStairs", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/StairsShape;STRAIGHT:Lnet/minecraft/world/level/block/state/properties/StairsShape;"))
    private static StairsShape redirectStairsShapeSTRAIGHT() {
        return StairsShapeR.STRAIGHT;
    }

    @Redirect(method = "createStairs", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/StairsShape;INNER_LEFT:Lnet/minecraft/world/level/block/state/properties/StairsShape;"))
    private static StairsShape redirectStairsShapeINNER_LEFT() {
        return StairsShapeR.INNER_LEFT;
    }

    @Redirect(method = "createStairs", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/StairsShape;INNER_RIGHT:Lnet/minecraft/world/level/block/state/properties/StairsShape;"))
    private static StairsShape redirectStairsShapeINNER_RIGHT() {
        return StairsShapeR.INNER_RIGHT;
    }

    @Redirect(method = "createStairs", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/StairsShape;OUTER_LEFT:Lnet/minecraft/world/level/block/state/properties/StairsShape;"))
    private static StairsShape redirectStairsShapeOUTER_LEFT() {
        return StairsShapeR.OUTER_LEFT;
    }

    @Redirect(method = "createStairs", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/StairsShape;OUTER_RIGHT:Lnet/minecraft/world/level/block/state/properties/StairsShape;"))
    private static StairsShape redirectStairsShapeOUTER_RIGHT() {
        return StairsShapeR.OUTER_RIGHT;
    }

    @Redirect(method = "createWall", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/WallSide;LOW:Lnet/minecraft/world/level/block/state/properties/WallSide;"))
    private static WallSide redirectWallSideLOW() {
        return WallSideR.LOW;
    }

    @Redirect(method = "createWall", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/WallSide;TALL:Lnet/minecraft/world/level/block/state/properties/WallSide;"))
    private static WallSide redirectWallSideTALL() {
        return WallSideR.TALL;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;R0:Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;"))
    private VariantProperties.Rotation redirectVariantPropertiesR0() {
        return VariantPropertiesRotationR.R0;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;R90:Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;"))
    private VariantProperties.Rotation redirectVariantPropertiesR90() {
        return VariantPropertiesRotationR.R90;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;R180:Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;"))
    private VariantProperties.Rotation redirectVariantPropertiesR180() {
        return VariantPropertiesRotationR.R180;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;R270:Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;"))
    private VariantProperties.Rotation redirectVariantPropertiesR270() {
        return VariantPropertiesRotationR.R270;
    }
}
