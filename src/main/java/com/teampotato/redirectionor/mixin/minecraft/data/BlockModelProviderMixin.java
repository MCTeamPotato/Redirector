package com.teampotato.redirectionor.mixin.minecraft.data;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.data.BlockModelFields;
import net.minecraft.data.BlockModelProvider;
import net.minecraft.state.properties.*;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


@Mixin(BlockModelProvider.class)
public abstract class BlockModelProviderMixin {
    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDownStatic() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private static Direction implUpStatic() {
        return Redirectionor.UP;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private static Direction implNorthStatic() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
    private static Direction implSouthStatic() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
    private Direction implWest() {
        return Redirectionor.WEST;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
    private static Direction implWestStatic() {
        return Redirectionor.WEST;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
    private Direction implEast() {
        return Redirectionor.EAST;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
    private static Direction implEastStatic() {
        return Redirectionor.EAST;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/BlockModelFields$Rotation;R0:Lnet/minecraft/data/BlockModelFields$Rotation;"))
    private BlockModelFields.Rotation implR0() {
        return Redirectionor.R0;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/BlockModelFields$Rotation;R0:Lnet/minecraft/data/BlockModelFields$Rotation;"))
    private static BlockModelFields.Rotation implR0Static() {
        return Redirectionor.R0;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/BlockModelFields$Rotation;R90:Lnet/minecraft/data/BlockModelFields$Rotation;"))
    private BlockModelFields.Rotation implR90() {
        return Redirectionor.R90;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/BlockModelFields$Rotation;R90:Lnet/minecraft/data/BlockModelFields$Rotation;"))
    private static BlockModelFields.Rotation implR90Static() {
        return Redirectionor.R90;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/BlockModelFields$Rotation;R180:Lnet/minecraft/data/BlockModelFields$Rotation;"))
    private BlockModelFields.Rotation implR180() {
        return Redirectionor.R180;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/BlockModelFields$Rotation;R180:Lnet/minecraft/data/BlockModelFields$Rotation;"))
    private static BlockModelFields.Rotation implR180Static() {
        return Redirectionor.R180;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/BlockModelFields$Rotation;R270:Lnet/minecraft/data/BlockModelFields$Rotation;"))
    private BlockModelFields.Rotation implR270() {
        return Redirectionor.R270;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/data/BlockModelFields$Rotation;R270:Lnet/minecraft/data/BlockModelFields$Rotation;"))
    private static BlockModelFields.Rotation implR270Static() {
        return Redirectionor.R270;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/AttachFace;FLOOR:Lnet/minecraft/state/properties/AttachFace;"))
    private AttachFace implFloor() {
        return Redirectionor.FLOOR;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/AttachFace;FLOOR:Lnet/minecraft/state/properties/AttachFace;"))
    private static AttachFace implFloorStatic() {
        return Redirectionor.FLOOR;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/AttachFace;WALL:Lnet/minecraft/state/properties/AttachFace;"))
    private AttachFace implWall() {
        return Redirectionor.WALL;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/AttachFace;WALL:Lnet/minecraft/state/properties/AttachFace;"))
    private static AttachFace implWallStatic() {
        return Redirectionor.WALL;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/AttachFace;CEILING:Lnet/minecraft/state/properties/AttachFace;"))
    private AttachFace implCeiling() {
        return Redirectionor.CEILING;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/AttachFace;CEILING:Lnet/minecraft/state/properties/AttachFace;"))
    private static AttachFace implCeilingStatic() {
        return Redirectionor.CEILING;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/DoorHingeSide;LEFT:Lnet/minecraft/state/properties/DoorHingeSide;"))
    private DoorHingeSide implLeft() {
        return Redirectionor.LEFT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/DoorHingeSide;LEFT:Lnet/minecraft/state/properties/DoorHingeSide;"))
    private static DoorHingeSide implLeftStatic() {
        return Redirectionor.LEFT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/DoorHingeSide;RIGHT:Lnet/minecraft/state/properties/DoorHingeSide;"))
    private DoorHingeSide implRight() {
        return Redirectionor.RIGHT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/DoorHingeSide;RIGHT:Lnet/minecraft/state/properties/DoorHingeSide;"))
    private static DoorHingeSide implRightStatic() {
        return Redirectionor.RIGHT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/Half;BOTTOM:Lnet/minecraft/state/properties/Half;"))
    private Half implBottom() {
        return Redirectionor.BOTTOM;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/Half;BOTTOM:Lnet/minecraft/state/properties/Half;"))
    private static Half implBottomStatic() {
        return Redirectionor.BOTTOM;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/Half;TOP:Lnet/minecraft/state/properties/Half;"))
    private Half implTop() {
        return Redirectionor.TOP;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/Half;TOP:Lnet/minecraft/state/properties/Half;"))
    private static Half implTopStatic() {
        return Redirectionor.TOP;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;STRAIGHT:Lnet/minecraft/state/properties/StairsShape;"))
    private StairsShape implStraight() {
        return Redirectionor.STRAIGHT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;STRAIGHT:Lnet/minecraft/state/properties/StairsShape;"))
    private static StairsShape implStraightStatic() {
        return Redirectionor.STRAIGHT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;OUTER_RIGHT:Lnet/minecraft/state/properties/StairsShape;"))
    private StairsShape implOuterRight() {
        return Redirectionor.OUTER_RIGHT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;OUTER_RIGHT:Lnet/minecraft/state/properties/StairsShape;"))
    private static StairsShape implOuterRightStatic() {
        return Redirectionor.OUTER_RIGHT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;OUTER_LEFT:Lnet/minecraft/state/properties/StairsShape;"))
    private StairsShape implOuterLeft() {
        return Redirectionor.OUTER_LEFT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;OUTER_LEFT:Lnet/minecraft/state/properties/StairsShape;"))
    private static StairsShape implOuterLeftStatic() {
        return Redirectionor.OUTER_LEFT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;INNER_RIGHT:Lnet/minecraft/state/properties/StairsShape;"))
    private StairsShape implInnerRight() {
        return Redirectionor.INNER_RIGHT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;INNER_RIGHT:Lnet/minecraft/state/properties/StairsShape;"))
    private static StairsShape implInnerRightStatic() {
        return Redirectionor.INNER_RIGHT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;INNER_LEFT:Lnet/minecraft/state/properties/StairsShape;"))
    private StairsShape implInnerLeft() {
        return Redirectionor.INNER_LEFT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/StairsShape;INNER_LEFT:Lnet/minecraft/state/properties/StairsShape;"))
    private static StairsShape implInnerLeftStatic() {
        return Redirectionor.INNER_LEFT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;FLOOR:Lnet/minecraft/state/properties/BellAttachment;"))
    private BellAttachment implFloorType() {
        return Redirectionor.FLOOR_TYPE;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;FLOOR:Lnet/minecraft/state/properties/BellAttachment;"))
    private static BellAttachment implFloorTypeStatic() {
        return Redirectionor.FLOOR_TYPE;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;CEILING:Lnet/minecraft/state/properties/BellAttachment;"))
    private BellAttachment implCeilingType() {
        return Redirectionor.CEILING_TYPE;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;CEILING:Lnet/minecraft/state/properties/BellAttachment;"))
    private static BellAttachment implCeilingTypeStatic() {
        return Redirectionor.CEILING_TYPE;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;SINGLE_WALL:Lnet/minecraft/state/properties/BellAttachment;"))
    private BellAttachment implSingleWallType() {
        return Redirectionor.SINGLE_WALL_TYPE;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;SINGLE_WALL:Lnet/minecraft/state/properties/BellAttachment;"))
    private static BellAttachment implSingleWallTypeStatic() {
        return Redirectionor.SINGLE_WALL_TYPE;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;DOUBLE_WALL:Lnet/minecraft/state/properties/BellAttachment;"))
    private BellAttachment implDoubleWallType() {
        return Redirectionor.DOUBLE_WALL_TYPE;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/BellAttachment;DOUBLE_WALL:Lnet/minecraft/state/properties/BellAttachment;"))
    private static BellAttachment implDoubleWallTypeStatic() {
        return Redirectionor.DOUBLE_WALL_TYPE;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;X:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implX() {
        return Redirectionor.X;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;X:Lnet/minecraft/util/Direction$Axis;"))
    private static Direction.Axis implXStatic() {
        return Redirectionor.X;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;Y:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implY() {
        return Redirectionor.Y;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;Y:Lnet/minecraft/util/Direction$Axis;"))
    private static Direction.Axis implYStatic() {
        return Redirectionor.Y;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;Z:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implZ() {
        return Redirectionor.Z;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;Z:Lnet/minecraft/util/Direction$Axis;"))
    private static Direction.Axis implZStatic() {
        return Redirectionor.Z;
    }
}
