package com.teampotato.redirectionor.mixin.entity.item.minecart;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.entity.item.minecart.ChestMinecartEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChestMinecartEntity.class)
public abstract class ChestMinecartEntityMixin {
    @Redirect(method = "getDefaultDisplayBlockState", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }
}
