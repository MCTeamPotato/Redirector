package com.teampotato.redirectionor.mixin.world.entity.monster;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.monster.Shulker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Shulker.class)
public abstract class ShulkerMixin {
    @Redirect(method = "findAttachableSurface", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirection() {
        return Values.DIRECTIONS;
    }
}
