package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.structure.structures;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.structures.NetherFortressPieces;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


public abstract class MixinNetherFortressPieces {
    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.NetherFortressPieces$NetherBridgePiece")
    public abstract static class MixinNetherBridgePiece extends StructurePiece{
        @Shadow protected abstract StructurePiece generateAndAddPiece(NetherFortressPieces.StartPiece pStartPiece, StructurePieceAccessor pPieces, RandomSource pRandom, int pX, int pY, int pZ, @org.jetbrains.annotations.Nullable Direction pOrientation, int pGenDepth, boolean pCastlePiece);

        protected MixinNetherBridgePiece(StructurePieceType pType, int pGenDepth, BoundingBox pBox) {
            super(pType, pGenDepth, pBox);
        }


        @Redirect(method = "generateChildLeft", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;WEST:Lnet/minecraft/core/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
        }

        @Redirect(method = "generateChildLeft", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
        private Direction implNorth() {
            return Redirectionor.NORTH;
        }

        @Redirect(method = "generateChildRight", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }

        @Redirect(method = "generateChildRight", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
        private Direction implSouth() {
            return Redirectionor.SOUTH;
        }
    }
}
