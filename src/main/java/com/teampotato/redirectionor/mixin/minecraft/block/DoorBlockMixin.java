package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.DoorBlock;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DoorBlock.class)
public abstract class DoorBlockMixin {
    @Redirect(method = "neighborChanged", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "neighborChanged", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/DoorHingeSide;LEFT:Lnet/minecraft/state/properties/DoorHingeSide;"))
    private DoorHingeSide implLeft() {
        return Redirectionor.LEFT;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/DoorHingeSide;RIGHT:Lnet/minecraft/state/properties/DoorHingeSide;"))
    private DoorHingeSide implRight() {
        return Redirectionor.RIGHT;
    }
}
