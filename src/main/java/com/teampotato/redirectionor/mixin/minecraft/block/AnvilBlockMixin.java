package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.AnvilBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AnvilBlock.class)
public abstract class AnvilBlockMixin {
    @Redirect(method = "getShape", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;X:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implX() {
        return Redirectionor.X;
    }
}
