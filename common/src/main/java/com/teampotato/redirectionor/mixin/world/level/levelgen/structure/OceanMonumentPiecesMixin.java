package com.teampotato.redirectionor.mixin.world.level.levelgen.structure;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.OceanMonumentPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public class OceanMonumentPiecesMixin {
    @Mixin(targets = {"net.minecraft.world.level.levelgen.structure.OceanMonumentPieces$FitDoubleYZRoom", "net.minecraft.world.level.levelgen.structure.OceanMonumentPieces$FitDoubleXYRoom", "net.minecraft.world.level.levelgen.structure.OceanMonumentPieces$FitDoubleZRoom", "net.minecraft.world.level.levelgen.structure.OceanMonumentPieces$FitDoubleYRoom", "net.minecraft.world.level.levelgen.structure.OceanMonumentPieces$FitDoubleXRoom", "net.minecraft.world.level.levelgen.structure.OceanMonumentPieces$FitSimpleTopRoom"})
    public abstract static class FitMixin {
        @Redirect(method = "fits", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int redirectDirectionGet3DDataValue(Direction instance) {
            return DirectionReferences.DataValueReferences.DATA_VALUE_MAP.get(instance);
        }
    }

    @Mixin(targets = {"net.minecraft.world.level.levelgen.structure.OceanMonumentPieces$FitDoubleYZRoom", "net.minecraft.world.level.levelgen.structure.OceanMonumentPieces$FitDoubleXYRoom", "net.minecraft.world.level.levelgen.structure.OceanMonumentPieces$FitDoubleZRoom", "net.minecraft.world.level.levelgen.structure.OceanMonumentPieces$FitDoubleXRoom", "net.minecraft.world.level.levelgen.structure.OceanMonumentPieces$FitDoubleYRoom"})
    public abstract static class CreateMixin {
        @Redirect(method = "create", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int redirectDirectionGet3DDataValue(Direction instance) {
            return DirectionReferences.DataValueReferences.DATA_VALUE_MAP.get(instance);
        }
    }

    @Mixin({OceanMonumentPieces.OceanMonumentDoubleYZRoom.class, OceanMonumentPieces.OceanMonumentDoubleXYRoom.class, OceanMonumentPieces.OceanMonumentDoubleZRoom.class, OceanMonumentPieces.OceanMonumentDoubleXRoom.class, OceanMonumentPieces.OceanMonumentDoubleYRoom.class, OceanMonumentPieces.OceanMonumentSimpleTopRoom.class, OceanMonumentPieces.OceanMonumentSimpleRoom.class, OceanMonumentPieces.OceanMonumentEntryRoom.class})
    public abstract static class PostProcessMixin {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int redirectDirectionGet3DDataValue(Direction instance) {
            return DirectionReferences.DataValueReferences.DATA_VALUE_MAP.get(instance);
        }
    }

    @Mixin(OceanMonumentPieces.MonumentBuilding.class)
    public abstract static class MonumentBuildingMixin {
        @Redirect(method = "generateRoomGraph", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
        private Direction[] redirectDirectionValues() {
            return DirectionReferences.DIRECTIONS;
        }

        @Redirect(method = "generateRoomGraph", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int redirectDirectionGet3DDataValue(Direction instance) {
            return DirectionReferences.DataValueReferences.DATA_VALUE_MAP.get(instance);
        }
    }
}
