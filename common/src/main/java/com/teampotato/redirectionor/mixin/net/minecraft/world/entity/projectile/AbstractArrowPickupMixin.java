package com.teampotato.redirectionor.mixin.net.minecraft.world.entity.projectile;

import net.minecraft.world.entity.projectile.AbstractArrow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

@Mixin(AbstractArrow.Pickup.class)
public abstract class AbstractArrowPickupMixin {
    @Unique private static final AbstractArrow.Pickup[] redirectionor$PICKUPS = AbstractArrow.Pickup.values();
    @Unique
    private static final int redirectionor$pickupsLength = redirectionor$PICKUPS.length;

    /**
     * @author Kasualix
     * @reason minor cleanup
     */
    @Overwrite
    public static AbstractArrow.Pickup byOrdinal(int ordinal) {
        if (ordinal < 0 || ordinal > redirectionor$pickupsLength) ordinal = 0;
        return redirectionor$PICKUPS[ordinal];
    }
}
