package com.teampotato.redirectionor.mixin.pathfinding;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.pathfinding.WalkAndSwimNodeProcessor;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WalkAndSwimNodeProcessor.class)
public abstract class WalkAndSwimNodeProcessorMixin {
    @Redirect(method = "getBlockPathType", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Direction;values()[Lnet/minecraft/util/Direction;"))
    private Direction[] implOpt1() {
        return Redirectionor.DIRECTIONS;
    }
}
