package com.teampotato.redirectionor.mixin.gametest.framework;

import com.teampotato.redirectionor.references.RotationReferences;
import net.minecraft.gametest.framework.GameTestServer;
import net.minecraft.world.level.block.Rotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameTestServer.class)
public abstract class GameTestServerMixin {
    @Redirect(method = "startTests", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Rotation;NONE:Lnet/minecraft/world/level/block/Rotation;"))
    private Rotation redirectRotationNONE() {
        return RotationReferences.NONE;
    }
}
