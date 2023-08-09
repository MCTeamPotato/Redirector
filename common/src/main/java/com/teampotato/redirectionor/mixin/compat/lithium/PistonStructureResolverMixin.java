package com.teampotato.redirectionor.mixin.compat.lithium;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PistonStructureResolver.class)
public abstract class PistonStructureResolverMixin {
    @Redirect(method = "addBranchingBlocks", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirection() {
        return Values.DIRECTIONS;
    }
}
