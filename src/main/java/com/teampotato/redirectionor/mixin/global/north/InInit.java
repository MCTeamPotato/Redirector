package com.teampotato.redirectionor.mixin.global.north;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({AbstractFurnaceBlock.class, TripWireHookBlock.class, TrapDoorBlock.class, StonecutterBlock.class, AnvilBlock.class, AttachedStemBlock.class, BarrelBlock.class, BaseCoralWallFanBlock.class, BeehiveBlock.class, BellBlock.class, BigDripleafBlock.class, ButtonBlock.class, CampfireBlock.class, CarvedPumpkinBlock.class, ChestBlock.class, CocoaBlock.class, CommandBlock.class, ComparatorBlock.class, DispenserBlock.class, DoorBlock.class, EnderChestBlock.class, EndPortalFrameBlock.class, GrindstoneBlock.class, LadderBlock.class, LecternBlock.class, LeverBlock.class, RedstoneWallTorchBlock.class, RepeaterBlock.class, SmallDripleafBlock.class, StairBlock.class, BigDripleafStemBlock.class, WallBannerBlock.class, WallSignBlock.class, WallSkullBlock.class, WallTorchBlock.class, MovingPistonBlock.class, PistonBaseBlock.class, PistonHeadBlock.class})
public abstract class InInit {
    @Redirect(method = "<init>*", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }
}
