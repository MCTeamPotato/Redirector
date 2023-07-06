package com.teampotato.redirectionor.mixin.global.down;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ArmorStandItem;
import net.minecraft.world.item.ShovelItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({ArmorStandItem.class, ShovelItem.class})
public abstract class InUseOn {
    @Redirect(method = "useOn", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}
