package com.teampotato.redirectionor.mixin.minecraft.tileentity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.tileentity.StructureBlockTileEntity;
import net.minecraft.util.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StructureBlockTileEntity.class)
public abstract class MixinStructureBlockTileEntity {
    @Redirect(method = "load", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;NONE:Lnet/minecraft/util/Rotation;"))
    private Rotation implNone() {
        return Redirectionor.NONE;
    }
}
