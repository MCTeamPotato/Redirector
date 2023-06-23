package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.PortalSize;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PortalSize.class)
public abstract class PortalSizeMixin {
    @Redirect(method = "getDistanceUntilEdgeAboveFrame", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown1() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "hasTopFrame", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp1() {
        return Redirectionor.UP;
    }

    @Redirect(method = "getDistanceUntilTop", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp2() {
        return Redirectionor.UP;
    }

    @Redirect(method = "createPortalBlocks", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp3() {
        return Redirectionor.UP;
    }

    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }

    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
    private Direction implWest() {
        return Redirectionor.WEST;
    }
}
