package com.teampotato.redirectionor.mixin.tileentity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.tileentity.EndGatewayTileEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EndGatewayTileEntity.class)
public abstract class EndGatewayTileEntityMixin {
    @Redirect(method = "getParticleAmount", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return Redirectionor.DIRECTIONS;
    }
}
