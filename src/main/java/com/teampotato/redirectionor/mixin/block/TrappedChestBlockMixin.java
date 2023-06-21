package com.teampotato.redirectionor.mixin.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.TrappedChestBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TrappedChestBlock.class)
public abstract class TrappedChestBlockMixin {
    @Redirect(method = "getDirectSignal", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
