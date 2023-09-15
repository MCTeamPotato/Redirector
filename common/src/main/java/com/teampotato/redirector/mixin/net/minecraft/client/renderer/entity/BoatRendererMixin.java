package com.teampotato.redirector.mixin.net.minecraft.client.renderer.entity;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BoatRenderer.class)
public abstract class BoatRendererMixin {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/Boat$Type;values()[Lnet/minecraft/world/entity/vehicle/Boat$Type;"))
    private Boat.Type[] redirectBoatTypes() {
        return CommonValues.BOAT_TYPES;
    }
}
