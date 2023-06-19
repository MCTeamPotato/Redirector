package com.teampotato.redirectionor.mixin.world.spawner;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.world.spawner.WorldEntitySpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WorldEntitySpawner.class)
public abstract class WorldEntitySpawnerMixin {
    @Redirect(method = "getTopNonCollidingPos", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDown1() {
        return Redirectionor.DOWN;
    }
}
