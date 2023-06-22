package com.teampotato.redirectionor.mixin.minecraft.tileentity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.tileentity.HopperTileEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HopperTileEntity.class)
public abstract class HopperTileEntityMixin {
    @Redirect(method = "suckInItems", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDown1() {
        return Redirectionor.DOWN;
    }
}
