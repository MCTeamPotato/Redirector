package com.teampotato.redirector.mixin.net.minecraft.world.level.block;

import com.teampotato.redirector.redirect.CommonValues;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.DiodeBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DiodeBlock.class)
public abstract class DiodeBlockMixin {
    @Redirect(method = "neighborChanged", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirections() {
        return CommonValues.DIRECTIONS;
    }
}
