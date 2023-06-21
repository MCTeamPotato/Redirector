package com.teampotato.redirectionor.mixin.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.BambooBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BambooBlock.class)
public abstract class BambooBlockMixin {
    @Redirect(method = "updateShape", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
