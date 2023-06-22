package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.structure.OceanMonumentPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public abstract class OceanMonumentPiecesMixin {
    @Mixin(OceanMonumentPieces.DoubleXRoom.class)
    public abstract static class DoubleXRoomMixin {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 0))
        private int implValue0(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 1))
        private int implValue1(Direction direction) {
            return Redirectionor.DOWN_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 2))
        private int implValue2(Direction direction) {
            return Redirectionor.DOWN_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 3))
        private int implValue3(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 4))
        private int implValue4(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 5))
        private int implValue5(Direction direction) {
            return Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 6))
        private int implValue6(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 7))
        private int implValue7(Direction direction) {
            return Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 8))
        private int implValue8(Direction direction) {
            return Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 9))
        private int implValue9(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 10))
        private int implValue10(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }
    }

    @Mixin(OceanMonumentPieces.DoubleXYRoom.class)
    public abstract static class DoubleXYRoomMixin {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 0))
        private int implValue0(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 1))
        private int implValue1(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 2))
        private int implValue2(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 3))
        private int implValue3(Direction direction) {
            return Redirectionor.DOWN_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 4))
        private int implValue4(Direction direction) {
            return Redirectionor.DOWN_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 5))
        private int implValue5(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 6))
        private int implValue6(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 7))
        private int implValue7(Direction direction) {
            return Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 8))
        private int implValue8(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 9))
        private int implValue9(Direction direction) {
            return Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 10))
        private int implValue10(Direction direction) {
            return Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 11))
        private int implValue11(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 12))
        private int implValue12(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 13))
        private int implValue13(Direction direction) {
            return Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 14))
        private int implValue14(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 15))
        private int implValue15(Direction direction) {
            return Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 16))
        private int implValue16(Direction direction) {
            return Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 17))
        private int implValue17(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 18))
        private int implValue18(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }
    }

    @Mixin(OceanMonumentPieces.DoubleYRoom.class)
    public abstract static class DoubleYRoomMixin {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 0))
        private int implValue0(Direction direction) {
            return Redirectionor.DOWN_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 1))
        private int implValue1(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 2))
        private int implValue2(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 3))
        private int implValue3(Direction direction) {
            return Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 4))
        private int implValue4(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 5))
        private int implValue5(Direction direction) {
            return Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 6))
        private int implValue6(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }
    }

    @Mixin(OceanMonumentPieces.DoubleYZRoom.class)
    public abstract static class DoubleYZRoomMixin {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 0))
        private int implValue0(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 1))
        private int implValue1(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 2))
        private int implValue2(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 3))
        private int implValue3(Direction direction) {
            return Redirectionor.DOWN_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 4))
        private int implValue4(Direction direction) {
            return Redirectionor.DOWN_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 5))
        private int implValue5(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 6))
        private int implValue6(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 7))
        private int implValue7(Direction direction) {
            return Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 8))
        private int implValue8(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 9))
        private int implValue9(Direction direction) {
            return Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 10))
        private int implValue10(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 11))
        private int implValue11(Direction direction) {
            return Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 12))
        private int implValue12(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 13))
        private int implValue13(Direction direction) {
            return Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 14))
        private int implValue14(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 15))
        private int implValue15(Direction direction) {
            return Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 16))
        private int implValue16(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 17))
        private int implValue17(Direction direction) {
            return Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 18))
        private int implValue18(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }
    }

    @Mixin(OceanMonumentPieces.DoubleZRoom.class)
    public abstract static class DoubleZRoomMixin {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 0))
        private int implValue0(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 1))
        private int implValue1(Direction direction) {
            return Redirectionor.DOWN_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 2))
        private int implValue2(Direction direction) {
            return Redirectionor.DOWN_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 3))
        private int implValue3(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 4))
        private int implValue4(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 5))
        private int implValue5(Direction direction) {
            return Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 6))
        private int implValue6(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 7))
        private int implValue7(Direction direction) {
            return Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 8))
        private int implValue8(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 9))
        private int implValue9(Direction direction) {
            return Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 10))
        private int implValue10(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }
    }

    @Mixin(OceanMonumentPieces.EntryRoom.class)
    public abstract static class EntryRoomMixin {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 0))
        private int implValue0(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 1))
        private int implValue1(Direction direction) {
            return Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 2))
        private int implValue2(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }
    }

    @Mixin(targets = "net.minecraft.world.gen.feature.structure.OceanMonumentPieces$FitSimpleRoomTopHelper")
    public abstract static class FitSimpleRoomTopHelperMixin {
        @Redirect(method = "fits", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 0))
        private int implValue0(Direction direction) {
            return Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "fits", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 1))
        private int implValue1(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }

        @Redirect(method = "fits", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 2))
        private int implValue2(Direction direction) {
            return Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "fits", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 3))
        private int implValue3(Direction direction) {
            return Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "fits", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 4))
        private int implValue4(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }
    }

    @Mixin(OceanMonumentPieces.MonumentBuilding.class)
    public abstract static class MonumentBuildingMixin {
        @Redirect(method = "generateRoomGraph", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
        private Direction[] implValues() {
            return Redirectionor.DIRECTIONS;
        }

        @Redirect(method = "generateRoomGraph", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
        private Direction implUp() {
            return Redirectionor.UP;
        }

        @Redirect(method = "generateRoomGraph", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
        private Direction implSouth() {
            return Redirectionor.SOUTH;
        }

        @Redirect(method = "generateRoomGraph", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }

        @Redirect(method = "generateRoomGraph", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
        private Direction implNorth() {
            return Redirectionor.NORTH;
        }
    }

    @Mixin(OceanMonumentPieces.Piece.class)
    public abstract static class PieceMixin {
        @Redirect(method = "<init>(Lnet/minecraft/world/gen/feature/structure/IStructurePieceType;ILnet/minecraft/util/Direction;Lnet/minecraft/world/gen/feature/structure/OceanMonumentPieces$RoomDefinition;III)V", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
        private Direction implSouth() {
            return Redirectionor.SOUTH;
        }
    }

    @Mixin(OceanMonumentPieces.SimpleRoom.class)
    public abstract static class SimpleRoomMixin {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 0))
        private int implValue0(Direction instance) {
            return  Redirectionor.DOWN_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 1))
        private int implValue1(Direction instance) {
            return  Redirectionor.UP_3D_DATA_VALUE;
        }
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 2))
        private int implValue2(Direction instance) {
            return  Redirectionor.DOWN_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 3))
        private int implValue3(Direction instance) {
            return  Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 4))
        private int implValue4(Direction instance) {
            return  Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 5))
        private int implValue5(Direction instance) {
            return  Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 6))
        private int implValue6(Direction instance) {
            return  Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 7))
        private int implValue7(Direction instance) {
            return  Redirectionor.EAST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 8))
        private int implValue8(Direction instance) {
            return  Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 9))
        private int implValue9(Direction instance) {
            return  Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 10))
        private int implValue10(Direction instance) {
            return  Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 11))
        private int implValue11(Direction instance) {
            return  Redirectionor.EAST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 12))
        private int implValue12(Direction instance) {
            return  Redirectionor.SOUTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 13))
        private int implValue13(Direction instance) {
            return  Redirectionor.NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 14))
        private int implValue14(Direction instance) {
            return  Redirectionor.WEST_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 15))
        private int implValue15(Direction instance) {
            return  Redirectionor.EAST_3D_DATA_VALUE;
        }
    }

    @Mixin(OceanMonumentPieces.SimpleTopRoom.class)
    public abstract static class SimpleTopRoomMixin {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 0))
        private int implValue0(Direction direction) {
            return Redirectionor.DOWN_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 1))
        private int implValue1(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }

        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I", ordinal = 2))
        private int implValue2(Direction direction) {
            return Redirectionor.SOUTH_3D_DATA_VALUE;
        }
    }

    @Mixin(targets = "net.minecraft.world.gen.feature.structure.OceanMonumentPieces$XDoubleRoomFitHelper")
    public static abstract class XDoubleRoomFitHelperMixin {
        @Redirect(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I"))
        private int implValue0(Direction direction) {
            return Redirectionor.EAST_3D_DATA_VALUE;
        }
    }

    @Mixin(targets = "net.minecraft.world.gen.feature.structure.OceanMonumentPieces$XYDoubleRoomFitHelper")
    public static abstract class XYDoubleRoomFitHelperMixin {
        @Redirect(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I"))
        private int implValue0(Direction direction) {
            if (direction == Redirectionor.EAST) {
                return Redirectionor.EAST_3D_DATA_VALUE;
            } else {
                return Redirectionor.UP_3D_DATA_VALUE;
            }
        }
    }

    @Mixin(targets = "net.minecraft.world.gen.feature.structure.OceanMonumentPieces$YDoubleRoomFitHelper")
    public static abstract class YDoubleRoomFitHelperMixin {
        @Redirect(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I"))
        private int implValue(Direction direction) {
            return Redirectionor.UP_3D_DATA_VALUE;
        }
    }

    @Mixin(targets = "net.minecraft.world.gen.feature.structure.OceanMonumentPieces$YZDoubleRoomFitHelper")
    public static abstract class YZDoubleRoomFitHelperMixin {
        @Redirect(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I"))
        private int implValue(Direction direction) {
            if (direction == Redirectionor.NORTH) {
                return Redirectionor.NORTH_3D_DATA_VALUE;
            } else {
                return Redirectionor.UP_3D_DATA_VALUE;
            }
        }
    }

    @Mixin(targets = "net.minecraft.world.gen.feature.structure.OceanMonumentPieces$ZDoubleRoomFitHelper")
    public static abstract class ZDoubleRoomFitHelperMixin {
        @Redirect(method = "*", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;get3DDataValue()I"))
        private int implValue(Direction direction) {
            if (direction == Redirectionor.NORTH) {
                return Redirectionor.NORTH_3D_DATA_VALUE;
            } else {
                return Redirectionor.SOUTH_3D_DATA_VALUE;
            }
        }
    }
}
