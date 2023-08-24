package com.teampotato.redirectionor.mixin.net.minecraft.world.level.levelgen.structure.templatesystem;

import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockAgeProcessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockAgeProcessor.class)
public abstract class BlockAgeProcessorMixin {
    @Unique
    static final Half[] redirectionor$HALVES = Half.values();
    @Redirect(method = "getRandomFacingStairs", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/properties/Half;values()[Lnet/minecraft/world/level/block/state/properties/Half;"))
    private static Half[] redirectHalf() {
        return redirectionor$HALVES;
    }
}
