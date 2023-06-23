package com.teampotato.redirectionor.mixin.global.east;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.WetSpongeBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WetSpongeBlock.class)
public abstract class InAnimateTick {
    @Redirect(method = "animateTick", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
    private Direction implEast() {
        return Redirectionor.EAST;
    }

}
