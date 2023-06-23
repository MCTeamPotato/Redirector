package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HugeMushroomBlock.class)
public abstract class HugeMushroomBlockMixin {
    @Redirect(method = "rotate", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown1() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "mirror", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown2() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "rotate", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp1() {
        return Redirectionor.UP;
    }

    @Redirect(method = "mirror", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp2() {
        return Redirectionor.UP;
    }

    @Redirect(method = "rotate", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth1() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "mirror", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth2() {
        return Redirectionor.NORTH;
    }

    @Redirect(method = "rotate", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
    private Direction implSouth1() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "mirror", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
    private Direction implSouth2() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "rotate", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
    private Direction implWest1() {
        return Redirectionor.WEST;
    }

    @Redirect(method = "mirror", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
    private Direction implWest2() {
        return Redirectionor.WEST;
    }

    @Redirect(method = "rotate", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
    private Direction implEast1() {
        return Redirectionor.EAST;
    }

    @Redirect(method = "mirror", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
    private Direction implEast2() {
        return Redirectionor.EAST;
    }
}
