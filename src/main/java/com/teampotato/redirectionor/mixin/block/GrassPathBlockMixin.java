package com.teampotato.redirectionor.mixin.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.GrassPathBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GrassPathBlock.class)
public abstract class GrassPathBlockMixin {
    @Redirect(method = "updateShape", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp1() {
        return Redirectionor.UP;
    }
}
