package com.teampotato.redirectionor.mixin.minecraft.tileentity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.tileentity.JigsawTileEntity;
import net.minecraft.util.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(JigsawTileEntity.class)
public abstract class MixinJigsawTileEntity {
    @Redirect(method = "generate", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;NONE:Lnet/minecraft/util/Rotation;"))
    private Rotation implNone() {
        return Redirectionor.NONE;
    }
}
