package com.teampotato.redirectionor.mixin.global.west;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.structure.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({DesertPyramidPiece.class, FortressPieces.NetherStalkRoom.class, JunglePyramidPiece.class, StrongholdPieces.Library.class, StrongholdPieces.PortalRoom.class, StrongholdPieces.Prison.class, StrongholdPieces.RoomCrossing.class, StrongholdPieces.Straight.class, SwampHutPiece.class})
public abstract class InPostProcess {
    @Redirect(method = "postProcess", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
    private Direction implWest() {
        return Redirectionor.WEST;
    }
}
