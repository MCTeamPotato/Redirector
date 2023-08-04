package com.teampotato.redirectionor.mixin.world.level.block;

import com.teampotato.redirectionor.references.RotationReferences;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Mirror.class)
public abstract class MirrorMixin {
    @Redirect(method = "getRotation", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;NONE:Lnet/minecraft/world/level/block/Rotation;"))
    private Rotation redirectRotationNONE() {
        return RotationReferences.NONE;
    }
}
