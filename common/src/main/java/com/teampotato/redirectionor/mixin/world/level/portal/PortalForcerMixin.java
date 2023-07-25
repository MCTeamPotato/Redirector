package com.teampotato.redirectionor.mixin.world.level.portal;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import net.minecraft.world.level.portal.PortalForcer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PortalForcer.class)
public abstract class PortalForcerMixin {
    @Redirect(method = "createPortal", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$AxisDirection;POSITIVE:Lnet/minecraft/core/Direction$AxisDirection;"))
    private Direction.AxisDirection redirectAxisDirectionPOSITIVE() {
        return DirectionReferences.AxisDirectionReferences.POSITIVE;
    }
}
