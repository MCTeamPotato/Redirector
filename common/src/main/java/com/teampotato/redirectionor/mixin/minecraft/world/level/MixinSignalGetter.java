package com.teampotato.redirectionor.mixin.minecraft.world.level;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.SignalGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SignalGetter.class)
public interface MixinSignalGetter {
    @Redirect(method = {"getDirectSignalTo", "hasNeighborSignal"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = {"getDirectSignalTo", "hasNeighborSignal"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;EAST:Lnet/minecraft/core/Direction;"))
    private Direction implEast() {
        return Redirectionor.EAST;
    }

    @Redirect(method = {"getDirectSignalTo", "hasNeighborSignal"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;NORTH:Lnet/minecraft/core/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = {"getDirectSignalTo", "hasNeighborSignal"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;SOUTH:Lnet/minecraft/core/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = {"getDirectSignalTo", "hasNeighborSignal"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;WEST:Lnet/minecraft/core/Direction;"))
    private Direction implWest() {
        return Redirectionor.WEST;
    }

    @Redirect(method = {"getDirectSignalTo", "hasNeighborSignal"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
