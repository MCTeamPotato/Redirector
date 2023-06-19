package com.teampotato.redirectionor.mixin.tileentity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractFurnaceTileEntity.class)
public abstract class AbstractFurnaceTileEntityMixin {
    @Redirect(method = "getSlotsForFace", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown1() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "canTakeItemThroughFace", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown2() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "getCapability", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"), remap = false)
    private Direction implDown3() {
        return Redirectionor.DOWN;
    }
}
