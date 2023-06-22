package com.teampotato.redirectionor.mixin.global.up;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = {FallingBlockEntity.class, FireBlock.class}, targets = "net.minecraft.entity.monster.EndermanEntity$PlaceBlockGoal")
public abstract class InTick {
    @Redirect(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp() {
        return Redirectionor.UP;
    }
}
