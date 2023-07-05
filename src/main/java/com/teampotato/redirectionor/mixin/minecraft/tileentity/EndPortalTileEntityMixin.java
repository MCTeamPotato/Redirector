package com.teampotato.redirectionor.mixin.minecraft.tileentity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.tileentity.EndPortalTileEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EndPortalTileEntity.class)
public abstract class EndPortalTileEntityMixin {
    @Redirect(method = "shouldRenderFace", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
