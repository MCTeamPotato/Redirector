package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.structure.structures;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.structures.NetherFortressPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;

public abstract class MixinNetherFortressPieces {
    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.NetherFortressPieces$NetherBridgePiece")
    public abstract static class MixinNetherBridgePiece extends StructurePiece{
        @Shadow protected abstract StructurePiece generateAndAddPiece(NetherFortressPieces.StartPiece pStartPiece, StructurePieceAccessor pPieces, RandomSource pRandom, int pX, int pY, int pZ, @org.jetbrains.annotations.Nullable Direction pOrientation, int pGenDepth, boolean pCastlePiece);

        protected MixinNetherBridgePiece(StructurePieceType pType, int pGenDepth, BoundingBox pBox) {
            super(pType, pGenDepth, pBox);
        }

        /**
         * @author Kasualix
         * @reason avoid allocation
         */
        @Overwrite
        @Nullable
        protected StructurePiece generateChildLeft(NetherFortressPieces.StartPiece pStartPiece, StructurePieceAccessor pPieces, RandomSource pRandom, int pOffsetY, int pOffsetX, boolean pCastlePiece) {
            Direction direction = this.getOrientation();
            if (direction != null) {
                switch (direction) {
                    case NORTH, SOUTH -> {
                        return this.generateAndAddPiece(pStartPiece, pPieces, pRandom, this.boundingBox.minX() - 1, this.boundingBox.minY() + pOffsetY, this.boundingBox.minZ() + pOffsetX, Redirectionor.WEST, this.getGenDepth(), pCastlePiece);
                    }
                    case WEST, EAST -> {
                        return this.generateAndAddPiece(pStartPiece, pPieces, pRandom, this.boundingBox.minX() + pOffsetX, this.boundingBox.minY() + pOffsetY, this.boundingBox.minZ() - 1, Redirectionor.NORTH, this.getGenDepth(), pCastlePiece);
                    }
                }
            }

            return null;
        }

        /**
         * @author Kasualix
         * @reason avoid allocation
         */
        @Overwrite
        @Nullable
        protected StructurePiece generateChildRight(NetherFortressPieces.StartPiece pStartPiece, StructurePieceAccessor pPieces, RandomSource pRandom, int pOffsetY, int pOffsetX, boolean pCastlePiece) {
            Direction direction = this.getOrientation();
            if (direction != null) {
                switch (direction) {
                    case NORTH, SOUTH -> {
                        return this.generateAndAddPiece(pStartPiece, pPieces, pRandom, this.boundingBox.maxX() + 1, this.boundingBox.minY() + pOffsetY, this.boundingBox.minZ() + pOffsetX, Redirectionor.EAST, this.getGenDepth(), pCastlePiece);
                    }
                    case WEST, EAST -> {
                        return this.generateAndAddPiece(pStartPiece, pPieces, pRandom, this.boundingBox.minX() + pOffsetX, this.boundingBox.minY() + pOffsetY, this.boundingBox.maxZ() + 1, Redirectionor.SOUTH, this.getGenDepth(), pCastlePiece);
                    }
                }
            }

            return null;
        }
    }
}
