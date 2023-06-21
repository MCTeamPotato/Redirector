package com.teampotato.redirectionor.mixin.world.gen.feature;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.structure.BasaltDeltasStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BasaltDeltasStructure.class)
public abstract class BasaltDeltasStructureMixin {
    @Redirect(method = "isClear", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private static Direction implUp1() {
        return Redirectionor.UP;
    }
}
