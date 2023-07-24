package com.teampotato.redirectionor.mixin.minecraft.world.entity.monster;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.monster.EnderMan;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public abstract class MixinEnderMan {

    @Mixin(EnderMan.class)
    public abstract static class MixinMain {

        @Redirect(method = "teleport(DDD)Z", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
        private Direction implDown() {
            return Redirectionor.DOWN;
        }
    }
}
