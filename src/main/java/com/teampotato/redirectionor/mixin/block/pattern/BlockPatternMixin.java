package com.teampotato.redirectionor.mixin.block.pattern;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockPattern.class)
public abstract class BlockPatternMixin {
    @Redirect(method = "find", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt() {
        return Redirectionor.DIRECTIONS;
    }
}
