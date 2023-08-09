package com.teampotato.redirectionor.mixin.world.entity;

import com.teampotato.redirectionor.common.Values;
import net.minecraft.world.entity.RelativeMovement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RelativeMovement.class)
public abstract class RelativeMovementMixin {
    @Redirect(method = "unpack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/RelativeMovement;values()[Lnet/minecraft/world/entity/RelativeMovement;"))
    private static RelativeMovement[] redirectRelativeArgument() {
        return Values.RELATIVE_MOVEMENTS;
    }
}
