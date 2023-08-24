package com.teampotato.redirectionor.mixin.net.minecraft.data.model;

import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockModelGenerators.class)
public abstract class BlockModelGeneratorsMixin {
    @Unique
    static final DripstoneThickness[] DRIPSTONE_THICKNESSES = DripstoneThickness.values();
    @Redirect(method = "createPointedDripstone", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/properties/DripstoneThickness;values()[Lnet/minecraft/world/level/block/state/properties/DripstoneThickness;"))
    private DripstoneThickness[] redirectDripstoneThickness() {
        return DRIPSTONE_THICKNESSES;
    }
}
