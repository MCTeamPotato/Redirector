package com.teampotato.redirector.mixin.net.minecraft.data.models;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockModelGenerators.class)
public abstract class BlockModelGeneratorsMixin {
    @Redirect(method = "createPointedDripstone", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/properties/DripstoneThickness;values()[Lnet/minecraft/world/level/block/state/properties/DripstoneThickness;"))
    private DripstoneThickness[] redirectDripstoneThickness() {
        return CommonValues.DRIPSTONE_THICKNESSES;
    }
}