package com.teampotato.redirectionor.mixin.global.up;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({AbstractCoralPlantBlock.class, AbstractPressurePlateBlock.class, BushBlock.class, CactusBlock.class, SugarCaneBlock.class, TorchBlock.class, BellBlock.class, DoorBlock.class, FireBlock.class, MushroomBlock.class, SnowBlock.class})
public abstract class InCanSurvive {
    @Redirect(method = "canSurvive", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
