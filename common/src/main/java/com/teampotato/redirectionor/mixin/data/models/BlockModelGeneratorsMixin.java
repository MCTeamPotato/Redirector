package com.teampotato.redirectionor.mixin.data.models;

import com.teampotato.redirectionor.references.DirectionReferences;
import com.teampotato.redirectionor.references.VariantPropertiesRotationReferences;
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
        return AttachFaceReferences.FLOOR;
    }

    @Redirect(method = {"createGrindstone", "createLever"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/AttachFace;FLOOR:Lnet/minecraft/world/level/block/state/properties/AttachFace;"))
    private AttachFace redirectAttachFaceFLOOR() {
        return AttachFaceReferences.FLOOR;
    }

    @Redirect(method = "createButton", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/AttachFace;WALL:Lnet/minecraft/world/level/block/state/properties/AttachFace;"))
    private static AttachFace redirectAttachFaceWALLStatic() {
        return AttachFaceReferences.WALL;
    }

    @Redirect(method = {"createGrindstone", "createLever"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/AttachFace;WALL:Lnet/minecraft/world/level/block/state/properties/AttachFace;"))
    private AttachFace redirectAttachFaceWALL() {
        return AttachFaceReferences.WALL;
    }

    @Redirect(method = "createButton", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/AttachFace;CEILING:Lnet/minecraft/world/level/block/state/properties/AttachFace;"))
    private static AttachFace redirectAttachFaceStatic() {
        return AttachFaceReferences.CEILING;
    }

    @Redirect(method = {"createGrindstone", "createLever"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/AttachFace;CEILING:Lnet/minecraft/world/level/block/state/properties/AttachFace;"))
    private AttachFace redirectAttachFaceCEILING() {
        return AttachFaceReferences.CEILING;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
    private Direction redirectDirectionEAST() {
        return DirectionReferences.EAST;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private Direction redirectDirectionSOUTH() {
        return DirectionReferences.SOUTH;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
    private Direction redirectDirectionNORTH() {
        return DirectionReferences.NORTH;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;WEST:Lnet/minecraft/core/Direction;"))
    private Direction redirectDirectionWEST() {
        return DirectionReferences.WEST;
    }

    @Redirect(method = "createFacingDispatch", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private static Direction redirectDirectionUPStatic() {
        return DirectionReferences.UP;
    }

    @Redirect(method = {"createColumnWithFacing", "createDispenserBlock"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction redirectDirectionUP() {
        return DirectionReferences.UP;
    }

    @Redirect(method = "createFacingDispatch", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private static Direction redirectDirectionDOWNStatic() {
        return DirectionReferences.DOWN;
    }

    @Redirect(method = {"createColumnWithFacing", "createDispenserBlock", "createHopper"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private Direction redirectDirectionDOWN() {
        return DirectionReferences.DOWN;
    }

    @Redirect(method = {"createRotatedPillar", "createRotatedPillarWithHorizontalVariant(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Axis;X:Lnet/minecraft/core/Direction$Axis;"))
    private static Direction.Axis redirectAxisXStatic() {
        return DirectionReferences.AxisReferences.X;
    }

    @Redirect(method = "createNetherPortalBlock", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Axis;X:Lnet/minecraft/core/Direction$Axis;"))
    private Direction.Axis redirectAxisX() {
        return DirectionReferences.AxisReferences.X;
    }

    @Redirect(method = {"createRotatedPillar", "createRotatedPillarWithHorizontalVariant(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Axis;Y:Lnet/minecraft/core/Direction$Axis;"))
    private static Direction.Axis redirectAxisY() {
        return DirectionReferences.AxisReferences.Y;
    }

    @Redirect(method = {"createRotatedPillar"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Axis;Z:Lnet/minecraft/core/Direction$Axis;"))
    private static Direction.Axis redirectAxisZStatic() {
        return DirectionReferences.AxisReferences.Z;
    }

    @Redirect(method = {"createNetherPortalBlock"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Axis;Z:Lnet/minecraft/core/Direction$Axis;"))
    private Direction.Axis redirectAxisZ() {
        return DirectionReferences.AxisReferences.Z;
    }

    @Redirect(method = "createBamboo", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BambooLeaves;SMALL:Lnet/minecraft/world/level/block/state/properties/BambooLeaves;"))
    private BambooLeaves redirectBambooLeavesSMALL() {
        return BambooLeavesReferences.SMALL;
    }

    @Redirect(method = "createBamboo", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BambooLeaves;LARGE:Lnet/minecraft/world/level/block/state/properties/BambooLeaves;"))
    private BambooLeaves redirectBambooLeavesLARGE() {
        return BambooLeavesReferences.LARGE;
    }

    @Redirect(method = "createBell", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BellAttachType;FLOOR:Lnet/minecraft/world/level/block/state/properties/BellAttachType;"))
    private BellAttachType redirectBellAttachTypeFLOOR() {
        return BellAttachTypeReferences.FLOOR;
    }

    @Redirect(method = "createBell", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BellAttachType;CEILING:Lnet/minecraft/world/level/block/state/properties/BellAttachType;"))
    private BellAttachType redirectBellAttachTypeCEILING() {
        return BellAttachTypeReferences.CEILING;
    }

    @Redirect(method = "createBell", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BellAttachType;SINGLE_WALL:Lnet/minecraft/world/level/block/state/properties/BellAttachType;"))
    private BellAttachType redirectBellAttachTypeSINGLE_WALL() {
        return BellAttachTypeReferences.SINGLE_WALL;
    }

    @Redirect(method = "createBell", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/BellAttachType;DOUBLE_WALL:Lnet/minecraft/world/level/block/state/properties/BellAttachType;"))
    private BellAttachType redirectBellAttachTypeDOUBLE_WALL() {
        return BellAttachTypeReferences.DOUBLE_WALL;
    }

    @Redirect(method = "createComparator", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/ComparatorMode;COMPARE:Lnet/minecraft/world/level/block/state/properties/ComparatorMode;"))
    private ComparatorMode redirectComparatorModeCOMPARE() {
        return ComparatorModeReferences.COMPARE;
    }

    @Redirect(method = "createComparator", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/ComparatorMode;SUBTRACT:Lnet/minecraft/world/level/block/state/properties/ComparatorMode;"))
    private ComparatorMode redirectComparatorModeSUBTRACT() {
        return ComparatorModeReferences.SUBTRACT;
    }

    @Redirect(method = "configureDoorHalf", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/DoorHingeSide;LEFT:Lnet/minecraft/world/level/block/state/properties/DoorHingeSide;"))
    private static DoorHingeSide redirectDoorHingeSideLEFT() {
        return DoorHingeSideReferences.LEFT;
    }

    @Redirect(method = "configureDoorHalf", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/DoorHingeSide;RIGHT:Lnet/minecraft/world/level/block/state/properties/DoorHingeSide;"))
    private static DoorHingeSide redirectDoorHingeSideRIGHT() {
        return DoorHingeSideReferences.RIGHT;
    }

    @Redirect(method = "createDoor(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;UPPER:Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;"))
    private static DoubleBlockHalf redirectDoubleBlockHalfUPPERStatic() {
        return DoubleBlockHalfReferences.UPPER;
    }

    @Redirect(method = "createDoor(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;LOWER:Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;"))
    private static DoubleBlockHalf redirectDoubleBlockHalfLOWERStatic() {
        return DoubleBlockHalfReferences.LOWER;
    }

    @Redirect(method = "createDoubleBlock", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;UPPER:Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;"))
    private DoubleBlockHalf redirectDoubleBlockHalfUPPER() {
        return DoubleBlockHalfReferences.UPPER;
    }

    @Redirect(method = "createDoubleBlock", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;LOWER:Lnet/minecraft/world/level/block/state/properties/DoubleBlockHalf;"))
    private DoubleBlockHalf redirectDoubleBlockHalfLOWER() {
        return DoubleBlockHalfReferences.LOWER;
    }

    @Redirect(method = {"createStairs", "createOrientableTrapdoor(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;", "createTrapdoor(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/Half;TOP:Lnet/minecraft/world/level/block/state/properties/Half;"))
    private static Half redirectHalfTOP() {
        return HalfReferences.TOP;
    }

    @Redirect(method = {"createStairs", "createOrientableTrapdoor(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;", "createTrapdoor(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/data/models/blockstates/BlockStateGenerator;"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/Half;BOTTOM:Lnet/minecraft/world/level/block/state/properties/Half;"))
    private static Half redirectHalfBOTTOM() {
        return HalfReferences.BOTTOM;
    }

    @Redirect(method = "createPistonHeads", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/PistonType;DEFAULT:Lnet/minecraft/world/level/block/state/properties/PistonType;"))
    private PistonType redirectPistonTypeDEFAULT() {
        return PistonTypeReferences.DEFAULT;
    }

    @Redirect(method = "createPistonHeads", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/PistonType;STICKY:Lnet/minecraft/world/level/block/state/properties/PistonType;"))
    private PistonType redirectPistonTypeSTICKY() {
        return PistonTypeReferences.STICKY;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;NORTH_SOUTH:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeNORTH_SOUTH() {
        return RailShapeReferences.NORTH_SOUTH;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;EAST_WEST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeEAST_WEST() {
        return RailShapeReferences.EAST_WEST;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;ASCENDING_EAST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeASCENDING_EAST() {
        return RailShapeReferences.ASCENDING_EAST;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;ASCENDING_WEST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeASCENDING_WEST() {
        return RailShapeReferences.ASCENDING_WEST;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;ASCENDING_NORTH:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeASCENDING_NORTH() {
        return RailShapeReferences.ASCENDING_NORTH;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;ASCENDING_SOUTH:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeASCENDING_SOUTH() {
        return RailShapeReferences.ASCENDING_SOUTH;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;SOUTH_EAST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeSOUTH_EAST() {
        return RailShapeReferences.SOUTH_EAST;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;SOUTH_WEST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeSOUTH_WEST() {
        return RailShapeReferences.SOUTH_WEST;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;NORTH_WEST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeNORTH_WEST() {
        return RailShapeReferences.NORTH_WEST;
    }

    @Redirect(method = "createPassiveRail", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RailShape;NORTH_EAST:Lnet/minecraft/world/level/block/state/properties/RailShape;"))
    private RailShape redirectRailShapeNORTH_EAST() {
        return RailShapeReferences.NORTH_EAST;
    }

    @Redirect(method = "createRedstoneWire", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RedstoneSide;UP:Lnet/minecraft/world/level/block/state/properties/RedstoneSide;"))
    private RedstoneSide redirectRedstoneSideUP() {
        return RedstoneSideReferences.UP;
    }

    @Redirect(method = "createRedstoneWire", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RedstoneSide;SIDE:Lnet/minecraft/world/level/block/state/properties/RedstoneSide;"))
    private RedstoneSide redirectRedstoneSideSIDE() {
        return RedstoneSideReferences.SIDE;
    }

    @Redirect(method = "createRedstoneWire", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/RedstoneSide;NONE:Lnet/minecraft/world/level/block/state/properties/RedstoneSide;"))
    private RedstoneSide redirectRedstoneSideNONE() {
        return RedstoneSideReferences.NONE;
    }

    @Redirect(method = "createSlab", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/SlabType;TOP:Lnet/minecraft/world/level/block/state/properties/SlabType;"))
    private static SlabType redirectSlabTypeTOP() {
        return SlabTypeReferences.TOP;
    }

    @Redirect(method = "createSlab", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/SlabType;BOTTOM:Lnet/minecraft/world/level/block/state/properties/SlabType;"))
    private static SlabType redirectSlabTypeBOTTOM() {
        return SlabTypeReferences.BOTTOM;
    }

    @Redirect(method = "createSlab", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/SlabType;DOUBLE:Lnet/minecraft/world/level/block/state/properties/SlabType;"))
    private static SlabType redirectSlabTypeDOUBLE() {
        return SlabTypeReferences.DOUBLE;
    }

    @Redirect(method = "createStairs", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/StairsShape;STRAIGHT:Lnet/minecraft/world/level/block/state/properties/StairsShape;"))
    private static StairsShape redirectStairsShapeSTRAIGHT() {
        return StairsShapeReferences.STRAIGHT;
    }

    @Redirect(method = "createStairs", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/StairsShape;INNER_LEFT:Lnet/minecraft/world/level/block/state/properties/StairsShape;"))
    private static StairsShape redirectStairsShapeINNER_LEFT() {
        return StairsShapeReferences.INNER_LEFT;
    }

    @Redirect(method = "createStairs", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/StairsShape;INNER_RIGHT:Lnet/minecraft/world/level/block/state/properties/StairsShape;"))
    private static StairsShape redirectStairsShapeINNER_RIGHT() {
        return StairsShapeReferences.INNER_RIGHT;
    }

    @Redirect(method = "createStairs", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/StairsShape;OUTER_LEFT:Lnet/minecraft/world/level/block/state/properties/StairsShape;"))
    private static StairsShape redirectStairsShapeOUTER_LEFT() {
        return StairsShapeReferences.OUTER_LEFT;
    }

    @Redirect(method = "createStairs", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/StairsShape;OUTER_RIGHT:Lnet/minecraft/world/level/block/state/properties/StairsShape;"))
    private static StairsShape redirectStairsShapeOUTER_RIGHT() {
        return StairsShapeReferences.OUTER_RIGHT;
    }

    @Redirect(method = "createWall", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/WallSide;LOW:Lnet/minecraft/world/level/block/state/properties/WallSide;"))
    private static WallSide redirectWallSideLOW() {
        return WallSideReferences.LOW;
    }

    @Redirect(method = "createWall", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/state/properties/WallSide;TALL:Lnet/minecraft/world/level/block/state/properties/WallSide;"))
    private static WallSide redirectWallSideTALL() {
        return WallSideReferences.TALL;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;R0:Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;"))
    private VariantProperties.Rotation redirectVariantPropertiesR0() {
        return VariantPropertiesRotationReferences.R0;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;R90:Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;"))
    private VariantProperties.Rotation redirectVariantPropertiesR90() {
        return VariantPropertiesRotationReferences.R90;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;R180:Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;"))
    private VariantProperties.Rotation redirectVariantPropertiesR180() {
        return VariantPropertiesRotationReferences.R180;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;R270:Lnet/minecraft/data/models/blockstates/VariantProperties$Rotation;"))
    private VariantProperties.Rotation redirectVariantPropertiesR270() {
        return VariantPropertiesRotationReferences.R270;
    }
}
