package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.structure.structures;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.structures.NetherFossilStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NetherFossilStructure.class)
public abstract class MixinNetherFossilStructure {
    @Redirect(method = "findGenerationPoint", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp () {
        return Redirectionor.UP;
    }
}
