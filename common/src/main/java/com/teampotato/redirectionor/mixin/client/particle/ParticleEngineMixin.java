package com.teampotato.redirectionor.mixin.client.particle;

import com.teampotato.redirectionor.references.RenderShapeReferences;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.world.level.block.RenderShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ParticleEngine.class)
public abstract class ParticleEngineMixin {
    @Redirect(method = "crack", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;INVISIBLE:Lnet/minecraft/world/level/block/RenderShape;"))
    private RenderShape redirectRenderShapeINVISIBLE() {
        return RenderShapeReferences.INVISIBLE;
    }
}
