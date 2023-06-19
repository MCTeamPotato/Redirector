package com.teampotato.redirectionor.mixin.data;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.data.BlockModelProvider;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockModelProvider.class)
public abstract class BlockModelProviderMixin {//TODO: continue
    @Redirect(method = "createFacingDispatch", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDown1() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "createColumnWithFacing", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown2() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "createDispenserBlock", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown3() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "createHopper", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown4() {
        return Redirectionor.DOWN;
    }
}
