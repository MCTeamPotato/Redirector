package com.teampotato.redirectionor.mixin.world.level.levelgen.structure.structures;

import com.teampotato.redirectionor.references.DirectionReferences;
import com.teampotato.redirectionor.references.RotationReferences;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class WoodlandMansionPiecesMixin {
    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.WoodlandMansionPieces$MansionPiecePlacer")
    public abstract static class MansionPiecePlacerMixin {
        @Redirect(method = {"createRoof", "traverseInnerTurn", "addRoom1x1", "addRoom1x2", "addRoom2x2"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;COUNTERCLOCKWISE_90:Lnet/minecraft/world/level/block/Rotation;"))
        private Rotation redirectRotationCOUNTERCLOCKWISE_90() {
            return RotationReferences.COUNTERCLOCKWISE_90;
        }

        @Redirect(method = {"createRoof", "addRoom1x1", "addRoom1x2", "addRoom2x2"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;CLOCKWISE_180:Lnet/minecraft/world/level/block/Rotation;"))
        private Rotation redirectRotationCLOCKWISE_180() {
            return RotationReferences.CLOCKWISE_180;
        }

        @Redirect(method = {"createRoof", "addRoom1x1", "addRoom1x2", "addRoom2x2"}, at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;CLOCKWISE_90:Lnet/minecraft/world/level/block/Rotation;"))
        private Rotation redirectRotationCLOCKWISE_90() {
            return RotationReferences.CLOCKWISE_90;
        }

        @Redirect(method = "createMansion", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Plane;HORIZONTAL:Lnet/minecraft/core/Direction$Plane;"))
        private Direction.Plane redirectPlaneHORIZONTAL() {
            return DirectionReferences.PlaneReferences.HORIZONTAL;
        }

        @Redirect(method = "addRoom1x1", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;NONE:Lnet/minecraft/world/level/block/Rotation;"))
        private Rotation redirectRotationNONE() {
            return RotationReferences.NONE;
        }
    }

    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.WoodlandMansionPieces$MansionGrid")
    public abstract static class MansionGridMixin {
        @Redirect(method = {"get1x2RoomDirection", "setupThirdFloor"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Plane;HORIZONTAL:Lnet/minecraft/core/Direction$Plane;"))
        private Direction.Plane redirectPlaneHORIZONTAL() {
            return DirectionReferences.PlaneReferences.HORIZONTAL;
        }
    }
}
