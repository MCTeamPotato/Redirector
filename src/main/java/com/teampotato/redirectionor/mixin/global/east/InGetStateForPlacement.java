package com.teampotato.redirectionor.mixin.global.east;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({AbstractRailBlock.class, BellBlock.class, FenceBlock.class, PaneBlock.class, TripWireBlock.class, WallBlock.class})
public abstract class InGetStateForPlacement {
    @Redirect(method = "getStateForPlacement", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
    private Direction implEast() {
        return Redirectionor.EAST;
    }
}
