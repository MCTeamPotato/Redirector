package com.teampotato.redirector.mixin.net.minecraft.client.model.geom;

import com.teampotato.redirector.utils.special.CommonValues;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LayerDefinitions.class)
public abstract class LayerDefinitionsMixin {
    @Redirect(method = "createRoots", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/Boat$Type;values()[Lnet/minecraft/world/entity/vehicle/Boat$Type;"))
    private static Boat.Type[] redirectBoatTypes() {
        return CommonValues.BOAT_TYPES;
    }
}
