package com.teampotato.redirectionor.mixin.global.south;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.structures.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({DesertPyramidPiece.class, JungleTemplePiece.class, NetherFortressPieces.CastleCorridorStairsPiece.class, StrongholdPieces.FiveCrossing.class, StrongholdPieces.Library.class, StrongholdPieces.PortalRoom.class, StrongholdPieces.RoomCrossing.class, StrongholdPieces.StraightStairsDown.class, SwampHutPiece.class})
public abstract class InPostProcess {
    @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }
}
