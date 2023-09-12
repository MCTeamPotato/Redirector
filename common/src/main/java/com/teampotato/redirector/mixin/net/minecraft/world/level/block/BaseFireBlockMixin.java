package com.teampotato.redirector.mixin.net.minecraft.world.level.block;

import com.teampotato.redirector.redirect.CommonValues;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BaseFireBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BaseFireBlock.class)
public abstract class BaseFireBlockMixin {
    @Redirect(method = "isPortal", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirections() {
        return CommonValues.DIRECTIONS;
    }
}
