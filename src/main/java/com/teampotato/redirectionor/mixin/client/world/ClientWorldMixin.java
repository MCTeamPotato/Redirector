package com.teampotato.redirectionor.mixin.client.world;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin {
    @Redirect(method = "doAnimateTick", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}
