package com.teampotato.redirectionor.mixin.minecraft.world.level.levelgen.structure.structures;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.NetherFossilFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NetherFossilFeature.class)
public abstract class MixinNetherFossilStructure {
    @Redirect(method = "pieceGeneratorSupplier", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private static Direction implUp() {
        return Redirectionor.UP;
    }
}
