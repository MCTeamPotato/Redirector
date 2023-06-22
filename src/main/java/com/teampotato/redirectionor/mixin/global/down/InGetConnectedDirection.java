package com.teampotato.redirectionor.mixin.global.down;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.BellBlock;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.block.LanternBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({BellBlock.class, HorizontalFaceBlock.class, LanternBlock.class})
public abstract class InGetConnectedDirection {
    @Redirect(method = "getConnectedDirection", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDown3() {
        return Redirectionor.DOWN;
    }
}
