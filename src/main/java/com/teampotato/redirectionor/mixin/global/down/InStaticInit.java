package com.teampotato.redirectionor.mixin.global.down;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.WeepingVinesBlock;
import net.minecraft.block.WeepingVinesTopBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({WeepingVinesBlock.class, WeepingVinesTopBlock.class})
public abstract class InStaticInit {
    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDown() {
        return Redirectionor.DOWN;
    }
}
