package com.teampotato.redirectionor.mixin.global.up;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({BaseCoralPlantTypeBlock.class, TorchBlock.class, BasePressurePlateBlock.class, SnowLayerBlock.class, BellBlock.class, CandleBlock.class, DoorBlock.class, FireBlock.class})
public abstract class InCanSurvive {
    @Redirect(method = "canSurvive", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
