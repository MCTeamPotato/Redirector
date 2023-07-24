package com.teampotato.redirectionor.mixin.global.south;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({DesertPyramidPiece.class, JunglePyramidPiece.class, NetherBridgePieces.CastleCorridorStairsPiece.class, StrongholdPieces.FiveCrossing.class, StrongholdPieces.Library.class, StrongholdPieces.PortalRoom.class, StrongholdPieces.RoomCrossing.class, StrongholdPieces.StraightStairsDown.class, SwamplandHutPiece.class})
public abstract class InPostProcess {
    @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }
}
