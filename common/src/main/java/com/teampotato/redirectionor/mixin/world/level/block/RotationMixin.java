package com.teampotato.redirectionor.mixin.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.block.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Rotation.class)
public abstract class RotationMixin {
    @Redirect(method = {"getRandom", "getShuffled"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Rotation;values()[Lnet/minecraft/world/level/block/Rotation;"))
    private static Rotation[] redirectRotation() {
        return Redirectionor.ROTATIONS;
    }
}
