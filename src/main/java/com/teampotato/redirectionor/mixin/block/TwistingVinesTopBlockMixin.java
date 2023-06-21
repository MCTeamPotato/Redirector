package com.teampotato.redirectionor.mixin.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.TwistingVinesTopBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TwistingVinesTopBlock.class)
public class TwistingVinesTopBlockMixin {
    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private static Direction implUp() {
        return Redirectionor.UP;
    }
}
