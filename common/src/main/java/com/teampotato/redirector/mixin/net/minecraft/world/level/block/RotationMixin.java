package com.teampotato.redirector.mixin.net.minecraft.world.level.block;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.level.block.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Rotation.class)
public abstract class RotationMixin {
    @Redirect(method = {"getRandom", "getShuffled"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Rotation;values()[Lnet/minecraft/world/level/block/Rotation;"))
    private static Rotation[] redirectRotations() {
        return CommonValues.ROTATIONS;
    }
}
