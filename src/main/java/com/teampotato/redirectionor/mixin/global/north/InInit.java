package com.teampotato.redirectionor.mixin.global.north;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.structure.OceanMonumentPieces;
import net.minecraft.world.gen.feature.structure.StrongholdPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({AbstractButtonBlock.class, AbstractFurnaceBlock.class, AnvilBlock.class, AttachedStemBlock.class, BarrelBlock.class, BeehiveBlock.class, BellBlock.class, CampfireBlock.class, CarvedPumpkinBlock.class, ChestBlock.class, CocoaBlock.class, CommandBlockBlock.class, ComparatorBlock.class, DeadCoralWallFanBlock.class, DoorBlock.class, EnderChestBlock.class, GrindstoneBlock.class, LadderBlock.class, LecternBlock.class, LeverBlock.class, MovingPistonBlock.class, PistonBlock.class, PistonHeadBlock.class, RedstoneWallTorchBlock.class, RepeaterBlock.class, StonecutterBlock.class, TrapDoorBlock.class, TripWireHookBlock.class, WallBannerBlock.class, WallSignBlock.class, WallSkullBlock.class, WallTorchBlock.class, EndPortalFrameBlock.class, StairsBlock.class, OceanMonumentPieces.Piece.class, StrongholdPieces.Corridor.class})
public abstract class InInit {
    @Redirect(method = "<init>*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }
}
