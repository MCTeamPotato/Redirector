package com.teampotato.redirectionor.mixin.net.minecraftforge.common.world;

import net.minecraftforge.common.world.ModifiableStructureInfo;
import net.minecraftforge.common.world.StructureModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = ModifiableStructureInfo.class, remap = false)
public abstract class ModifiableStructureInfoMixin {
    @Unique private static final StructureModifier.Phase[] redirectionor$PHASES = StructureModifier.Phase.values();

    @Redirect(method = "applyStructureModifiers", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/common/world/StructureModifier$Phase;values()[Lnet/minecraftforge/common/world/StructureModifier$Phase;"))
    private StructureModifier.Phase[] redirectStructureModifierPhaseValues() {
        return redirectionor$PHASES;
    }
}
