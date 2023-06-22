package com.teampotato.redirectionor.mixin.entity.item.minecart;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.entity.item.minecart.FurnaceMinecartEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FurnaceMinecartEntity.class)
public abstract class FurnaceMinecartEntityMixin {
    @Redirect(method = "getDefaultDisplayBlockState", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }
}
