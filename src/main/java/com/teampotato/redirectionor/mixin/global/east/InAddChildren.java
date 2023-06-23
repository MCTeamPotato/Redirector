package com.teampotato.redirectionor.mixin.global.east;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.structure.MineshaftPieces;
import net.minecraft.world.gen.feature.structure.StrongholdPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({MineshaftPieces.Corridor.class, MineshaftPieces.Cross.class, MineshaftPieces.Room.class, MineshaftPieces.Stairs.class, StrongholdPieces.RightTurn.class})
public abstract class InAddChildren {
    @Redirect(method = "addChildren", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
    private Direction implEast() {
        return Redirectionor.EAST;
    }
}
