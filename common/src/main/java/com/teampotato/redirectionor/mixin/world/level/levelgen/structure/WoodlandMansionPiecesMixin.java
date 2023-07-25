package com.teampotato.redirectionor.mixin.world.level.levelgen.structure;

import com.teampotato.redirectionor.references.RotationReferences;
import net.minecraft.world.level.block.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class WoodlandMansionPiecesMixin {
    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.WoodlandMansionPieces$MansionPiecePlacer")
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
    }
}
