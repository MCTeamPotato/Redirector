package com.teampotato.redirectionor.mixin.global.west;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.structures.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({DesertPyramidPiece.class, JungleTemplePiece.class, SwampHutPiece.class, NetherFortressPieces.CastleStalkRoom.class, StrongholdPieces.Library.class, StrongholdPieces.PortalRoom.class, StrongholdPieces.PrisonHall.class, StrongholdPieces.RoomCrossing.class, StrongholdPieces.Straight.class})
public abstract class InPostProcess {
    @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;WEST:Lnet/minecraft/core/Direction;"))
    private Direction implWest() {
        return Redirectionor.WEST;
    }
}
