package com.teampotato.redirectionor.mixin.world.level.levelgen.structure.templatesystem;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockAgeProcessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockAgeProcessor.class)
public abstract class BlockAgeProcessorMixin {
    @Redirect(method = "getRandomFacingStairs", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/properties/Half;values()[Lnet/minecraft/world/level/block/state/properties/Half;"))
    private static Half[] redirectHalf() {
        return Redirectionor.HALVES;
    }
}
