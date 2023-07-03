package com.teampotato.redirectionor.mixin.minecraft.world.entity.animal;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.world.entity.animal.Parrot$ParrotWanderGoal")
public abstract class MixinParrot {
    @Redirect(method = "getTreePos", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
