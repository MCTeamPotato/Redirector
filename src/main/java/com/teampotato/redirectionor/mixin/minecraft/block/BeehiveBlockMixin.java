package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BeehiveBlock.class)
public abstract class BeehiveBlockMixin {
    @Redirect(method = "spawnParticle", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;X:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implX() {
        return Redirectionor.X;
    }
}
