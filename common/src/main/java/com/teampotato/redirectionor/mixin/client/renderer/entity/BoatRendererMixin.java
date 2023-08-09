package com.teampotato.redirectionor.mixin.client.renderer.entity;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BoatRenderer.class)
public abstract class BoatRendererMixin {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/Boat$Type;values()[Lnet/minecraft/world/entity/vehicle/Boat$Type;"))
    private Boat.Type[] redirectBoatType() {
        return Values.BOAT_TYPES;
    }
}
