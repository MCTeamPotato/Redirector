package com.teampotato.redirectionor.mixin.minecraft.tileentity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.tileentity.ShulkerBoxTileEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShulkerBoxTileEntity.class)
public abstract class ShulkerBoxTileEntityMixin {
    @Redirect(method = "createUnSidedHandler", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"), remap = false)
    private Direction implUp() {
        return Redirectionor.UP;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$AxisDirection;POSITIVE:Lnet/minecraft/util/Direction$AxisDirection;"))
    private Direction.AxisDirection implPositive(){
        return Redirectionor.POSITIVE;
    }
}
