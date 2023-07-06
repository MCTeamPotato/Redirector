package com.teampotato.redirectionor.mixin.global.east;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({DesertPyramidPiece.class, JunglePyramidPiece.class, NetherBridgePieces.CastleStalkRoom.class, StrongholdPieces.LeftTurn.class, StrongholdPieces.Library.class, StrongholdPieces.PortalRoom.class, StrongholdPieces.RightTurn.class, StrongholdPieces.RoomCrossing.class, StrongholdPieces.Straight.class, SwamplandHutPiece.class})
public abstract class InPostProcess {
    @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
    private Direction implEast() {
        return Redirectionor.EAST;
    }
}
