package com.teampotato.redirectionor.mixin.global.up;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.KelpBlock;
import net.minecraft.block.KelpTopBlock;
import net.minecraft.block.TwistingVinesBlock;
import net.minecraft.block.TwistingVinesTopBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({TwistingVinesBlock.class, KelpBlock.class, KelpTopBlock.class, TwistingVinesTopBlock.class})
public abstract class InStaticInit {
    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private static Direction implUp() {
        return Redirectionor.UP;
    }
}
