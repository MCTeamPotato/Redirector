package com.teampotato.redirectionor.mixin.world.entity.projectile;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.world.entity.projectile.AbstractArrow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractArrow.Pickup.class)
public abstract class AbstractArrowPickupMixin {
    @Redirect(method = "byOrdinal", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/AbstractArrow$Pickup;values()[Lnet/minecraft/world/entity/projectile/AbstractArrow$Pickup;"))
    private static AbstractArrow.Pickup[] redirectAbstractArrowPickup() {
        return Values.PICKUPS;
    }
}
