package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HorizontalFaceBlock.class)
public abstract class HorizontalFaceBlockMixin {
    @Redirect(method = "getConnectedDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "getConnectedDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private static Direction implUp() {
        return Redirectionor.UP;
    }

    @Redirect(method = "getStateForPlacement", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/AttachFace;FLOOR:Lnet/minecraft/state/properties/AttachFace;"))
    private AttachFace implFloor() {
        return Redirectionor.FLOOR;
    }

    @Redirect(method = "getStateForPlacement", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/AttachFace;WALL:Lnet/minecraft/state/properties/AttachFace;"))
    private AttachFace implWall() {
        return Redirectionor.WALL;
    }

    @Redirect(method = "getStateForPlacement", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/AttachFace;CEILING:Lnet/minecraft/state/properties/AttachFace;"))
    private AttachFace implCeiling() {
        return Redirectionor.CEILING;
    }
}
