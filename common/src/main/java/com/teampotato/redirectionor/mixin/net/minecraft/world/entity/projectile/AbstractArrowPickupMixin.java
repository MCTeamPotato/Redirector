package com.teampotato.redirectionor.mixin.net.minecraft.world.entity.projectile;

import net.minecraft.world.entity.projectile.AbstractArrow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractArrow.Pickup.class)
public abstract class AbstractArrowPickupMixin {
    @Unique
    static final AbstractArrow.Pickup[] redirectionor$PICKUPS = AbstractArrow.Pickup.values();
    @Redirect(method = "byOrdinal", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/AbstractArrow$Pickup;values()[Lnet/minecraft/world/entity/projectile/AbstractArrow$Pickup;"))
    private static AbstractArrow.Pickup[] redirectAbstractArrowPickup() {
        return redirectionor$PICKUPS;
    }
}
