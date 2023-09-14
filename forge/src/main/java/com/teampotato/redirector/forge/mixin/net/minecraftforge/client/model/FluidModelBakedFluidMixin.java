package com.teampotato.redirector.forge.mixin.net.minecraftforge.client.model;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraftforge.client.model.FluidModel$BakedFluid", remap = false)
public abstract class FluidModelBakedFluidMixin {
    @Redirect(method = "buildQuads", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirections() {
        return CommonValues.DIRECTIONS;
    }
}
