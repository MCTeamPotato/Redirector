package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.state.properties.Half;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TrapDoorBlock.class)
public abstract class TrapDoorBlockMixin {
    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/Half;TOP:Lnet/minecraft/state/properties/Half;"))
    private Half implTop() {
        return Redirectionor.TOP;
    }

    @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/Half;BOTTOM:Lnet/minecraft/state/properties/Half;"))
    private Half implBottom() {
        return Redirectionor.BOTTOM;
    }
}
