package com.teampotato.redirectionor.mixin.global.down;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({FallingBlockEntity.class, FireBlock.class})
public abstract class InTick {
    @Redirect(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}
