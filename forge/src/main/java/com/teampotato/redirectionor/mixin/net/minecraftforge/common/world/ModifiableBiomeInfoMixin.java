package com.teampotato.redirectionor.mixin.net.minecraftforge.common.world;

import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ModifiableBiomeInfo.class, remap = false)
public abstract class ModifiableBiomeInfoMixin {
    @Unique
  private static final BiomeModifier.Phase[] redirectionor$PHASES = BiomeModifier.Phase.values();

    @Redirect(method = "applyBiomeModifiers", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/common/world/BiomeModifier$Phase;values()[Lnet/minecraftforge/common/world/BiomeModifier$Phase;"))
    private BiomeModifier.Phase[] redirectBiomeModifierPhase() {
        return redirectionor$PHASES;
    }
}
