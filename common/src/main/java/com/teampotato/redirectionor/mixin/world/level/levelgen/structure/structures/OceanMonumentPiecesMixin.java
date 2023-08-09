package com.teampotato.redirectionor.mixin.world.level.levelgen.structure.structures;

import com.teampotato.redirectionor.common.Maps;
import com.teampotato.redirectionor.common.Values;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public abstract class OceanMonumentPiecesMixin {
    @Mixin(targets = {"net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleYZRoom", "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleXYRoom", "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleZRoom", "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleYRoom", "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleXRoom", "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitSimpleTopRoom"})
    public abstract static class FitMixin {
        @Redirect(method = "fits", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int redirectDirectionGet3DDataValue(Direction instance) {
            return Maps.DIRECTION_DATA_VALUE_MAP.getInt(instance);
        }
    }

    @Mixin(targets = {"net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleYZRoom", "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleXYRoom", "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleZRoom", "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleXRoom", "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleYRoom"})
    public abstract static class CreateMixin {
        @Redirect(method = "create", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int redirectDirectionGet3DDataValue(Direction instance) {
            return Maps.DIRECTION_DATA_VALUE_MAP.getInt(instance);
        }
    }

    @Mixin({OceanMonumentPieces.OceanMonumentDoubleYZRoom.class, OceanMonumentPieces.OceanMonumentDoubleXYRoom.class, OceanMonumentPieces.OceanMonumentDoubleZRoom.class, OceanMonumentPieces.OceanMonumentDoubleXRoom.class, OceanMonumentPieces.OceanMonumentDoubleYRoom.class, OceanMonumentPieces.OceanMonumentSimpleTopRoom.class, OceanMonumentPieces.OceanMonumentSimpleRoom.class, OceanMonumentPieces.OceanMonumentEntryRoom.class})
    public abstract static class PostProcessMixin {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int redirectDirectionGet3DDataValue(Direction instance) {
            return Maps.DIRECTION_DATA_VALUE_MAP.getInt(instance);
        }
    }

    @Mixin(OceanMonumentPieces.MonumentBuilding.class)
    public abstract static class MonumentBuildingMixin {
        @Redirect(method = "generateRoomGraph", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
        private Direction[] redirectDirectionValues() {
            return Values.DIRECTIONS;
        }

        @Redirect(method = "generateRoomGraph", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int redirectDirectionGet3DDataValue(Direction instance) {
            return Maps.DIRECTION_DATA_VALUE_MAP.getInt(instance);
        }
    }
}
