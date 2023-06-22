package com.teampotato.redirectionor.mixin.global.up;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.DetectorRailBlock;
import net.minecraft.block.LecternBlock;
import net.minecraft.block.TrappedChestBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({DetectorRailBlock.class, LecternBlock.class, TrappedChestBlock.class})
public abstract class InGetDirectSignal {
    @Redirect(method = "getDirectSignal", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
