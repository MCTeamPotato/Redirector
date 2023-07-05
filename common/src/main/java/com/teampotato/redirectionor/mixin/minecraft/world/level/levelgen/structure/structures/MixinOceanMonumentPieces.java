package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.structure.structures;

import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static com.teampotato.redirectionor.Redirectionor.*;

public abstract class MixinOceanMonumentPieces {
    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleXRoom")
    public abstract static class MixinFitDoubleXRoom {
        @Redirect(method = "fits", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onFits(Direction instance) {
            return EAST_3D_DATA_VALUE;
        }

        @Redirect(method = "create", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onCreate(Direction instance) {
            return EAST_3D_DATA_VALUE;
        }
    }

    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleXYRoom")
    public abstract static class MixinFitDoubleXYRoom {
        @Redirect(method = "fits", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onFits(Direction instance) {
            if (instance.equals(EAST)) {
                return EAST_3D_DATA_VALUE;
            } else {
                return UP_3D_DATA_VALUE;
            }
        }
        @Redirect(method = "create", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onCreate(Direction instance) {
            if (instance.equals(EAST)) {
                return EAST_3D_DATA_VALUE;
            } else {
                return UP_3D_DATA_VALUE;
            }
        }

    }

    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleYRoom")
    public abstract static class MixinFitDoubleYRoom {
        @Redirect(method = "fits", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onFits(Direction instance) {
            return UP_3D_DATA_VALUE;
        }

        @Redirect(method = "create", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onCreate(Direction instance) {
            return UP_3D_DATA_VALUE;
        }
    }

    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleYZRoom")
    public abstract static class MixinFitDoubleYZRoom {
        @Redirect(method = "fits", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onFits(Direction instance) {
            if (instance.equals(NORTH)) {
                return NORTH_3D_DATA_VALUE;
            } else {
                return UP_3D_DATA_VALUE;
            }
        }

        @Redirect(method = "create", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onCreate(Direction instance) {
            if (instance.equals(NORTH)) {
                return NORTH_3D_DATA_VALUE;
            } else {
                return UP_3D_DATA_VALUE;
            }
        }
    }

    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitDoubleZRoom")
    public abstract static class MixinFitDoubleZRoom {
        @Redirect(method = "fits", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onFits(Direction instance) {
            return NORTH_3D_DATA_VALUE;
        }

        @Redirect(method = "create", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onCreate(Direction instance) {
            if (instance.equals(NORTH)) {
                return NORTH_3D_DATA_VALUE;
            } else {
                return SOUTH_3D_DATA_VALUE;
            }
        }
    }

    @Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces$FitSimpleTopRoom")
    public abstract static class MixinFitSimpleTopRoom {
        @Redirect(method = "fits", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onFits(Direction instance) {
            if (instance.equals(WEST)) {
                return WEST_3D_DATA_VALUE;
            } else if (instance.equals(NORTH)) {
                return NORTH_3D_DATA_VALUE;
            } else if (instance.equals(EAST)) {
                return EAST_3D_DATA_VALUE;
            } else if (instance.equals(SOUTH)) {
                return SOUTH_3D_DATA_VALUE;
            } else {
                return UP_3D_DATA_VALUE;
            }
        }
    }

    @Mixin(OceanMonumentPieces.MonumentBuilding.class)
    public abstract static class MixinMonumentBuilding {
        @Redirect(method = "generateRoomGraph", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
        private Direction[] onGen() {
            return DIRECTIONS;
        }

        @Redirect(method = "generateRoomGraph", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
        private Direction onGen2() {
            return UP;
        }

        @Redirect(method = "generateRoomGraph", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
        private Direction onGen3() {
            return SOUTH;
        }

        @Redirect(method = "generateRoomGraph", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onGen4(Direction direction) {
            if (direction.equals(EAST)) {
                return EAST_3D_DATA_VALUE;
            } else if (direction.equals(NORTH)) {
                return NORTH_3D_DATA_VALUE;
            } else if (direction.equals(UP)) {
                return UP_3D_DATA_VALUE;
            } else {
                return direction.get3DDataValue();
            }
        }
    }

    @Mixin(OceanMonumentPieces.OceanMonumentDoubleXRoom.class)
    public abstract static class MixinOceanMonumentDoubleXRoom {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onProcess(Direction direction) {
            if (direction.equals(EAST)) {
                return EAST_3D_DATA_VALUE;
            } else if (direction.equals(DOWN)) {
                return DOWN_3D_DATA_VALUE;
            } else if (direction.equals(UP)) {
                return UP_3D_DATA_VALUE;
            } else if (direction.equals(SOUTH)) {
                return SOUTH_3D_DATA_VALUE;
            } else if (direction.equals(NORTH)) {
                return NORTH_3D_DATA_VALUE;
            } else {
                return WEST_3D_DATA_VALUE;
            }
        }
    }


    @Mixin(OceanMonumentPieces.OceanMonumentDoubleXYRoom.class)
    public abstract static class MixinOceanMonumentDoubleXYRoom {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onProcess(Direction direction) {
            if (direction.equals(EAST)) {
                return EAST_3D_DATA_VALUE;
            } else if (direction.equals(DOWN)) {
                return DOWN_3D_DATA_VALUE;
            } else if (direction.equals(UP)) {
                return UP_3D_DATA_VALUE;
            } else if (direction.equals(SOUTH)) {
                return SOUTH_3D_DATA_VALUE;
            } else if (direction.equals(NORTH)) {
                return NORTH_3D_DATA_VALUE;
            } else {
                return WEST_3D_DATA_VALUE;
            }
        }
    }

    @Mixin(OceanMonumentPieces.OceanMonumentDoubleYRoom.class)
    public abstract static class MixinOceanMonumentDoubleYRoom {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onProcess(Direction direction) {
            if (direction.equals(EAST)) {
                return EAST_3D_DATA_VALUE;
            } else if (direction.equals(DOWN)) {
                return DOWN_3D_DATA_VALUE;
            } else if (direction.equals(UP)) {
                return UP_3D_DATA_VALUE;
            } else if (direction.equals(SOUTH)) {
                return SOUTH_3D_DATA_VALUE;
            } else if (direction.equals(NORTH)) {
                return NORTH_3D_DATA_VALUE;
            } else {
                return WEST_3D_DATA_VALUE;
            }
        }
    }

    @Mixin(OceanMonumentPieces.OceanMonumentDoubleYZRoom.class)
    public abstract static class MixinOceanMonumentDoubleYZRoom {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onProcess(Direction direction) {
            if (direction.equals(EAST)) {
                return EAST_3D_DATA_VALUE;
            } else if (direction.equals(DOWN)) {
                return DOWN_3D_DATA_VALUE;
            } else if (direction.equals(UP)) {
                return UP_3D_DATA_VALUE;
            } else if (direction.equals(SOUTH)) {
                return SOUTH_3D_DATA_VALUE;
            } else if (direction.equals(NORTH)) {
                return NORTH_3D_DATA_VALUE;
            } else {
                return WEST_3D_DATA_VALUE;
            }
        }
    }

    @Mixin(OceanMonumentPieces.OceanMonumentDoubleZRoom.class)
    public abstract static class MixinOceanMonumentDoubleZRoom {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onProcess(Direction direction) {
            if (direction.equals(EAST)) {
                return EAST_3D_DATA_VALUE;
            } else if (direction.equals(DOWN)) {
                return DOWN_3D_DATA_VALUE;
            } else if (direction.equals(UP)) {
                return UP_3D_DATA_VALUE;
            } else if (direction.equals(SOUTH)) {
                return SOUTH_3D_DATA_VALUE;
            } else if (direction.equals(NORTH)) {
                return NORTH_3D_DATA_VALUE;
            } else {
                return WEST_3D_DATA_VALUE;
            }
        }
    }

    @Mixin(OceanMonumentPieces.OceanMonumentEntryRoom.class)
    public abstract static class MixinOceanMonumentEntryRoom {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onProcess(Direction direction) {
            if (direction.equals(EAST)) {
                return EAST_3D_DATA_VALUE;
            } else if (direction.equals(NORTH)) {
                return NORTH_3D_DATA_VALUE;
            } else {
                return WEST_3D_DATA_VALUE;
            }
        }
    }

    @Mixin(OceanMonumentPieces.OceanMonumentSimpleRoom.class)
    public abstract static class MixinOceanMonumentSimpleRoom {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onProcess(Direction direction) {
            if (direction.equals(EAST)) {
                return EAST_3D_DATA_VALUE;
            } else if (direction.equals(DOWN)) {
                return DOWN_3D_DATA_VALUE;
            } else if (direction.equals(UP)) {
                return UP_3D_DATA_VALUE;
            } else if (direction.equals(SOUTH)) {
                return SOUTH_3D_DATA_VALUE;
            } else if (direction.equals(NORTH)) {
                return NORTH_3D_DATA_VALUE;
            } else {
                return WEST_3D_DATA_VALUE;
            }
        }
    }

    @Mixin(OceanMonumentPieces.OceanMonumentSimpleTopRoom.class)
    public abstract static class MixinOceanMonumentSimpleTopRoom {
        @Redirect(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
        private int onProcess(Direction direction) {
            if (direction.equals(DOWN)) {
                return DOWN_3D_DATA_VALUE;
            } else if (direction.equals(UP)) {
                return UP_3D_DATA_VALUE;
            } else {
                return SOUTH_3D_DATA_VALUE;
            }
        }
    }
}